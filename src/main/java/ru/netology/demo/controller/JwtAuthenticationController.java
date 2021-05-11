package ru.netology.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.netology.demo.configJwt.JwtTokenUtil;
import ru.netology.demo.model.JwtResponce;
import ru.netology.demo.model.UserDTO;
import ru.netology.demo.service.JwtUserDetailsService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponce> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {

        System.out.println("Пришёл клиент с login/password - " + userDTO.getLogin() + "/"  + userDTO.getPassword());

        authenticate(userDTO.getLogin(), userDTO.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getLogin());

        System.out.println("User Details: " + userDetails);

        final String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println("Token: " + token);

        return ResponseEntity.ok(new JwtResponce(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
