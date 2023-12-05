package bg.softuni.stssoftuniproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
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

    @Column
    private LocalDateTime created;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
    @JsonIgnore
    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
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
