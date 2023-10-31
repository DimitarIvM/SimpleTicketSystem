package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.entity.Client;
import bg.softuni.stssoftuniproject.model.entity.Company;
import bg.softuni.stssoftuniproject.model.entity.Employee;

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


    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private Company companyName;




    private LocalDateTime created;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
