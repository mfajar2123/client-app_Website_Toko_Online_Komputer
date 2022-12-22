/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller.api;

import com.clientappkelompok3.model.Pesanan;
import com.clientappkelompok3.service.PesananService;
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
@RequestMapping("/api/pesanan")
@AllArgsConstructor
public class PesananApiController {
    private PesananService pesananService;

    @GetMapping
    public List<Pesanan> getAll() {
        return pesananService.getAll();
    }
    
     @GetMapping("/{id}")
    public Pesanan getById(@PathVariable Long id, Pesanan pesanan){
        return pesananService.getById(id, pesanan);
    }
    
    @PostMapping
    public Pesanan create(@RequestBody Pesanan pesanan){
        return pesananService.create(pesanan);
    }
    
    @PutMapping("/{id}")
    public Pesanan update(@PathVariable Long id, @RequestBody Pesanan pesanan){
        return pesananService.update(id,pesanan);
    }
    
    @DeleteMapping("/{id}")
    public Pesanan delete(@PathVariable Long id){
        return pesananService.delete(id);
    }
}
