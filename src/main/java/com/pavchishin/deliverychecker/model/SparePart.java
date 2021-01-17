package com.pavchishin.deliverychecker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String partCode;
    private String partName;
    private int partQuantity;
    private double partPrice;
    private String partPlace;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tu_file_name")
    private TuFile tuFile;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "gdn_file_name")
    private GdnFile gdnFile;

    public SparePart() {}

    public SparePart(String partCode, String partName,
                     int partQuantity, double partPrice, TuFile tuFile) {
        this.partCode = partCode;
        this.partName = partName;
        this.partQuantity = partQuantity;
        this.partPrice = partPrice;
        this.tuFile = tuFile;
    }

    public SparePart(long id, String partCode, String partName,
                     int partQuantity, double partPrice, String partPlace,
                     TuFile tuFile, GdnFile gdnFile) {
        this.id = id;
        this.partCode = partCode;
        this.partName = partName;
        this.partQuantity = partQuantity;
        this.partPrice = partPrice;
        this.partPlace = partPlace;
        this.tuFile = tuFile;
        this.gdnFile = gdnFile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartCode() {
        return partCode;
    }

    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPartQuantity() {
        return partQuantity;
    }

    public void setPartQuantity(int partQuantity) {
        this.partQuantity = partQuantity;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public String getPartPlace() {
        return partPlace;
    }

    public void setPartPlace(String partPlace) {
        this.partPlace = partPlace;
    }

    public TuFile getTuFile() {
        return tuFile;
    }

    public void setTuFile(TuFile tuFile) {
        this.tuFile = tuFile;
    }

    public GdnFile getGdnFile() {
        return gdnFile;
    }

    public void setGdnFile(GdnFile gdnFile) {
        this.gdnFile = gdnFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparePart sparePart = (SparePart) o;
        return partCode.equals(sparePart.partCode) && partName.equals(sparePart.partName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partCode, partName);
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "partCode='" + partCode + '\'' +
                ", partName='" + partName + '\'' +
                ", partQuantity=" + partQuantity +
                ", partPrice=" + partPrice +
                ", partPlace='" + partPlace + '\'' +
                ", tuFile=" + tuFile +
                ", gdnFile=" + gdnFile +
                '}';
    }
}
