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

    public User(UUID id, String userName, String userEmail, String userPassord) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassord = userPassord;

        this.userPerfil = definirPerfilAutomaticamente();
    }

    private Perfil definirPerfilAutomaticamente() {
        for (RegraPerfil regra : regras) {
            Perfil resultado = regra.verificar(this);
            if (resultado != null) {
                return resultado;
            }
        }
        return Perfil.USER; // padrão
    }

    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }

    interface RegraPerfil {
        Perfil verificar(User user);
    }
}
