package chat.message;

import org.hibernate.validator.constraints.NotBlank;

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
        message.setText(this.text);
        return message;
    }
}
