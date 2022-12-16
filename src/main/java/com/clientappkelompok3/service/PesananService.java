/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Pesanan;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ilham
 */
public class PesananService {
    private RestTemplate restTemplate;
    
    public List<Pesanan> getAll() {
        return restTemplate.exchange("http://localhost:8088/pesanan", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Pesanan>>() {
        }).getBody();
    }

    public Pesanan create(Pesanan pesanan) {
        return restTemplate.exchange("http://localhost:8088/pesanan", HttpMethod.POST, new HttpEntity(pesanan),
                new ParameterizedTypeReference<Pesanan>() {
        }).getBody();
    }

    public Pesanan delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/pesanan/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Pesanan>() {
        }).getBody();
    }

    public Pesanan update(Long id, Pesanan pesanan) {
        return restTemplate.exchange("http://localhost:8088/pesanan/"+ id, HttpMethod.PUT, new HttpEntity(pesanan),
                new ParameterizedTypeReference<Pesanan>() {
                }).getBody();
    }

    public Pesanan getById(Long id) {
        return restTemplate.exchange("http://localhost:8088/pesanan/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Pesanan>() {
        }).getBody();
    }
}
