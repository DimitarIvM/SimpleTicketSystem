package bg.softuni.stssoftuniproject.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

   @OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    private Set<Employee> employees;

    @Column(unique = true,nullable = false)
    private String companyName;

    @Email
    @Column(unique = true,nullable = false)
    private String corporateEmail;

    @OneToMany(mappedBy = "company")
    private Set<Product> products;

    @OneToMany(mappedBy = "company")
    private Set<Ticket> tickets;

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }
}
