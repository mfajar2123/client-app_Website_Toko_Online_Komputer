/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Kategori;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ilham
 */

@Service
@AllArgsConstructor
public class KategoriService {
    
    private RestTemplate restTemplate;
    
    public List<Kategori> getAll() {
        return restTemplate.exchange("http://localhost:8088/kategori", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Kategori>>() {
        }).getBody();
    }

    public Kategori create(Kategori kategori) {
        return restTemplate.exchange("http://localhost:8088/kategori", HttpMethod.POST, new HttpEntity(kategori),
                new ParameterizedTypeReference<Kategori>() {
        }).getBody();
    }

    public Kategori delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/kategori/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Kategori>() {
        }).getBody();
    }

    public Kategori update(Long id, Kategori kategori) {
        return restTemplate.exchange("http://localhost:8088/kategori/"+ id, HttpMethod.PUT, new HttpEntity(kategori),
                new ParameterizedTypeReference<Kategori>() {
                }).getBody();
    }

    public Kategori getById(Long id) {
        return restTemplate.exchange("http://localhost:8088/kategori/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Kategori>() {
        }).getBody();
    }
}
