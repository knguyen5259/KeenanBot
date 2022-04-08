package commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandHandler extends ListenerAdapter {

    private final ArrayList<Command> commands;
    private boolean guildOnly = false;

    public CommandHandler() {
        this.commands = new ArrayList<Command>();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        for (Command command : commands) {
            if (guildOnly && !(event.getChannelType() == ChannelType.TEXT))
                return;
            else if (event.getMessage().getContentRaw().equals(command.getName()))
                command.execute(new Context(event));
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

}
