/*
 */
package com.airhacks.alittlemapreduce;

/**
 *
 * @author adam-bien.com
 */
public class Transporter {

    private String name;
    private int speed;

    private Transporter() {
    }

    public static class Builder {

        private Transporter t;

        public Builder() {
            this.t = new Transporter();
        }

        public Builder withName(String name) {
            this.t.name = name;
            return this;
        }

        public Builder withSpeed(int speed) {
            this.t.speed = speed;
            return this;
        }

        public Transporter build() {
            if (this.t.name == null || this.t.speed == 0) {
                throw new IllegalStateException("No transporter");
            }
            return t;
        }

    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

}
