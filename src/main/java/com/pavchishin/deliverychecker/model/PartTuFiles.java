package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PartTuFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String partTuCode;
    private String partTuName;
    private int partTuQuantity;
    private double partTuPrice;
    private String partTuDos;
    private String partTuStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tu_file_id")
    private TuFile tuFile;

    public PartTuFiles() {}

    public PartTuFiles(String partCode, String partName,
                       String partTuDos, int partQuantity,
                       double partPrice, String partTuStatus) {
        this.partTuCode = partCode;
        this.partTuName = partName;
        this.partTuQuantity = partQuantity;
        this.partTuPrice = partPrice;
        this.partTuDos = partTuDos;
        this.partTuStatus = partTuStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartTuCode() {
        return partTuCode;
    }

    public void setPartTuCode(String partCode) {
        this.partTuCode = partCode;
    }

    public String getPartTuName() {
        return partTuName;
    }

    public void setPartTuName(String partName) {
        this.partTuName = partName;
    }

    public int getPartTuQuantity() {
        return partTuQuantity;
    }

    public void setPartTuQuantity(int partQuantity) {
        this.partTuQuantity = partQuantity;
    }

    public double getPartTuPrice() {
        return partTuPrice;
    }

    public void setPartTuPrice(double partPrice) {
        this.partTuPrice = partPrice;
    }

    public TuFile getTuFile() {
        return tuFile;
    }

    public void setTuFile(TuFile tuFile) {
        this.tuFile = tuFile;
    }

    public String getPartTuDos() {
        return partTuDos;
    }

    public void setPartTuDos(String partTuDos) {
        this.partTuDos = partTuDos;
    }

    public String getPartTuStatus() {
        return partTuStatus;
    }

    public void setPartTuStatus(String partTuStatus) {
        this.partTuStatus = partTuStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartTuFiles that = (PartTuFiles) o;
        return partTuCode.equals(that.partTuCode) && partTuName.equals(that.partTuName)
                && partTuDos.equals(that.partTuDos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partTuCode);
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "partCode='" + partTuCode + '\'' +
                ", partName='" + partTuName + '\'' +
                ".";
    }
}
