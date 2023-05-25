/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.ProductDao;
import com.hainam.petstore.dto.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

/**
 *
 * @author vuhai
 */
@Path("v1/product")
public class ProductResource {

    private ProductDao dao = ProductDao.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return dao.getAllProduct();
    }

    @GET
    @Path("{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("productId") String productId) {
        return dao.getProductById(Integer.parseInt(productId));
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCategories() {
        return dao.getCategories();
    }

    @GET
    @Path("/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductByCategory(@PathParam("category") String category) {
        return dao.getAllProductByCategory(category);
    }

}
