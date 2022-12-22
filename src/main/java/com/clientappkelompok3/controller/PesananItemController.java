/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.model.Pesanan;
import com.clientappkelompok3.model.PesananItem;
import com.clientappkelompok3.service.PesananService;
import com.clientappkelompok3.service.PesananItemService;
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
 * @author Fajar
 */
@Controller
@AllArgsConstructor
@RequestMapping("/pesananItem")
public class PesananItemController {

    private PesananItemService pesananItemService;
    private PesananService pesananService;
    private ProdukService produkService;
    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pesanan", pesananService.getAll());
        model.addAttribute("pesananItem", pesananItemService.getAll());
        model.addAttribute("produk", produkService.getAll());
        return "pesananItem/index";
    }

    @GetMapping("/create")
    public String createView(PesananItem pesananItem, Model model, Pesanan pesanan) {
        model.addAttribute("pesanan", pesananService.getAll());
        model.addAttribute("produk", produkService.getAll());
        return "pesananItem/create-form";
    }

    @PostMapping
    public String create(PesananItem pesananItem) {
        pesananItemService.create(pesananItem);
        return "redirect:/pesananItem";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id, PesananItem pesananItem) {
        model.addAttribute("pesananItem", pesananItemService.getById(id));
        return "pesananItem/info-form";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable Long id, PesananItem pesananItem, Model model) {
        model.addAttribute("pesananItem", pesananItemService.getById(id));
        model.addAttribute("pesanan", pesananService.getAll());
        model.addAttribute("produk", produkService.getAll());
        return "pesananItem/update-form";
    }

    @PutMapping("/{id}")
    public String Update(@PathVariable Long id, PesananItem pesananItem) {
        pesananItemService.update(id, pesananItem);
        return "redirect:/pesananItem";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        pesananItemService.delete(id);
        return "redirect:/pesananItem";
    }
}