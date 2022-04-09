package commands.misc;

import commands.Argument;
import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.HashMap;

public class Add extends Command {

    public Add() {
        super("add", "add (integer) (integer)", "Adds two integers together.");
        HashMap<String, Argument> arguments = new HashMap<String, Argument>();
        arguments.put("integerOne", Argument.INTEGER);
        arguments.put("integerTwo", Argument.INTEGER);
        setArguments(arguments);
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond(
                        new EmbedBuilder()
                                .setTitle("Success!")
                                .setDescription(String.valueOf( (Integer) arguments.get("integerOne") + (Integer) arguments.get("integerTwo")))
                                .setColor(Color.GREEN)
                                .build()
                )
                .queue();
    }
}
