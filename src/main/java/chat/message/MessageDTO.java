package chat.message;

import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

public class MessageDTO {

    @NotBlank
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message buildMessage() {
        Message message = new Message();
//        message.setId(UUID.randomUUID());
        message.setText(this.text);
        return message;
    }
}
