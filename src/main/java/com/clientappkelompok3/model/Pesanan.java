/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.model;

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
public class Pesanan {
    private Long id;
    private String nama;
    private String email;
    private String alamat;
    private Pengguna pengguna;
    private Produk produk;
    private int jumlah;
}
