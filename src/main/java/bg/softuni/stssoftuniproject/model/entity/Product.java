package bg.softuni.stssoftuniproject.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product  extends BaseEntity {

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String partNumber;

    @Column(nullable = false,unique = true)
    private String serialNumber;

    @ManyToMany(mappedBy = "products")
    private Set<Ticket>
            tickets;


    public Set<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(Set<Ticket> tickets) {
        this.tickets = tickets;
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
