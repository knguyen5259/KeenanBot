import commands.CommandHandler;
import commands.misc.Echo;
import commands.misc.Info;
import commands.misc.Ping;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        System.out.println(System.getenv());
        JDABuilder.createDefault(System.getenv().get("DISCORD_TOKEN"))
                .setActivity(Activity.listening("to your commands."))
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .addEventListeners(
                        new CommandHandler("!")
                                .addCommand(new Ping())
                                .addCommand(new Info())
                                .addCommand(new Echo())
                )
                .build();
    }
}