/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hainam.petstore.config;

import com.hainam.petstore.filter.CorsFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author vuhai
 */

//Xài localhost:8080/petstore
//Xài localhost:8080/petstore/api

@ApplicationPath("api")
public class PetApplication extends ResourceConfig{
    //đây là hàm main của api
    //lúc deloy hàm main này lên tom cat sẽ quét qua 1 lượt
    //các class ở package
    //ai gọi api thì class này sẽ phụ trách
    //class này chỉ đứng đón api ko xử lí data
    public PetApplication(){
        packages("com.hainam.petstore.resource");
        register(CorsFilter.class);
    }
}
