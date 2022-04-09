package commands.misc;

import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Help extends Command {

    private final String prefix;
    private final ArrayList<Command> commands;

    public Help(String prefix, ArrayList<Command> commands) {
        super("help", "help", "Provides a list of all the commands.");
        this.prefix = prefix;
        this.commands = commands;
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        ArrayList<EmbedBuilder> embedBuilders = new ArrayList<EmbedBuilder>();

        int index = -1;
        for (Command command : commands) {
            if (embedBuilders.size() % 20 == 0) {
                embedBuilders.add(
                        new EmbedBuilder()
                                .setColor(Color.GREEN)
                );
                index++;
            }
            embedBuilders.get(index)
                    .addField(prefix + command.getUsage(), command.getDescription(), false);
        }

        for (EmbedBuilder embedBuilder : embedBuilders)
            context.respond(embedBuilder.build()).queue();
    }

}
