package commands.misc;

import commands.Argument;
import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.HashMap;

public class True extends Command {

    public True() {
        super("true", "true (boolean)", "Enter true or false.");
        HashMap<String, Argument> arguments = new HashMap<String, Argument>();
        arguments.put("bool", Argument.BOOLEAN);
        setArguments(arguments);
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        String output;

        if ((Boolean) arguments.get("bool"))
            output = "You selected true!";
        else
            output = "You selected false.";

        context.respond(
                        new EmbedBuilder()
                                .setTitle("Success!")
                                .setDescription(output)
                                .setColor(Color.GREEN)
                                .build()
                )
                .queue();
    }

}
