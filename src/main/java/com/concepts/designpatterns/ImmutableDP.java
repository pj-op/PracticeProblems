package com.concepts.designpatterns;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ImmutableDP {
    public static void main(String[] args) {

        Age age = new Age();
        age.setAgeGrp("18-20");
        age.setGender("Male");

        Student student = new Student(1, "abc", age);
        System.out.println(student);
//        age.setGender("FeMale");
        student.getAge().setGender("female");
        System.out.println(student);
    }
}


final class Student {
    private final int id;
    private final String name;
    private final Age age;

    public Student(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        Age cloneAge = new Age();
        cloneAge.setGender(age.getGender());
        cloneAge.setAgeGrp(age.getAgeGrp());
        this.age = cloneAge;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setGender(age.getGender());
        cloneAge.setAgeGrp(age.getAgeGrp());
        return cloneAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@Getter
@Setter
@ToString
class Age {
    private String ageGrp;
    private String gender;
}