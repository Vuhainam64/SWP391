/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hainam.petstore.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vuhai
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {

    private int productId;
    private String productName;
    private String category;
    private String tags;
    private String productDescription;
    private int productPrice;
    private int quantity;
    private boolean isCoupon;
    private String imageMain;
    private String imageSub1;
    private String imageSub2;
    private String imageSub3;
    private String imageSub4;

}
