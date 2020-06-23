package validation.all.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 5,max = 45,message = "Tối thiểu phải 5 ký tự và tối đa 45 ký tự nha bạn")
    private String firstName;
    @Size(min = 5,max = 45,message = "Tối thiểu phải 5 ký tự và tối đa 45 ký tự nha bạn")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$")
    private String phoneNumber;
    @Min(value = 18,message = "Nhỏ hơn 18 tuổi là không được nha")
    private int age;

    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$")
    private String email;

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
