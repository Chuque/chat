package chat.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    @Transactional
    public void postMessage(@RequestBody MessageDTO messageDTO){
        //TODO save the message on database
    }

//    @GetMapping
//    public List<String> getMessages() {
//        //TODO retornar lista de mensagens
//    }
}
