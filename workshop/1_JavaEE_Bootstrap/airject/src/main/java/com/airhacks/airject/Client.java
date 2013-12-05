/*
 */
package com.airhacks.airject;

/**
 *
 * @author adam-bien.com
 */
public class Client {

    @AirJect
    private Server server;

    String name;

    @Override
    public String toString() {
        return "Client{" + "server=" + server + '}';
    }

}
