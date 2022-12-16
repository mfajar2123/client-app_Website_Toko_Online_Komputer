/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Role;
import com.clientappkelompok3.model.Pengguna;
import com.clientappkelompok3.service.RoleService;
import com.clientappkelompok3.service.PenggunaService;
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
@RequestMapping("/pengguna")
public class PenggunaController {

    private PenggunaService penggunaService;
    private RoleService roleService;
    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("role", roleService.getAll());
        model.addAttribute("pengguna", penggunaService.getAll());
        return "pengguna/index";
    }

    @GetMapping("/create")
    public String createView(Pengguna pengguna, Model model, Role role) {
        model.addAttribute("role", roleService.getAll());
        return "pengguna/create-form";
    }

    @PostMapping
    public String create(Pengguna pengguna) {
        penggunaService.create(pengguna);
        return "redirect:/pengguna";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id, Pengguna pengguna) {
        model.addAttribute("pengguna", penggunaService.getById(id, pengguna));
        return "pengguna/info-form";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, Pengguna pengguna, Model model) {
        model.addAttribute("pengguna", penggunaService.getById(id,pengguna));
        model.addAttribute("role", roleService.getAll());
        return "pengguna/update-form";
    }

    @PutMapping("/{id}")
    public String Update(@PathVariable Long id, Pengguna pengguna) {
        penggunaService.update(id, pengguna);
        return "redirect:/pengguna";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        penggunaService.delete(id);
        return "redirect:/pengguna";
    }
}