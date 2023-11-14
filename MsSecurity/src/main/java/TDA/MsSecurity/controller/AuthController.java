package TDA.MsSecurity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDA.MsSecurity.model.modelUsuario;
import TDA.MsSecurity.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping
    public ResponseEntity<List<modelUsuario>> getAllUsers() {
        List<modelUsuario> users = authService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public modelUsuario getUserById(@PathVariable int id) {
        return authService.getUserById(id);
    }
}

