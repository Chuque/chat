package chat.message;

import chat.message.dtos.NewMessageDTO;
import chat.response.Response;
import chat.user.User;
import chat.user.UserService;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<Response<NewMessageDTO>> postMessage(@Valid @RequestBody NewMessageDTO newMessageDTO, BindingResult result) throws NoSuchAlgorithmException{
        Response<NewMessageDTO> response = new Response<>();

        validateUser(newMessageDTO, result);

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Message message = newMessageDTO.buildMessage();

        newMessageDTO = buildNewMessageDto(messageService.saveMessage(message));

        response.setData(newMessageDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<String> getMessages() {
        //TODO retornar lista de mensagens
//        return Collections.emptyList();
        throw new UnsupportedOperationException();
    }

    /**
     * Check if user exists on database
     * @param newMessageDTO
     * @param result
     */
    private void validateUser(NewMessageDTO newMessageDTO, BindingResult result){
        //TODO check if user exists on database
        Optional<User> user = userService.findUserById(newMessageDTO.getUserId());

    }

    private NewMessageDTO buildNewMessageDto(Message message){
        NewMessageDTO newMessageDTO = new NewMessageDTO();
        newMessageDTO.setText(message.getText());
//        newMessageDTO.setUserId(message.);

        return newMessageDTO;
    }
}
