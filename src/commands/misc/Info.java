package commands.misc;

import commands.Command;
import commands.Context;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.HashMap;

public class Info extends Command {

    public Info() {
        super("info");
    }

    @Override
    public void execute(Context context, HashMap<String, Object> arguments) {
        context.respond(
                new EmbedBuilder()
                        .setTitle("Information")
                        .setDescription("This is a bot made by Keenan.")
                        .setColor(Color.GREEN)
                        .build()
        )
                .setActionRows(ActionRow.of(Button.link("https://github.com/knguyen5259/KeenanBot", "GitHub")))
                .queue();
    }

}
