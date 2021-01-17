package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class GdnFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String originalGdnName;
    private String fileGdnName;
    private Date fileGdnDate;
    private double fileGdnPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tu_files_id")
    private TuFile tuFile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gdnFile")
    private Set<SparePart> partSet;

    public GdnFile() {}

    public GdnFile(String originalGdnName, String fileGdnName, Date fileGdnDate, double fileGdnPrice, TuFile tuFile,
                   Set<SparePart> partSet) {
        this.originalGdnName = originalGdnName;
        this.fileGdnName = fileGdnName;
        this.fileGdnDate = fileGdnDate;
        this.fileGdnPrice = fileGdnPrice;
        this.tuFile = tuFile;
        this.partSet = partSet;
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

    public TuFile getTuFile() {
        return tuFile;
    }

    public void setTuFile(TuFile tuFile) {
        this.tuFile = tuFile;
    }

    public Set<SparePart> getPartSet() {
        return partSet;
    }

    public void setPartSet(Set<SparePart> partSet) {
        this.partSet = partSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GdnFile gdnFile = (GdnFile) o;
        return Objects.equals(fileGdnName, gdnFile.fileGdnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileGdnName);
    }

    @Override
    public String toString() {
        return "GdnFile{" +
                "fileGdnName='" + fileGdnName + '\'' +
                ", fileGdnDate=" + fileGdnDate +
                ", fileGdnPrice=" + fileGdnPrice +
                ", tuFile=" + tuFile +
                '}';
    }
}
