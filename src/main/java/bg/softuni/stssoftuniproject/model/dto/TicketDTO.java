package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.entity.UserEntity;

import java.time.LocalDateTime;

public class TicketDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String subject;


    private UserEntity client;

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }

    private LocalDateTime created;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
