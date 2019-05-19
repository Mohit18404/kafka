package com.example.kafka.dao;

/*
 * @author: mohit5.kumar
 * @created: 09/05/19
 */

import javax.persistence.*;

@Entity
@Table(name="UserRegistration")
public class UserRegistration {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable=false)
    private String first_name;

    private String last_name;

    @Column(name="phone", unique=true,nullable=false)
    private String phone;

    @Column(name="email", unique=true)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
