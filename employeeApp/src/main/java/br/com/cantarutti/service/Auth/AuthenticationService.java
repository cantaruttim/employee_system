package br.com.cantarutti.service.Auth;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String authenticate() {
        return  "token";
    }
}
