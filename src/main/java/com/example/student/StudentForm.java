package com.example.student;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="student")
@NamedQuery(name="StudentForm.findAll", query="SELECT m FROM StudentForm m")
public class StudentForm implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_student", nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department")
    private String department;

    public StudentForm(Long id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
    public StudentForm() {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


