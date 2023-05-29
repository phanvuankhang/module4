package com.example.validate_form_register.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;


public class UserDTO implements Validator {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 1, max = 45, message = "Has at least 1 character and up to 45 characters\n.")
    @NotBlank(message = "Name cannot be left blank.")
    private String firstName;
    @Size(min = 1, max = 45, message = "Has at least 1 character and up to 45 characters.")
    @NotBlank(message = "Name cannot be left blank.")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9,10}$", message = "Incorrect phone number format.")
    private String phoneNumber;
    @Min(value = 18, message = "Age must be over 18")
    @NotNull(message = "Age cannot be left blank.")
    private Integer age;
    @Email
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user =(UserDTO) target;
        String regex = "^[A-Za-z ]{1,45}$";
        if (!user.getFirstName().matches(regex)) {
            errors.rejectValue("firstName", "", "Tên chỉ là ký tự chữ và khoảng trắng");
        }
        if (!user.getLastName().matches(regex)) {
            errors.rejectValue("lastName", "", "Tên chỉ là ký tự chữ và khoảng trắng");

        }
    }
}

