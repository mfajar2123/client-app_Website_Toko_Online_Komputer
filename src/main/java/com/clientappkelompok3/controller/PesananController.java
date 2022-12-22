/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Pengguna;
import com.clientappkelompok3.model.Pesanan;
import com.clientappkelompok3.service.PenggunaService;
import com.clientappkelompok3.service.PesananService;
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
@RequestMapping("/pesanan")
public class PesananController {

    private PesananService pesananService;
    private PenggunaService penggunaService;
    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pengguna", penggunaService.getAll());
        model.addAttribute("pesanan", pesananService.getAll());
        return "pesanan/index";
    }

    @GetMapping("/create")
    public String createView(Pesanan pesanan, Model model, Pengguna pengguna) {
        model.addAttribute("pengguna", penggunaService.getAll());
        return "index";
    }

    @PostMapping
    public String create(Pesanan pesanan) {
        pesananService.create(pesanan);
        return "redirect:/pesanan";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id, Pesanan pesanan) {
        model.addAttribute("pesanan", pesananService.getById(id, pesanan));
        return "pesanan/info-form";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, Pesanan pesanan, Model model) {
        model.addAttribute("pesanan", pesananService.getById(id,pesanan));
        model.addAttribute("pengguna", penggunaService.getAll());
        return "pesanan/update-form";
    }

    @PutMapping("/{id}")
    public String Update(@PathVariable Long id, Pesanan pesanan) {
        pesananService.update(id, pesanan);
        return "redirect:/pesanan";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        pesananService.delete(id);
        return "redirect:/pesanan";
    }
}