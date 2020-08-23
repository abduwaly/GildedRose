package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Product {

    private String name;
    private int sellIn;
    private double quality;
    private LocalDate creationDate;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Product(String name, int sellIn, double quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.creationDate = LocalDate.now();
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

    public double getQuality(LocalDate today) {
        long daysBetween = DAYS.between(this.creationDate, today);
        return this.quality - daysBetween;
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

    public boolean isQualityValid() {
        LocalDate date = LocalDate.now();
        return this.getQuality(date) >= 0 && this.getQuality(date) <= 50;
    }
}
