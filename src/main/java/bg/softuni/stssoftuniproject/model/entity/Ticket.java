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
    private User client;

    @ManyToOne
    private User ticketAssignee;


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

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getTicketAssignee() {
        return ticketAssignee;
    }

    public void setTicketAssignee(User ticketAssignee) {
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
