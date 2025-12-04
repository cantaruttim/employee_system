package br.com.cantarutti.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cantarutti.model.user.User;;

public interface UserRepository extends JpaRepository<User, UUID> {}
