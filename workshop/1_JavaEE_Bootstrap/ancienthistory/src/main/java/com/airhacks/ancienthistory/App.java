package com.airhacks.ancienthistory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        WishListService list = (WishListService) Naming.lookup("rmi://localhost:4299/xmas");
        System.out.println("Works? " + list.createWish("lego") + " who is it: " + list.getClass().getName());
    }
}
