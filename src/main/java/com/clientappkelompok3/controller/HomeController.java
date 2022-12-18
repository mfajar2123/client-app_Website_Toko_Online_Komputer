/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller;

import com.clientappkelompok3.service.KategoriService;
import com.clientappkelompok3.service.ProdukService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ilham
 */
@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private ProdukService produkService;
    private KategoriService kategoriService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("produk", produkService.getAll());
        model.addAttribute("kategori", kategoriService.getAll());
        return "index";
    }
}
