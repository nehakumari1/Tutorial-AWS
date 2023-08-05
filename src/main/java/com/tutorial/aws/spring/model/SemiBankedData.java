package com.tutorial.aws.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Semibanked")
@NoArgsConstructor
@AllArgsConstructor
public class SemiBankedData {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "MONTH")
    private String month;
    @Column(name = "AVERAGE")
    private BigDecimal average;

    @Column(name = "YEAR2005")
    private Integer year2005;

    @Column(name = "YEAR2006")
    private Integer year2006;

    @Column(name = "YEAR2007")
    private Integer year2007;

    @Column(name = "YEAR2008")
    private Integer year2008;
    @Column(name = "YEAR2009")
    private Integer year2009;
    @Column(name = "YEAR2010")
    private Integer year2010;
    @Column(name = "YEAR2011")
    private Integer year2011;
    @Column(name = "YEAR2012")
    private Integer year2012;
    @Column(name = "YEAR2013")
    private Integer year2013;
    @Column(name = "YEAR2014")
    private Integer year2014;
    @Column(name = "YEAR2015")
    private Integer year2015;

   /* public SemiBankedData(String month, BigDecimal average, int year2005, int year2006, int year2007, int year2008, int year2009, int year2010, int year2011, int year2012, int year2013, int year2014, int year2015) {
        this.month = month;
        this.average = average;
        this.year2005 = year2005;
        this.year2006 = year2006;
        this.year2007 = year2007;
        this.year2008 = year2008;
        this.year2009 = year2009;
        this.year2010 = year2010;
        this.year2011 = year2011;
        this.year2012 = year2012;
        this.year2013 = year2013;
        this.year2014 = year2014;
        this.year2015 = year2015;
    }






    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public Integer getYear2005() {
        return year2005;
    }

    public void setYear2005(Integer year2005) {
        this.year2005 = year2005;
    }

    public Integer getYear2006() {
        return year2006;
    }

    public void setYear2006(Integer year2006) {
        this.year2006 = year2006;
    }

    public Integer getYear2007() {
        return year2007;
    }

    public void setYear2007(Integer year2007) {
        this.year2007 = year2007;
    }

    public Integer getYear2008() {
        return year2008;
    }

    public void setYear2008(Integer year2008) {
        this.year2008 = year2008;
    }

    public Integer getYear2009() {
        return year2009;
    }

    public void setYear2009(Integer year2009) {
        this.year2009 = year2009;
    }

    public Integer getYear2010() {
        return year2010;
    }

    public void setYear2010(Integer year2010) {
        this.year2010 = year2010;
    }

    public Integer getYear2011() {
        return year2011;
    }

    public void setYear2011(Integer year2011) {
        this.year2011 = year2011;
    }

    public Integer getYear2012() {
        return year2012;
    }

    public void setYear2012(Integer year2012) {
        this.year2012 = year2012;
    }

    public Integer getYear2013() {
        return year2013;
    }

    public void setYear2013(Integer year2013) {
        this.year2013 = year2013;
    }

    public Integer getYear2014() {
        return year2014;
    }

    public void setYear2014(Integer year2014) {
        this.year2014 = year2014;
    }

    public Integer getYear2015() {
        return year2015;
    }

    public void setYear2015(Integer year2015) {
        this.year2015 = year2015;
    }*/

}

