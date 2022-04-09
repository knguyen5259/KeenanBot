package commands;

import java.util.HashMap;

public abstract class Command {

    private final String name;
    private HashMap<String, Argument> arguments;

    public Command(String name) {
        this.name = name;
        this.arguments = null;
    }

    public Command(String name, HashMap<String, Argument> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Argument> getArguments() {
        return arguments;
    }

    public abstract void execute(Context context, HashMap<String, Object> arguments);

    public void setArguments(HashMap<String, Argument> arguments) {
        this.arguments = arguments;
    }

}