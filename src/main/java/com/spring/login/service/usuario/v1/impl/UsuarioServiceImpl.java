package com.spring.login.service.usuario.v1.impl;

import com.spring.login.model.User;
import com.spring.login.service.usuario.v1.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT id, email, password, name, last_name, role FROM USERS";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, mapper);
    }
}
