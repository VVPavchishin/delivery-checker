package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GdnFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String originalGdnName;
    private String fileGdnName;
    private Date fileGdnDate;
    private double fileGdnPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tu_files_id")
    private TuFiles tuFile;

    public GdnFiles() {}

    public GdnFiles(String originalGdnName, String fileGdnName, Date fileGdnDate, double fileGdnPrice, TuFiles tuFile) {
        this.originalGdnName = originalGdnName;
        this.fileGdnName = fileGdnName;
        this.fileGdnDate = fileGdnDate;
        this.fileGdnPrice = fileGdnPrice;
        this.tuFile = tuFile;
    }

    public String getTuFiles(){
        return tuFile != null ? tuFile.getFileTuName() : "...";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalGdnName() {
        return originalGdnName;
    }

    public void setOriginalGdnName(String originalGdnName) {
        this.originalGdnName = originalGdnName;
    }

    public String getFileGdnName() {
        return fileGdnName;
    }

    public void setFileGdnName(String fileGdnName) {
        this.fileGdnName = fileGdnName;
    }

    public Date getFileGdnDate() {
        return fileGdnDate;
    }

    public void setFileGdnDate(Date fileGdnDate) {
        this.fileGdnDate = fileGdnDate;
    }

    public double getFileGdnPrice() {
        return fileGdnPrice;
    }

    public void setFileGdnPrice(double fileGdnPrice) {
        this.fileGdnPrice = fileGdnPrice;
    }

    public TuFiles getTuFile() {
        return tuFile;
    }

    public void setTuFile(TuFiles tuFile) {
        this.tuFile = tuFile;
    }
}
