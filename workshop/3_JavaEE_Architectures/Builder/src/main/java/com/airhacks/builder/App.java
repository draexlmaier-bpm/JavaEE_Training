package com.airhacks.builder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Transporter transporter = new Transporter.Builder().
                withName("rudolph").
                withSpeed(42).
                build();

        Transporter inconsistent = new Transporter.Builder().build();
    }
}
