/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Pengguna;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ilham
 */
public class PenggunaService {
    private RestTemplate restTemplate;
    
    public List<Pengguna> getAll() {
        return restTemplate.exchange("http://localhost:8088/pengguna", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Pengguna>>() {
        }).getBody();
    }

    public Pengguna create(Pengguna pengguna) {
        return restTemplate.exchange("http://localhost:8088/pengguna", HttpMethod.POST, new HttpEntity(pengguna),
                new ParameterizedTypeReference<Pengguna>() {
        }).getBody();
    }

    public Pengguna delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/pengguna/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Pengguna>() {
        }).getBody();
    }

    public Pengguna update(Long id, Pengguna pengguna) {
        return restTemplate.exchange("http://localhost:8088/pengguna/"+ id, HttpMethod.PUT, new HttpEntity(pengguna),
                new ParameterizedTypeReference<Pengguna>() {
                }).getBody();
    }

    public Pengguna getById(Long id) {
        return restTemplate.exchange("http://localhost:8088/pengguna/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Pengguna>() {
        }).getBody();
    }
}
