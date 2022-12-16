/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.model;

import java.math.BigDecimal;
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
public class Produk {
    private Long id;
    private String nama;
    private String gambar;
    private BigDecimal harga;
    private Kategori kategori;
}
