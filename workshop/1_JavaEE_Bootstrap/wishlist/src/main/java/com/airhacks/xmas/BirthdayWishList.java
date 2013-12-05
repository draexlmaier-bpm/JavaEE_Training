/*
 */
package com.airhacks.xmas;

/**
 *
 * @author adam-bien.com
 */
public class BirthdayWishList implements WishList {

    @Override
    public boolean createWish(String wish) {
        System.out.println("Birthday...");
        return "java9".equalsIgnoreCase(wish);
    }

}
