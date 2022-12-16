/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientappkelompok3.model;

import java.math.BigDecimal;
import java.util.Date;
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
    private String nomor;
    private Date tanggal;
    private String alamat;
    private int jumlah;
    private BigDecimal total;
    private StatusPesanan statusPesanan;
    private Pengguna pengguna;
}
