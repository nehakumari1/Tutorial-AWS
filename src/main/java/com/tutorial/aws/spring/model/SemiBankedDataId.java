package com.tutorial.aws.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SemiBankedDataId implements Serializable {
    private String month;
    private Double average;

    // Constructors, getters, setters, and hashCode, equals methods
    public SemiBankedDataId(String month, BigDecimal average) {
        // Empty constructor needed by JPA
    }
    public SemiBankedDataId() {
        // You can leave this constructor empty or initialize the fields if needed.
    }
    public SemiBankedDataId(String month, Double average) {
        this.month = month;
        this.average = average;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemiBankedDataId that = (SemiBankedDataId) o;
        return Objects.equals(month, that.month) && Objects.equals(average, that.average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, average);
    }
}

