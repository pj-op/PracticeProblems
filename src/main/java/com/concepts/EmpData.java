package com.concepts;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpData {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private int salary;
    private Date joiningDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpData empData = (EmpData) o;

        if (id != empData.id) return false;
        if (salary != empData.salary) return false;
        if (!firstName.equals(empData.firstName)) return false;
        if (!lastName.equals(empData.lastName)) return false;
        if (!email.equals(empData.email)) return false;
        if (!gender.equals(empData.gender)) return false;
        return joiningDate.equals(empData.joiningDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + salary;
        result = 31 * result + joiningDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + email + "," + gender + "," + salary + "," + joiningDate;
        //"id=" + id + ", firstName='" + firstName +", lastName='" + lastName +", email='" + email +", gender='" + gender + ", salary=" + salary + ", joiningDate=" + joiningDate;
    }
}