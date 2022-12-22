/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;
import com.clientappkelompok3.model.Role;
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
public class RoleService {

    private RestTemplate restTemplate;

    @Autowired
    public RoleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/role")
    private String url;

    public List<Role> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic ZmFqYXI6ZmFqYXI=");// Khalisa (Basic Authentication) username:password
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
                new ParameterizedTypeReference<List<Role>>() {
                }).getBody();
    }

    public Role getById(Long id) {
        return restTemplate.exchange(url + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Role>() {
                }).getBody();
    }

    public Role create(Role role) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(role),
                new ParameterizedTypeReference<Role>() {
                }).getBody();
    }

    public Role update(Long id, Role role) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT, new HttpEntity(role),
                new ParameterizedTypeReference<Role>() {
                }).getBody();
    }

    public Role delete(Long id) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Role>() {
                }).getBody();
    }
}