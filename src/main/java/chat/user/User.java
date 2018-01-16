package chat.user;

import chat.message.Message;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;
    private String name;
    @OneToMany(targetEntity = Message.class, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messages;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
