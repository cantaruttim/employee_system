package br.com.cantarutti.model.perfil;

import br.com.cantarutti.model.enums.Perfil;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class User {

    private static final List<RegraPerfil> regras = List.of(
        user -> user.getUserEmail() != null && user.getUserEmail().endsWith("@empresa.com") 
                ? Perfil.ADMIN 
                : null,

        user -> "cantaruttim".equalsIgnoreCase(user.getUserName()) 
                ? Perfil.ADMIN 
                : null
    );

    private UUID id;
    private String userName;
    private String userEmail;
    private String userPassord;
    private Perfil userPerfil;
    private LocalDate userDateCreate;

    public User(UUID id, String userName, String userEmail, String userPassord, LocalDate userDateCreate) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassord = userPassord;
        this.userDateCreate = userDateCreate;

        this.userPerfil = definirPerfilAutomaticamente();
    }

    public UUID getUserId() { return id; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassord; }
    public Perfil getUserPerfil() { return userPerfil; }
    public LocalDate getUserDateCreate() { return userDateCreate; }

    public void setUserId(UUID id) { this.id = id; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserPassword(String userPassord) { this.userPassord = userPassord; }
    public void setUserPerfil(Perfil userPerfil) { this.userPerfil = userPerfil; }
    public void setUserDateCreate(LocalDate userDateCreate) { this.userDateCreate = userDateCreate; }

    private Perfil definirPerfilAutomaticamente() {
        for (RegraPerfil regra : regras) {
            Perfil resultado = regra.verificar(this);
            if (resultado != null) {
                return resultado;
            }
        }
        return Perfil.USER; // padrão
    }

    interface RegraPerfil {
        Perfil verificar(User user);
    }
}
