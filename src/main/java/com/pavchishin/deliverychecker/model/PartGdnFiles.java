package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PartGdnFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String partGdnCode;
    private String partGdnName;
    private int partGdnQuantity;
    private double partGdnPrice;
    private String partGdnPlace;
    private String partGdnDos;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gdn_file_id")
    private GdnFile gdnFile;

    public PartGdnFiles() {}

    public PartGdnFiles(String partCode, String partName,
                       int partQuantity, double partPrice, String partPlace, String partGdnDos) {
        this.partGdnCode = partCode;
        this.partGdnName = partName;
        this.partGdnQuantity = partQuantity;
        this.partGdnPrice = partPrice;
        this.partGdnPlace = partPlace;
        this.partGdnDos = partGdnDos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartGdnCode() {
        return partGdnCode;
    }

    public void setPartGdnCode(String partCode) {
        this.partGdnCode = partCode;
    }

    public String getPartGdnName() {
        return partGdnName;
    }

    public void setPartGdnName(String partName) {
        this.partGdnName = partName;
    }

    public int getPartGdnQuantity() {
        return partGdnQuantity;
    }

    public void setPartGdnQuantity(int partQuantity) {
        this.partGdnQuantity = partQuantity;
    }

    public double getPartGdnPrice() {
        return partGdnPrice;
    }

    public void setPartGdnPrice(double partPrice) {
        this.partGdnPrice = partPrice;
    }

    public String getPartGdnPlace() {
        return partGdnPlace;
    }

    public void setPartGdnPlace(String partPlace) {
        this.partGdnPlace = partPlace;
    }

    public GdnFile getGdnFile() {
        return gdnFile;
    }

    public void setGdnFile(GdnFile gdnFile) {
        this.gdnFile = gdnFile;
    }

    public String getPartGdnDos() {
        return partGdnDos;
    }

    public void setPartGdnDos(String partGdnDos) {
        this.partGdnDos = partGdnDos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partGdnCode, partGdnName);
    }

    @Override
    public java.lang.String toString() {
        return "PartGdnFiles{" +
                "partGdnCode=" + partGdnCode +
                ", partGdnName=" + partGdnName +
                ", partGdnQuantity=" + partGdnQuantity +
                ", partGdnPrice=" + partGdnPrice +
                ", partGdnPlace=" + partGdnPlace +
                ", partGdnDos=" + partGdnDos +
                '}';
    }
}
