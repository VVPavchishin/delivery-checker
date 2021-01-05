package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tuFile")
    private Set<GdnFiles> gdnFiles;

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

    public Set<GdnFiles> getGdnFiles() {
        return gdnFiles;
    }

    public void setGdnFiles(Set<GdnFiles> gdnFiles) {
        this.gdnFiles = gdnFiles;
    }
}
