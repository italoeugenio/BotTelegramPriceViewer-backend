package com.italo.santana.telegram_backend.controller;

import com.italo.santana.telegram_backend.infra.security.TokenService;
import com.italo.santana.telegram_backend.models.dtos.AuthenticationDTO;
import com.italo.santana.telegram_backend.models.dtos.LoginResponseDTO;
import com.italo.santana.telegram_backend.models.dtos.RegisterDTO;
import com.italo.santana.telegram_backend.models.entities.UserModel;
import com.italo.santana.telegram_backend.models.repository.UserRepository;
import com.italo.santana.telegram_backend.models.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.fullName(),data.email(), encryptedPassword, data.userRole());
        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
