/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;
import com.clientappkelompok3.model.PesananItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author MSI-JO
 */
@Service
public class PesananItemService {

    private RestTemplate restTemplate;

    @Autowired
    public PesananItemService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/pesananItem")
    private String url;

    public List<PesananItem> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic ZmFqYXI6ZmFqYXI=");// Khalisa (Basic Authentication) username:password
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
                new ParameterizedTypeReference<List<PesananItem>>() {
                }).getBody();
    }

    public PesananItem getById(Long id) {
        return restTemplate.exchange(url + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }

    public PesananItem create(PesananItem pesananItem) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(pesananItem),
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }

    public PesananItem update(Long id, PesananItem pesananItem) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT, new HttpEntity(pesananItem),
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }

    public PesananItem delete(Long id) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<PesananItem>() {
                }).getBody();
    }
}