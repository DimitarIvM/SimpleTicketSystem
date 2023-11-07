package bg.softuni.stssoftuniproject.model.entity;


import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @NotNull
    private RolesEnum role;


    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }
}
