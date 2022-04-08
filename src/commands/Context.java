package commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Context {

    private final MessageReceivedEvent event;

    public Context(MessageReceivedEvent messageReceivedEvent) {
        this.event = messageReceivedEvent;
    }

    public void respond(String content) {
        getChannel().sendMessage(content).queue();
    }

    public void respond(MessageEmbed embed) {
        getChannel().sendMessageEmbeds(embed).queue();
    }

    public void respond(Message message) {
        getChannel().sendMessage(message).queue();
    }

    public MessageReceivedEvent getEvent() {
        return event;
    }

    public MessageChannel getChannel() {
        return event.getChannel();
    }

    public User getAuthor() {
        return event.getAuthor();
    }

    public Member getMember() {
        return event.getMember();
    }

    public ChannelType getChannelType() {
        return event.getChannelType();
    }

    public Message getMessage() {
        return event.getMessage();
    }

    public Guild getGuild() {
        return event.getGuild();
    }

    public GuildChannel getGuildChannel() {
        return event.getGuildChannel();
    }

    public JDA getJDA() {
        return event.getJDA();
    }

    public String getMessageId() {
        return event.getMessageId();
    }

    public long getMessageIdLong() {
        return event.getMessageIdLong();
    }

    public NewsChannel getNewsChannel() {
        return event.getNewsChannel();
    }

    public PrivateChannel getPrivateChannel() {
        return event.getPrivateChannel();
    }

    public long getResponseNumber() {
        return event.getResponseNumber();
    }

    public TextChannel getTextChannel() {
        return event.getTextChannel();
    }

    public ThreadChannel getThreadChannel() {
        return event.getThreadChannel();
    }

    public boolean isFromGuild() {
        return event.isFromGuild();
    }

    public String toString() {
        return event.toString();
    }

    public boolean isWebhookMessage() {
        return event.isWebhookMessage();
    }

}
