/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Pengguna;
import com.clientappkelompok3.util.BasicHeader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Fajarr
 */
@Service
public class PenggunaService {
    private RestTemplate restTemplate;
    @Autowired
    public PenggunaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/pengguna")
    private String url;


    public List<Pengguna> getAll() {

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<List<Pengguna>>() {
                }).getBody();
    }

    public Pengguna getById(Long id) {

        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,  new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pengguna>() {
                }).getBody();
    }

    public Pengguna create(Pengguna pengguna) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(pengguna, BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pengguna>() {
                }).getBody();
    }

    public Pengguna update(Long id, Pengguna pengguna) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(pengguna, BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pengguna>() {
                }).getBody();
    }

    public Pengguna delete(Long id) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pengguna>() {
                }).getBody();
    }

}