///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.clientappkelompok3.util;
//
//
//import java.nio.charset.Charset;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
///**
// *
// * @author talithazs
// */
//public class BasicHeader {
//    public static String createHeaders() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String auth = authentication.getName() + ":" + authentication.getCredentials();
//        byte[] encodedAuth = Base64.encodeBase64(
//                auth.getBytes(Charset.forName("US-ASCII")));
//        String authHeader = "Basic " + new String(encodedAuth);
//        return authHeader;
//    }
//}
