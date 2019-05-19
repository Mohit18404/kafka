package com.example.kafka.pojo;

import org.apache.kafka.common.protocol.types.Field;

/*
 * @author: mohit5.kumar
 * @created: 08/05/19
 */
public class AuditRequestBuilder {
    private int id;
    private String name;
    private String phone;
    private String actor;
    private String email;

    public AuditRequestBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AuditRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AuditRequestBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public AuditRequestBuilder setActor(String actor) {
        this.actor = actor;
        return this;
    }

    public AuditRequestBuilder setEmail(String email){
        this.email=email;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getActor() {
        return actor;
    }

    public String getEmail() {
        return email;
    }

    public AuditRequest build(){
        return new AuditRequest(this);
    }
}
