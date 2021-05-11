package ru.netology.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.netology.demo.configJwt.JwtTokenUtil;
import ru.netology.demo.model.UserDTO;
import ru.netology.demo.service.JwtUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private static final Logger log =  LoggerFactory.getLogger(JwtAuthenticationController.class);

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO, HttpServletRequest request) throws Exception {

        var ip = request.getRemoteAddr();
        var hostname = request.getRemoteHost();
        var useragent = request.getHeader("User-Agent");

        log.info("Login attemp. ip: " + ip + " hostname: " + hostname + " User-Agent: " + useragent);

        System.out.println("Пришёл клиент с login/password - " + userDTO.getLogin() + "/" + userDTO.getPassword());

        authenticate(userDTO.getLogin(), userDTO.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getLogin());

        log.info("User Details: " + userDetails);

        final String token = jwtTokenUtil.generateToken(userDetails);

        log.info("Successful login. Access granted for user: " + userDTO.getLogin() + " token: " + token);

        HashMap<String, String> map = new HashMap<>();

        map.put("auth-token", token);

        return ResponseEntity.ok().body(map);
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
