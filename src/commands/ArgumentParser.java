//package commands;
//
//import net.dv8tion.jda.api.JDA;
//import net.dv8tion.jda.api.entities.Member;
//import net.dv8tion.jda.api.entities.User;
//
//import java.util.regex.Pattern;
//
//public class ArgumentParser {
//
//    private final JDA jda;
//    private final Pattern idPattern;
//
//    public ArgumentParser(JDA jda) {
//        this.jda = jda;
//        this.idPattern = Pattern.compile("<@.?([0-9])*?>");
//    }
//
//    public Member parseMember(Context context) {
//        return context.getMessage().getMentionedMembers().get(0);
//    }
//
//}
