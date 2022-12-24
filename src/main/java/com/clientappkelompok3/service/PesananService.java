/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.service;

import com.clientappkelompok3.model.Pesanan;
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
public class PesananService {
    private RestTemplate restTemplate;
    @Autowired
    public PesananService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/pesanan")
    private String url;


    public List<Pesanan> getAll() {

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<List<Pesanan>>() {
                }).getBody();
    }

    public Pesanan getById(Long id) {

        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,  new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pesanan>() {
                }).getBody();
    }

    public Pesanan create(Pesanan pesanan) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(pesanan, BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pesanan>() {
                }).getBody();
    }

    public Pesanan update(Long id, Pesanan pesanan) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(pesanan, BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pesanan>() {
                }).getBody();
    }

    public Pesanan delete(Long id) {
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, new HttpEntity(BasicHeader.createHeaders()),
                new ParameterizedTypeReference<Pesanan>() {
                }).getBody();
    }

}