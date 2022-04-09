package commands.misc;

import commands.Argument;
import commands.Command;
import commands.Context;

import java.util.HashMap;

public class Echo extends Command {

    public Echo() {
        super("echo");
        HashMap<String, Argument> arguments = new HashMap<String, Argument>();
        arguments.put("word", Argument.STRING);
        setArguments(arguments);
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond((String) arguments.get("word"))
                .queue();
    }

}
