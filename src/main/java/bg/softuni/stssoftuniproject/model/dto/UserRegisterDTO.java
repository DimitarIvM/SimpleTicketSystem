package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.validation.anotations.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotNull
    @Size(min = 2,message = "First name must contain at least 2 symbols")
    private String firstName;
    @NotNull
    @Size(min = 2,message = "Last name must contain at least 2 symbols")
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


}
