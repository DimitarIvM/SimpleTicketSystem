package bg.softuni.stssoftuniproject.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Table(name = "clients")
@Entity
public class Client extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    @Length(min=5,max = 15)
    private String password;

    @OneToMany(mappedBy = "client")
    private Set<Ticket> tickets;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
