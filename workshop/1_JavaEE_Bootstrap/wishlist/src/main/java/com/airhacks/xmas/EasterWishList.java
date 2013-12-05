/*
 */
package com.airhacks.xmas;

/**
 *
 * @author adam-bien.com
 */
@Season(Season.Value.SPRING)
public class EasterWishList implements WishList {

    @Override
    public boolean createWish(String wish) {
        return "egg".equalsIgnoreCase(wish);
    }

}
