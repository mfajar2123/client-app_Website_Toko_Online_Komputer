/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller.api;

import com.clientappkelompok3.model.PesananItem;
import com.clientappkelompok3.service.PesananItemService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author talithazs
 */
@RestController
@RequestMapping("/api/pesananItem")
@AllArgsConstructor
public class PesananItemApiController {
    private PesananItemService pesananItemService;

    @GetMapping
    public List<PesananItem> getAll() {
        return pesananItemService.getAll();
    }
    
    @GetMapping("/{id}")
    public PesananItem getById(@PathVariable Long id, PesananItem pesananItem){
        return pesananItemService.getById(id, pesananItem);
    }
    
    @PostMapping
    public PesananItem create(@RequestBody PesananItem pesananItem){
        return pesananItemService.create(pesananItem);
    }
}
