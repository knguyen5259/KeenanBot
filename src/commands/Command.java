package commands;

import java.util.HashMap;

public abstract class Command {

    private final String name;
    private HashMap<String, Argument> arguments;
    private String usage;
    private String description;

    public Command(String name, String usage, String description) {
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.arguments = null;
    }

    public Command(String name, String usage, String description, HashMap<String, Argument> arguments) {
        this.name = name;
        this.usage = usage;
        this.description = description;
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

    public String getUsage() {
        return usage;
    }

    public String getDescription() {
        return description;
    }

}