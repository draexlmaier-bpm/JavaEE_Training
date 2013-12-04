/*
 */
package com.airhacks.xmas.st;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Wish {

    private long id;
    @Size(min = 3, max = 5)
    private String name;
    private int minAge;

    public Wish(String name, int minAge) {
        this.name = name;
        this.minAge = minAge;
    }

    public Wish() {
    }

    public boolean isValid() {
        return minAge <= 3 || !"puzzle".equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        return "Highly optimized: Wish{" + "name=" + name + ", minAge=" + minAge + '}';
    }

}
