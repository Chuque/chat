package chat.message;

import chat.user.User;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
