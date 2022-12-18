/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ilham
 */

@Controller
public class AdminController {
    
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
}
