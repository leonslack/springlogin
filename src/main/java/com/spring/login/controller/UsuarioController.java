package com.spring.login.controller;

import com.spring.login.model.User;
import com.spring.login.service.usuario.v1.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuarios")
    @ResponseBody
    public List<User> getAllUsers() {
        return usuarioService.getAllUsers();
    }
}
