package domain;

import lombok.Data;

@Data
public class Person {
    private int personId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

}
