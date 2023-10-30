package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.entity.Company;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class TicketSubmitDTO {


    @NotNull
    private String subject;

  @NotNull
    private String clientEmail;

 @NotNull
    private Company company;

 @NotNull
    private String description;

@NotNull
@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime created;

    public TicketSubmitDTO() {
        this.created = LocalDateTime.now();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClient() {
        return clientEmail;
    }

    public void setClient(String clientEmail) {
        this.clientEmail = clientEmail;
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
}