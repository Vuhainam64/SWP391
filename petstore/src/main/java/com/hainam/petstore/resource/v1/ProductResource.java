/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.ProductDao;
import com.hainam.petstore.dto.Product;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
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

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchProduct(
            @QueryParam("category") String category,
            @QueryParam("keyword") String keyword,
            @QueryParam("sort_by_price") boolean isSortByPrice,
            @QueryParam("ascending") boolean isAscending) {
        return dao.searchProduct(category, keyword, isSortByPrice, isAscending);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        dao.addProduct(product);

        // Trả về mã HTTP 201 Created và URI cho sản phẩm mới được tạo
        URI uri = UriBuilder.fromPath("product/{id}").build(product.getProductId());
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{productId}")
    public Response deleteProduct(@PathParam("productId") int productId) {
        dao.deleteProduct(productId);

        // Trả về mã HTTP 204 No Content nếu sản phẩm đã được xóa thành công
        return Response.noContent().build();
    }

    @PUT
    @Path("{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("productId") int productId, Product product) {
        if (dao.getProductById(productId) == null) {
            // Nếu không tìm thấy sản phẩm theo ID, trả về mã HTTP 404 Not Found
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // Cập nhật thông tin sản phẩm và trả về mã HTTP 200 OK
            product.setProductId(productId);
            dao.updateProduct(product);
            return Response.ok().build();
        }
    }
    
}
