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
public class PesananItem {
    private Long id;
    private Pesanan pesanan;
    private Produk produk;
    private int kuantitas;
    private BigDecimal harga;
    private BigDecimal jumlah;
}
