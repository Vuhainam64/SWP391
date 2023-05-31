package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.CouponDao;
import com.hainam.petstore.dto.Coupon;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("v1/coupon")
public class CouponResource {

    private CouponDao couponDao = CouponDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCoupon(Coupon coupon) {
        couponDao.createCoupon(coupon);
        URI uri = UriBuilder.fromPath("v1/coupon/{id}").resolveTemplate("id", coupon.getCouponId()).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coupon> getAllCoupons() {
        return couponDao.getAllCoupons();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCouponById(@PathParam("id") int couponId) {
        Coupon coupon = couponDao.getCouponById(couponId);
        if (coupon != null) {
            return Response.ok(coupon).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCoupon(@PathParam("id") int couponId, Coupon updatedCoupon) {
        Coupon coupon = couponDao.getCouponById(couponId);
        if (coupon != null) {
            updatedCoupon.setCouponId(couponId);
            couponDao.updateCoupon(updatedCoupon);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteCoupon(@PathParam("id") int couponId) {
        Coupon coupon = couponDao.getCouponById(couponId);
        if (coupon != null) {
            couponDao.deleteCoupon(couponId);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
