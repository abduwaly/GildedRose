package com.example.demo.entity;

public class Product {

    private String name;
    private int sellIn;
    private double quality;

    public Product(String name, int sellIn, double quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}
