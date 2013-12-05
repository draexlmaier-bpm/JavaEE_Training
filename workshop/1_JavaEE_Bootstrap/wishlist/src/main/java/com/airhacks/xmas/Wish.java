/*
 */
package com.airhacks.xmas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam-bien.com
 */
@Table(name = "AIR_WISH")
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Wish {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amount;
    @Transient
    private List<Item> items;

    public Wish(String name, int amount) {
        this();
        this.name = name;
        this.amount = amount;
        this.items = new ArrayList<>();
        this.items.add(new Item("mindstorms"));

    }

    public int getId() {
        return id;
    }

    public Wish() {
    }

    @Override
    public String toString() {
        return "Wish{" + "name=" + name + ", amount=" + amount + ", items=" + items + '}';
    }

}
