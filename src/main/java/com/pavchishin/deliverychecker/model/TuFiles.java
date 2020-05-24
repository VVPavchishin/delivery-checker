package com.pavchishin.deliverychecker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TuFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fileTuName;
    private Date fileTuDate;
    private double fileTuPrice;

    public TuFiles() {}

    public TuFiles(String fileTuName, Date fileTuDate, double fileTuPrice) {
        this.fileTuName = fileTuName;
        this.fileTuDate = fileTuDate;
        this.fileTuPrice = fileTuPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileTuName() {
        return fileTuName;
    }

    public void setFileTuName(String fileTuName) {
        this.fileTuName = fileTuName;
    }

    public Date getFileTuDate() {
        return fileTuDate;
    }

    public void setFileTuDate(Date fileTuDate) {
        this.fileTuDate = fileTuDate;
    }

    public double getFileTuPrice() {
        return fileTuPrice;
    }

    public void setFileTuPrice(double fileTuPrice) {
        this.fileTuPrice = fileTuPrice;
    }
}
