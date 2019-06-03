package gamestore.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRegisterDto {
    private String email;
    private String passowrd;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDto() { }

    public UserRegisterDto(String email, String passowrd, String confirmPassword, String fullName) {
        this.email = email;
        this.passowrd = passowrd;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    @NotNull(message = "Email cannot be null.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Password cannot be null.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?!.*[&%$]).{6,}$"
            , message = "Password – length must be at least 6 symbols and must " +
            "contain at least 1 uppercase, 1 lowercase letter and 1 digit.")
    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @NotNull(message = "Confirm Password cannot be null.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
