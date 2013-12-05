/*
 */
package com.airhacks.ancienthistory;

/**
 *
 * @author adam-bien.com
 */
public class XMasWishList implements WishList {

    public boolean createWish(String wish) {
        return "lego".equalsIgnoreCase(wish);
    }

}
