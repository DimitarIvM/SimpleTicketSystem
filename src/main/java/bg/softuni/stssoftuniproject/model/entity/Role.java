package bg.softuni.stssoftuniproject.model.entity;

import bg.softuni.stssoftuniproject.model.enums.EmployeeRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @NotNull
    private EmployeeRoleEnum role;

    @ManyToMany
    private Set<Employee> employee;

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public EmployeeRoleEnum getRole() {
        return role;
    }

    public void setRole(EmployeeRoleEnum role) {
        this.role = role;
    }
}
