package com.example.demo.Student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table()
public class Student {
    @Id
    @SequenceGenerator(
            name = "sequence_student",
            sequenceName = "sequence_student",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_student"
    )
    private Integer Id;
    private String Name;
    private String Email;
    private LocalDate DOB;
    @Transient
    private Integer Age;

    public Student() {
    }
    public Student(String name, String email, LocalDate DOB) {
        Name = name;
        Email = email;
        this.DOB = DOB;
    }
    public Student(Integer id, String name, String email, LocalDate DOB) {
        Id = id;
        Name = name;
        Email = email;
        this.DOB = DOB;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return Period.between(this.getDOB(),LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", DOB=" + DOB +
                ", Age=" + Age +
                '}';
    }
}
