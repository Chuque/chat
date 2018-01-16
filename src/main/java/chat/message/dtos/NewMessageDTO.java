package chat.message.dtos;

import chat.message.Message;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NewMessageDTO {

    private UUID userId;
    private String text;

    @NotNull(message = "No User UUID provided")
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @NotEmpty(message = "No text provided for the message")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message buildMessage() {
        Message message = new Message();
        message.setText(this.text);
        return message;
    }

}
