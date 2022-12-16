/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Role;
import com.clientappkelompok3.service.RoleService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fajar
 */
@Controller
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "role/index";
    }

    @GetMapping("/create")
    public String createView(Role role) {
        return "role/create-form";
    }

    @PostMapping
    public String create(Role role) {
        roleService.create(role);
        return "redirect:/role";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, Role role) {
        model.addAttribute("role", roleService.getById(id, role));
        return "role/detail";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, Role role, Model model) {
        model.addAttribute("role", roleService.getById(id, role));
        return "role/update-form";
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Role role){
        roleService.update(id, role);
        return "redirect:/role";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        roleService.delete(id);
        return "redirect:/role";
    }

}