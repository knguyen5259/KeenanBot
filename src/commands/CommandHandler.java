package commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandHandler extends ListenerAdapter {

    private final String prefix;
    private final ArrayList<Command> commands;
    private boolean guildOnly = false;
    private final Pattern idPattern;

    public CommandHandler(String prefix) {
        this.prefix = prefix;
        this.commands = new ArrayList<Command>();
        this.idPattern = Pattern.compile("([0-9]+)");
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        for (Command command : commands) {
            if ((guildOnly && !(event.getChannelType() == ChannelType.TEXT)))
                return;
            else if (event.getMessage().getContentRaw().startsWith(prefix + command.getName())) {
                if (command.getArguments() == null) {
                    command.execute(new Context(event), null);
                    return;
                }

                String[] arguments = event.getMessage().getContentRaw().split(" ");

                if (command.getArguments().size() + 1 > arguments.length)
                    event.getTextChannel().sendMessage("Too litte arguments.").queue();
                else if (command.getArguments().size() + 1 < arguments.length)
                    event.getTextChannel().sendMessage("Too many arguments").queue();
                else {
                    HashMap<String, Object> args = new HashMap<String, Object>();
                    int counter = 1;
                    for (Entry<String, Argument> a : command.getArguments().entrySet()) {
                        if (a.getValue() == Argument.STRING)
                            args.put(a.getKey(), arguments[counter]);
                        else if (a.getValue() == Argument.INTEGER)
                            try {
                                args.put(a.getKey(), Integer.parseInt(arguments[counter]));
                            } catch (Exception ignored) {
                                event.getTextChannel().sendMessage("Failed to parse integer argument").queue();
                                return;
                            }
                        else if (a.getValue() == Argument.BOOLEAN)
                            try {
                                args.put(a.getKey(), Boolean.parseBoolean(arguments[counter]));
                            } catch (Exception ignored) {
                                event.getTextChannel().sendMessage("Failed to parse boolean argument").queue();
                                return;
                            }
                        else if (a.getValue() == Argument.MEMBER)
                            try {
                                Matcher matcher = idPattern.matcher(arguments[counter]);
                                matcher.find();
                                Member member = event.getGuild().getMemberById(matcher.group(1));
                                if (member == null) {
                                    event.getTextChannel().sendMessage("Failed to parse member argument").queue();
                                    return;
                                }
                                args.put(a.getKey(), member);
                            } catch (Exception ignored) {
                                event.getTextChannel().sendMessage("Failed to parse member argument").queue();
                                return;
                            }
                        counter++;
                    }
                    command.execute(new Context(event), args);
                }
            }
        }
    }

    public CommandHandler addCommand(Command command) {
        commands.add(command);
        return this;
    }

    public boolean isGuildOnly() {
        return guildOnly;
    }

    public void setGuildOnly(boolean guildOnly) {
        this.guildOnly = guildOnly;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public String getPrefix() {
        return prefix;
    }

}
