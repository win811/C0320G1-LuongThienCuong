package furama.resort.models.dto;

import furama.resort.services.AccountService;
import furama.resort.services.CustomerService;
import furama.resort.services.impl.AccountServiceImpl;
import furama.resort.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
public class SignUpDto implements Validator {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    private String email;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    public SignUpDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

//        AccountService accountService = new AccountServiceImpl();
//        CustomerService customerService = new CustomerServiceImpl();

        SignUpDto signUpDto = (SignUpDto) target;

        if (!signUpDto.getPassword().equals(signUpDto.getConfirmPassword())) {
            errors.rejectValue("confirmPassword","confirmPassword");
        }
        if (accountService.findAccountByUserName(signUpDto.getUserName()) != null) {
            errors.rejectValue("userName","userNameExist");
        }
        if (customerService.findCustomerByEmail(signUpDto.getEmail()) != null) {
            errors.rejectValue("email","emailExist");
        }

    }

}
