package zw.co.afrosoft.restfulwebservices.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "Firstname cannot be null")
    @Size(min =2 , message = "Firstname must not be less than 2 characters")
    private String firstName;
    @Size(min =2 , message = "Lastname must not be less than 2 characters")
    @NotNull(message = "Lastname cannot be null")
    private String lastName;

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
}
