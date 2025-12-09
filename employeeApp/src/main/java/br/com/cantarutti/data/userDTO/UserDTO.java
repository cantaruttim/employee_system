package br.com.cantarutti.data.userDTO;
import br.com.cantarutti.model.enums.Perfil;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UserDTO {

    private static final List<PerfilRule> rules = List.of(
        user -> user.getUserEmail() != null && user.getUserEmail().endsWith("@empresa.com") 
                ? Perfil.ADMIN 
                : null,

        user -> "cantaruttim".equalsIgnoreCase(user.getUserName()) 
                ? Perfil.ADMIN 
                : null
    );

    private UUID userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Perfil userPerfil;
    private LocalDate userDateCreate;

    public UserDTO() {}

    public UserDTO(UUID userId, String userName, String userEmail, String userPassword, String userPerfil, LocalDate userDateCreate) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDateCreate = userDateCreate;

        this.userPerfil = definePerfilAutomatic();
    }


    public UUID getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassword; }
    public Perfil getUserPerfil() { return userPerfil; }
    public LocalDate getUserDateCreate() { return userDateCreate; }

    public void setUserId(UUID userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setUserPerfil(Perfil userPerfil) { this.userPerfil = userPerfil; }
    public void setUserDateCreate(LocalDate userDateCreate) { this.userDateCreate = userDateCreate; }

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
        Perfil verify(UserDTO user);
    }

}
    
