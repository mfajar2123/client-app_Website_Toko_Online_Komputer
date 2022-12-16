/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ilham
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pengguna {
    private Long id;
    private String username;
    private String password;
    private String nama;
    private String email;
    private String alamat;
    private String no_hp;
    private Boolean isAktif;
    private Role roles;
}