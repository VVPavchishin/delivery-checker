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
    private String originalTuName;
    private String fileTuName;
    private Date fileTuDate;
    private double fileTuPrice;
    private String status;

    public TuFiles() {}

    public TuFiles(String originalTuName, String fileTuName,
                   Date fileTuDate, double fileTuPrice, String status) {
        this.originalTuName = originalTuName;
        this.fileTuName = fileTuName;
        this.fileTuDate = fileTuDate;
        this.fileTuPrice = fileTuPrice;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalTuName() {
        return originalTuName;
    }

    public void setOriginalTuName(String originalTuName) {
        this.originalTuName = originalTuName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
