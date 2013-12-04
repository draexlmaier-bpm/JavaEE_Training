package com.airhacks.alittlemapreduce;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        List<Transporter> transporters = new ArrayList<>();
        transporters.add(new Transporter.Builder().withName("duke").withSpeed(42).build());
        transporters.add(new Transporter.Builder().withName("duke").withSpeed(21).build());
        transporters.add(new Transporter.Builder().withName("rudolph").withSpeed(13).build());
        final Predicate<? super Transporter> name = f -> "duke".equalsIgnoreCase(f.getName());

        OptionalDouble average = transporters.parallelStream().filter(name).
                mapToInt(m -> m.getSpeed()).average();
        double asDouble = average.getAsDouble();
        System.out.println("Double: " + asDouble);
    }
}
