/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Kategori;
import com.clientappkelompok3.service.KategoriService;
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
 * @author Ilham
 */
@Controller
@AllArgsConstructor
@RequestMapping("/kategori")
public class KategoriController {

    private KategoriService kategoriService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("kategoris", kategoriService.getAll());
        return "kategori/index";
    }

    @GetMapping("/create")
    public String createView(Kategori kategori) {
        return "kategori/create-form";
    }

    @PostMapping
    public String create(Kategori kategori) {
        kategoriService.create(kategori);
        return "redirect:/kategori";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        kategoriService.delete(id);
        return "redirect:/kategori";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, Kategori kategori, Model model) {
        model.addAttribute("kategoris", kategoriService.getById(id));
        return "kategori/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Kategori kategori){
        kategoriService.update(id, kategori);
        return "redirect:/kategori";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("kategoris", kategoriService.getById(id));
        return "kategori/detail";
    }
    
}
