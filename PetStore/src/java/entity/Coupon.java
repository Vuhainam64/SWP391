/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author vuhai
 */
import java.util.Date;

public class Coupon {
    private String code;
    private float discountAmount;
    private Date expiryDate;

    public Coupon(String code, float discountAmount, Date expiryDate) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.expiryDate = expiryDate;
    }

    public String getCode() {
        return code;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.before(new Date());
    }
}

