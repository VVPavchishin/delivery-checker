package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class TuFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String originalTuName;
    private String fileTuName;
    private Date fileTuDate;
    private double fileTuPrice;
    private String status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tuFile")
    private Set<GdnFile> gdnFiles;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "tuFile")
    private List<PartTuFiles> tuLists;

    public TuFile() {}

    public TuFile(String originalTuName, String fileTuName,
                  Date fileTuDate, double fileTuPrice, String status) {
        this.originalTuName = originalTuName;
        this.fileTuName = fileTuName;
        this.fileTuDate = fileTuDate;
        this.fileTuPrice = fileTuPrice;
        this.status = status;
    }

    public void setPartTuFile(PartTuFiles partTuFile) {
        if(tuLists == null) {
            tuLists = new ArrayList<>();
        }
        tuLists.add(partTuFile);
        partTuFile.setTuFile(this);
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

    public Set<GdnFile> getGdnFiles() {
        return gdnFiles;
    }

    public void setGdnFiles(Set<GdnFile> gdnFiles) {
        this.gdnFiles = gdnFiles;
    }

    public List<PartTuFiles> getTuLists() {
        return tuLists;
    }

    public void setTuLists(List<PartTuFiles> partTuFilesList) {
        this.tuLists = partTuFilesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TuFile tuFile = (TuFile) o;
        return fileTuName.equals(tuFile.fileTuName);
    }

    @Override
    public String toString() {
        return "TuFile{" +
                "id=" + id +
                ", originalTuName='" + originalTuName + '\'' +
                ", fileTuName='" + fileTuName + '\'' +
                ", fileTuDate=" + fileTuDate +
                ", fileTuPrice=" + fileTuPrice +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileTuName);
    }

}
