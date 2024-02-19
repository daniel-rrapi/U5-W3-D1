package it.danielrrapi.U5W3D1.servicies;

import it.danielrrapi.U5W3D1.entities.Dipendente;
import it.danielrrapi.U5W3D1.exceptions.UnauthorizedException;
import it.danielrrapi.U5W3D1.payloads.DipendenteLoginDTO;
import it.danielrrapi.U5W3D1.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;
    @Autowired
    private JWTTools jwtTools;

    public String authenticateDipendenteAndGenerateToken(DipendenteLoginDTO payload) {
        Dipendente dipendente = dipendenteService.findByEmail(payload.email());
        if(dipendente.getPassword().equals(payload.password())) {
            return jwtTools.createToken(dipendente);
        } else {
            throw  new UnauthorizedException("Credenziali sbagliate");
        }
    }
}
