/*
 */
package com.airhacks.ancienthistory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author adam-bien.com
 */
public class WishListServant extends UnicastRemoteObject implements WishListService {

    private WishList wishList;

    public WishListServant() throws RemoteException {
        super();
        this.wishList = WishListFactory.getInstance().create();
    }

    public boolean createWish(String wish) throws RemoteException {
        return this.wishList.createWish(wish);
    }

}
