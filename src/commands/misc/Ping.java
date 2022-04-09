package commands.misc;

import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.HashMap;

public class Ping extends Command {

    public Ping() {
        super("ping", "ping", "A simple testing command.");
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond(
                new EmbedBuilder()
                        .setTitle("Success!")
                        .setDescription("Pong!")
                        .setColor(Color.GREEN)
                        .build()
        )
                .queue();
    }
}
