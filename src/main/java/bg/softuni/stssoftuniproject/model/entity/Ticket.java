package bg.softuni.stssoftuniproject.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket  extends BaseEntity{

    @Column(nullable = false)
    private String subject;

    @ManyToOne
    @NotNull
    private Client client;

    @ManyToOne
    private Employee ticketAssignee;

    @ManyToOne
    @NotNull
    private Company company;

    @Column(columnDefinition = "LONGTEXT",nullable = false)
@NotNull
    private String description;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime  modified;

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @OneToMany(mappedBy = "ticket")
    private Set<Product> product;


    @OneToOne
    private Priority priority;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getTicketAssignee() {
        return ticketAssignee;
    }

    public void setTicketAssignee(Employee ticketAssignee) {
        this.ticketAssignee = ticketAssignee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


}
