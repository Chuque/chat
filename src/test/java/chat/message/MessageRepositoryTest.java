package chat.message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    private Message message;

    private Integer id = 235;
    private String text = "lorem ipsum dolor sit amet";

    @Before
    public void setUp() throws Exception{
        message = new Message();
        message.setId(id);
        message.setText(text);

        id = messageRepository.save(message).getId();
    }

    @Test
    public void testSave(){
        Message savedMessage = messageRepository.save(message);

        assertNotNull(savedMessage);
    }

    @Test
    public void testFindById(){
        Message savedMessage = messageRepository.findById(id);

        assertNotNull(savedMessage);
        assertEquals(id, savedMessage.getId());
        assertEquals(text, savedMessage.getText());
    }

//    @After
//    public void tearDown(){
//        this.messageRepository.deleteAll(); //não é necessário quando o ddl-auto está em create-drop
//    }

}
