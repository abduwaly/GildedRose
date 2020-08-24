package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Product {

    protected String name;
    protected int sellIn;
    protected double quality;
    protected LocalDate creationDate;

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

        double result;
        if(daysBetween <= this.sellIn){
            return this.quality - daysBetween;
        } else {
            result = this.quality - this.sellIn - 2 * (daysBetween-this.sellIn);
        }

        return result < 0 ? 0 : result;
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
