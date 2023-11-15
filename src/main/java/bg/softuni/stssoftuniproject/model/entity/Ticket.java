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
    private UserEntity client;

    @ManyToOne
    private UserEntity ticketAssignee;


    @Column(columnDefinition = "LONGTEXT",nullable = false)
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String notes;
    @Column(nullable = false)
    private LocalDateTime created;

    @Column
    private LocalDateTime  modified;
    @OneToOne
    private Priority priority;

    @ManyToMany(targetEntity = Product.class,fetch = FetchType.EAGER)
    @JoinTable(
            name = "tickets_products",
            joinColumns = @JoinColumn(
                    name = "ticket_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Product> products;

    public  Set<Product> getProduct() {
        return products;
    }

    public void setProduct( Set<Product> products) {
        this.products = products;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }

    public UserEntity getTicketAssignee() {
        return ticketAssignee;
    }

    public void setTicketAssignee(UserEntity ticketAssignee) {
        this.ticketAssignee = ticketAssignee;
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
