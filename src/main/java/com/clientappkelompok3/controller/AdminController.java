/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ilham
 */

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping
    public String adminHome(){
        return "adminHome";
    }
}
