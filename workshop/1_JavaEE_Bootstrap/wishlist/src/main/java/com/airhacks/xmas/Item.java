/*
 */
package com.airhacks.xmas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + '}';
    }

}
