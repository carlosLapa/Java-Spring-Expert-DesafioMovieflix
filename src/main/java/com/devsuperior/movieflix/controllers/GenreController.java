package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.config.AuthorizationServerConfig;
import com.devsuperior.movieflix.config.customgrant.CustomPasswordAuthenticationToken;
import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.GenreService;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientCredentialsAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAnyRole('ROLE_VISITOR', 'ROLE_MEMBER')")
    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll() {
        List<GenreDTO> list = genreService.findAll();
        return ResponseEntity.ok().body(list);
    }
}