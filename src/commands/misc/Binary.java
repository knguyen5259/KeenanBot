package commands.misc;

import commands.Argument;
import commands.Command;
import commands.Context;

import java.util.HashMap;

public class Binary extends Command {

    public Binary() {
        super("binary", "binary (integer)", "converts a integer into binary");
        HashMap<String, Argument> arguments = new HashMap<String, Argument>();
        arguments.put("integer", Argument.INTEGER);
        setArguments(arguments);
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond(String.valueOf(stringToBinary((int) arguments.get("integer"))))
                .queue();
    }

    public String stringToBinary(int x) {
        String s = "";

        if (x <= 1) {
            s += x;
        } else {
            s += stringToBinary(x / 2);
            s += x % 2;
        }

        return s;
    }

}
