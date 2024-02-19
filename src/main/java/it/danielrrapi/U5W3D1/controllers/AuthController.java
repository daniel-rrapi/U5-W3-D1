package it.danielrrapi.U5W3D1.controllers;

import it.danielrrapi.U5W3D1.entities.Dipendente;
import it.danielrrapi.U5W3D1.payloads.DipendenteLoginDTO;
import it.danielrrapi.U5W3D1.payloads.LoginResponseDTO;
import it.danielrrapi.U5W3D1.payloads.NewDipendenteDTO;
import it.danielrrapi.U5W3D1.servicies.AuthService;
import it.danielrrapi.U5W3D1.servicies.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody DipendenteLoginDTO payload) {
        return new LoginResponseDTO(authService.authenticateDipendenteAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody NewDipendenteDTO newDipendente) {
        return this.dipendenteService.save(newDipendente);
    }
}
