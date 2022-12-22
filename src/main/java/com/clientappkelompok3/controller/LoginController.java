/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.dto.LoginRequest;
import com.clientappkelompok3.service.LoginService;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fajarr
 */
@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private LoginService LoginService;

    @GetMapping
    public String loginView(LoginRequest loginRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return "auth/login";
        }
        return "redirect:/home";
    }

    @PostMapping
    public String login(LoginRequest loginRequest){
        if (!LoginService.login(loginRequest)) {
            return "redirect:/login?error=true";
        }
        return "redirect:/home";
    }

}