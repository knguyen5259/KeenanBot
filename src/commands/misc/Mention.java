package commands.misc;

import commands.Argument;
import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;

public class Mention extends Command {

    public Mention() {
        super("mention", "mention (member)", "Mentions a member.");
        HashMap<String, Argument> arguments = new HashMap<String, Argument>();
        arguments.put("member", Argument.MEMBER);
        setArguments(arguments);
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond(((Member) arguments.get("member")).getAsMention())
                .queue();
    }

}
