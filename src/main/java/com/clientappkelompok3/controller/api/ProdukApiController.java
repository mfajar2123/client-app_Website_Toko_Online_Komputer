/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller.api;

import com.clientappkelompok3.model.Produk;
import com.clientappkelompok3.service.ProdukService;
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
@RequestMapping("/api/produk")
@AllArgsConstructor
public class ProdukApiController {
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }
    
    @GetMapping("/{id}")
    public Produk getById(@PathVariable Long id){
        return produkService.getById(id);
    }
    
    @PostMapping
    public Produk create(@RequestBody Produk produk){
        return produkService.create(produk);
    }
    
    @PutMapping("/{id}")
    public Produk update(@PathVariable Long id, @RequestBody Produk produk){
        return produkService.update(id,produk);
    }
    
    @DeleteMapping("/{id}")
    public Produk delete(@PathVariable Long id){
        return produkService.delete(id);
    }
}
