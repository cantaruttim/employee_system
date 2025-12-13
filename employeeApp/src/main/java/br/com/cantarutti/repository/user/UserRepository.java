package br.com.cantarutti.repository.user;

import br.com.cantarutti.model.user.UserEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEmployee, String> {

    Optional<UserEmployee> findByUserNameSystem(String userNameSystem);

}
