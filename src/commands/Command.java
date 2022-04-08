package commands;

public abstract class Command {

    private final String name;
    private final Argument[] arguments;

    public Command(String name) {
        this.name = name;
        this.arguments = null;
    }

    public Command(String name, Argument[] arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public Argument[] getArguments() {
        return arguments;
    }

    public abstract void execute(Context context);
}