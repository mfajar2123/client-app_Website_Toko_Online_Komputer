/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.PesananItem;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Fajarr
 */
@AllArgsConstructor
@Service
public class PesananItemService {

    private RestTemplate restTemplate;

    public List<PesananItem> getAll() {
        return restTemplate.exchange("http://localhost:8088/pesananItem", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PesananItem>>() {
                }).getBody();
    }
    
      public PesananItem getById(Long id, PesananItem pesananItem) {
        return restTemplate.exchange("http://localhost:8088/pesananItem/"+ id, HttpMethod.GET, new HttpEntity(pesananItem),
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }
       public PesananItem delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/pesananItem/"+ id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }
        public PesananItem create(PesananItem pesananItem) {
        return restTemplate.exchange("http://localhost:8088/pesananItem", HttpMethod.POST, new HttpEntity(pesananItem),
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }
       public PesananItem update(Long id, PesananItem pesananItem) {
        return restTemplate.exchange("http://localhost:8088/pesananItem/"+ id, HttpMethod.PUT, new HttpEntity(pesananItem),
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }
}