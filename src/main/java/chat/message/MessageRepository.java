package chat.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Transactional(readOnly = true)
    Message findById(int id);

}
