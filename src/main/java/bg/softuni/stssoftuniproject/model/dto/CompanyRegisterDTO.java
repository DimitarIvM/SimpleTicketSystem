package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.validation.anotations.UniqueCompanyName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class CompanyRegisterDTO {


    @UniqueCompanyName
    @NotNull
    private String name;

    @Email
    @NotNull
    private String corporateEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }
}
