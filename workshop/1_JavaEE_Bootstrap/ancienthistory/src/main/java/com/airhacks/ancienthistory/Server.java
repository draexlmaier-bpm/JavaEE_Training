/*
 */
package com.airhacks.ancienthistory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author adam-bien.com
 */
public class Server {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(4299);
        registry.rebind("xmas", new WishListServant());
    }

}
