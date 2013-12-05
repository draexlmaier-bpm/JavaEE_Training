/*
 */
package com.airhacks.ancienthistory;

/**
 *
 * @author adam-bien.com
 */
public class WishListFactory {

    private static final WishListFactory instance = new WishListFactory();
    private String productClass;

    private WishListFactory() {
        productClass = "com.airhacks.ancienthistory.XMasWishList";
    }

    public static WishListFactory getInstance() {
        return instance;
    }

    public WishList create() {
        Class<?> product;
        try {
            product = Class.forName(productClass);
            return (WishList) AOPSupport.aop(product.newInstance());
        } catch (Exception ex) {
            throw new IllegalStateException("No wishes today: " + ex);
        }
    }
}
