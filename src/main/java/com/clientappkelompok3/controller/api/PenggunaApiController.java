/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.controller.api;

import com.clientappkelompok3.model.Pengguna;
import com.clientappkelompok3.service.PenggunaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author talithazs
 */
@RestController
@RequestMapping("/api/pengguna")
@AllArgsConstructor
public class PenggunaApiController {
    private PenggunaService penggunaService;

    @GetMapping
    public List<Pengguna> getAll() {
        return penggunaService.getAll();
    }
}
