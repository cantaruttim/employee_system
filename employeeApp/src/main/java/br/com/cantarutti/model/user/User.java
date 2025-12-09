package br.com.cantarutti.model.user;

import br.com.cantarutti.model.enums.Perfil;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    private static final List<PerfilRule> rules = List.of(
        user -> user.getUserEmail() != null && user.getUserEmail().endsWith("@empresa.com") 
                ? Perfil.ADMIN 
                : null,

        user -> "cantaruttim".equalsIgnoreCase(user.getUserName()) 
                ? Perfil.ADMIN 
                : null
    );

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String userName;
    private String userEmail;
    private String userPassword;
    private Perfil userPerfil;
    private LocalDate userDateCreate;

    public User(UUID userId, String userName, String userEmail, String userPassword, LocalDate userDateCreate) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDateCreate = userDateCreate;

        this.userPerfil = definePerfilAutomatic();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setId(UUID id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Perfil getUserPerfil() {
        return userPerfil;
    }

    public void setUserPerfil(Perfil userPerfil) {
        this.userPerfil = userPerfil;
    }

    public LocalDate getUserDateCreate() {
        return userDateCreate;
    }

    public void setUserDateCreate(LocalDate userDateCreate) {
        this.userDateCreate = userDateCreate;
    }

    private Perfil definePerfilAutomatic() {
        for (PerfilRule rule : rules) {
            Perfil result = rule.verify(this);
            if (result != null) {
                return result;
            }
        }
        return Perfil.USER; // padrão
    }

    interface PerfilRule {
        Perfil verify(User user);
    }
}
