package commands.misc;

import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.Color;

public class Ping extends Command {

    public Ping() {
        super("ping");
    }

    @Override
    public void execute(Context context) {
        context.respond(
                new EmbedBuilder()
                        .setTitle("Success!")
                        .setDescription("Pong!")
                        .setColor(Color.GREEN)
                        .build()
        );
    }
}
