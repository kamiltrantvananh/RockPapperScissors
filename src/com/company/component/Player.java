package com.company.component;

public class Player {

    private final int id;
    private Item item;

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
