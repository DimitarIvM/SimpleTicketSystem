package bg.softuni.stssoftuniproject.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product  extends BaseEntity {

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String partNumber;

    @Column(nullable = false,unique = true)
    private String serialNumber;

    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private UserEntity client;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }





    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
