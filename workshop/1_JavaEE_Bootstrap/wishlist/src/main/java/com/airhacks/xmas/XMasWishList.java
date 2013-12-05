/*
 */
package com.airhacks.xmas;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author adam-bien.com
 */
@Season(Season.Value.WINTER)
@Interceptors(Audit.class)
public class XMasWishList implements WishList {

    @Inject
    WishListStore store;

    @Override
    public boolean createWish(String wish) {
        store.add(wish);
        return "lego".equalsIgnoreCase(wish);
    }

}
