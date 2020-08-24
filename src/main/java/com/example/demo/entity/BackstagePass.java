package com.example.demo.entity;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class BackstagePass extends Product {
    public BackstagePass(String name, int sellIn, double quality) {
        super(name, sellIn, quality);
        this.creationDate = LocalDate.now();
    }

    @Override
    public double getQuality(LocalDate today) {
        long daysBetween = DAYS.between(this.creationDate, today);

        double result = this.quality;
        if(this.sellIn - daysBetween >= 5){
            result = this.quality + daysBetween * 2;
        } else if(this.sellIn - daysBetween < 5){
            if(this.sellIn - daysBetween <= 0){
                result = 0;
            }else {
                result = this.quality + ((daysBetween-5) * 2) + ((5 - (this.sellIn - daysBetween)) * 3);
            }
        }

        return result >= 50 ? 50 : result;
    }
}
