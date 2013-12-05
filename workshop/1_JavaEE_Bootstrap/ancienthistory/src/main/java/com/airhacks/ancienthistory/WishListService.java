/*
 */
package com.airhacks.ancienthistory;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author adam-bien.com
 */
public interface WishListService extends Remote {

    public boolean createWish(String wish) throws RemoteException;

}
