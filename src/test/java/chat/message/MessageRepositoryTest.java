package chat.message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    private Message message;

    private static final int ID = 2354;
    private static final String TEXT = "lorem ipsum dolor sit amet";

    @Before
    public void setUp() throws Exception{
        this.message = new Message();
        this.message.setId(ID);
        this.message.setText(TEXT);

        this.messageRepository.save(this.message);
    }

    @Test
    public void testFindById(){
        Message message = this.messageRepository.findById(ID);

//        assertEquals(ID, message.getId());
//        assertEquals(TEXT, message.getText());

        assertEquals(this.message, message);
    }

    @After
    public void tearDown(){
        this.messageRepository.deleteAll();
    }

}
