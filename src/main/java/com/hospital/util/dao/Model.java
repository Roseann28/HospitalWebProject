package com.hospital.util.dao;

public class Model {
    private int[] deleteItems;

    public Model(int[] deleteItems) {
        this.deleteItems = deleteItems;
    }

    public int[] getDeleteItems() {
        return deleteItems;
    }

    public void setDeleteItems(int[] deleteItems) {
        this.deleteItems = deleteItems;
    }
}
