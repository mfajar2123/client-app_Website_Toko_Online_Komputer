/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller.api;

import com.clientappkelompok3.model.Kategori;
import com.clientappkelompok3.service.KategoriService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author talithazs
 */
@RestController
@RequestMapping("/api/kategori")
@AllArgsConstructor
public class KategoriApiController {
    private KategoriService kategoriService;

    @GetMapping
    public List<Kategori> getAll() {
        return kategoriService.getAll();
    }
    
    @GetMapping("/{id}")
    public Kategori getById(@PathVariable Long id){
        return kategoriService.getById(id);
    }
    
    @PostMapping
    public Kategori create(@RequestBody Kategori kategori){
        return kategoriService.create(kategori);
    }
    
    @PutMapping("/{id}")
    public Kategori update(@PathVariable Long id, @RequestBody Kategori kategori){
        return kategoriService.update(id,kategori);
    }
    
    @DeleteMapping("/{id}")
    public Kategori delete(@PathVariable Long id){
        return kategoriService.delete(id);
    }
}
