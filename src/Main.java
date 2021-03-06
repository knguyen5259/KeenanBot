import commands.CommandHandler;
import commands.misc.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        CommandHandler commandHandler = new CommandHandler("!")
                .addCommand(new Ping())
                .addCommand(new Info())
                .addCommand(new Echo())
                .addCommand(new Add())
                .addCommand(new True())
                .addCommand(new Mention())
                .addCommand(new Binary());

        JDABuilder.createDefault(Dotenv.load().get("TOKEN"))
                .setActivity(Activity.listening("to your commands."))
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .addEventListeners(
                        commandHandler
                                .addCommand(new Help(commandHandler.getPrefix(), commandHandler.getCommands()))
                )
                .build();
    }
}