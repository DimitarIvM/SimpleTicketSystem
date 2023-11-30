package bg.softuni.stssoftuniproject.model.entity;

import bg.softuni.stssoftuniproject.model.enums.PriorityEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "priority")
public class Priority  extends BaseEntity {
@Column(nullable = false,unique = true)
@Enumerated(EnumType.STRING)
    private PriorityEnum name;
    @Column
    private String description;



    public PriorityEnum getName() {
        return name;
    }

    public void setName(PriorityEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
