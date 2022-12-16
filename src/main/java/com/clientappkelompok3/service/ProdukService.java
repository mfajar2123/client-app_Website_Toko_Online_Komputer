/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Produk;
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
@AllArgsConstructor
@Service
public class ProdukService {

    private RestTemplate restTemplate;

    public List<Produk> getAll() {
        return restTemplate.exchange("http://localhost:8088/produk", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Produk>>() {
        }).getBody();
    }
    
    public Produk getById(Long id) {
        return restTemplate.exchange("http://localhost:8088/produk/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Produk>() {
        }).getBody();
    }
    
    public Produk create(Produk produk) {
        return restTemplate.exchange("http://localhost:8088/produk", HttpMethod.POST, new HttpEntity(produk),
                new ParameterizedTypeReference<Produk>() {
        }).getBody();
    }
    
    public Produk delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/produk/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Produk>() {
        }).getBody();
    }

    public Produk update(Long id, Produk produk) {
        return restTemplate.exchange("http://localhost:8088/produk/"+ id, HttpMethod.PUT, new HttpEntity(produk),
                new ParameterizedTypeReference<Produk>() {
                }).getBody();
    }
}