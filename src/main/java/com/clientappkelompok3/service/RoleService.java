/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Role;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ilham
 */
public class RoleService {
    private RestTemplate restTemplate;
    
    public List<Role> getAll() {
        return restTemplate.exchange("http://localhost:8088/role", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Role>>() {
        }).getBody();
    }

    public Role create(Role role) {
        return restTemplate.exchange("http://localhost:8088/role", HttpMethod.POST, new HttpEntity(role),
                new ParameterizedTypeReference<Role>() {
        }).getBody();
    }

    public Role delete(Long id) {
        return restTemplate.exchange("http://localhost:8088/role/" + id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Role>() {
        }).getBody();
    }

    public Role update(Long id, Role role) {
        return restTemplate.exchange("http://localhost:8088/role/"+ id, HttpMethod.PUT, new HttpEntity(role),
                new ParameterizedTypeReference<Role>() {
                }).getBody();
    }

    public Role getById(Long id) {
        return restTemplate.exchange("http://localhost:8088/role/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Role>() {
        }).getBody();
    }
}
