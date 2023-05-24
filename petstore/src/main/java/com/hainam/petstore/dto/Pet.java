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
public class Pet implements Serializable {

    private String isbn;
    private String title;
    private String author;
    private String edition;
    private String publicYear;
    
    
}
