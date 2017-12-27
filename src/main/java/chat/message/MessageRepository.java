package chat.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    public void create(Message message){
        entityManager.persist(message);
    }

    public ArrayList<Message> getAllMessages(){

        Query nativeQuery = entityManager.createNativeQuery("select * from message");
        ArrayList<Message> messages = (ArrayList<Message>) nativeQuery.getResultList();
        return messages;
    }

}
