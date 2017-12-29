package chat.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findById(int id);

}
