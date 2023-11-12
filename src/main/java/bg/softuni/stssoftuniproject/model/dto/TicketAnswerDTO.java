package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.entity.Priority;
import bg.softuni.stssoftuniproject.model.entity.Product;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.validation.anotations.ProductExists;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class TicketAnswerDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Email
    private String assignee;

    @NotNull
    private Priority priority;

    @NotNull
    private String notes;


    @ProductExists(message="The product does not exist")
    private String product;

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
