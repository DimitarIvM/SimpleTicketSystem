package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.validation.anotations.UniqueCompanyName;
import bg.softuni.stssoftuniproject.validation.anotations.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeRegisterDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Email
    @UniqueEmail
    private String email;

    @NotNull
    @Size(min = 5, max = 16)
    private String password;
    @NotNull
    @Size(min = 5, max = 16)
    private String confirmPassword;


    @NotNull
    private String companyName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
