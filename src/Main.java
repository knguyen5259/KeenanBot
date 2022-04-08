import commands.CommandHandler;
import commands.misc.Ping;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault("OTI5ODMwNDI2Njk5MjY0MTUx.YdtCEQ.j3o9E4e0R1VuFla-izOkyf30GRc")
                .setActivity(Activity.listening("to your commands."))
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .addEventListeners(
                        new CommandHandler()
                                .addCommand(new Ping())
                )
                .build();
    }
}