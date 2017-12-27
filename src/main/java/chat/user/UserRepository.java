package chat.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {


    ArrayList<User> getAllUsers();

}
