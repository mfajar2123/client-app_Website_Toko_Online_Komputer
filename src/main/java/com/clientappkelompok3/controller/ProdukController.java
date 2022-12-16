/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Produk;
import com.clientappkelompok3.service.KategoriService;
import com.clientappkelompok3.service.ProdukService;
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
@RequestMapping("/produk")
public class ProdukController {

    private ProdukService produkService;
    private KategoriService kategoriService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("produk", produkService.getAll());
        model.addAttribute("kategori", kategoriService.getAll());
        return "produk/index";
    }

    @GetMapping("/create")
    public String createView(Produk produk) {
        return "produk/produkAdd";
    }

    @PostMapping
    public String create(Produk produk) {
        produkService.create(produk);
        return "redirect:/produk";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        produkService.delete(id);
        return "redirect:/produk";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, Produk produk, Model model) {
        model.addAttribute("produk", produkService.getById(id));
        model.addAttribute("kategori", kategoriService.getAll());
        return "produk/produkUpdate";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Produk produk) {
        produkService.update(id, produk);
        return "redirect:/produk";
    }
}
