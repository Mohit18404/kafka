package com.example.kafka.pojo;

/*
 * @author: mohit5.kumar
 * @created: 08/05/19
 */
public class AuditRequest {
    private int id;
    private String name;
    private String phone;
    private String actor;
    private String email;

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

    public AuditRequest(AuditRequestBuilder auditRequestBuilder){
       this.id=auditRequestBuilder.getId();
        this.name=auditRequestBuilder.getName();
        this.phone=auditRequestBuilder.getPhone();
        this.actor=auditRequestBuilder.getActor();
    }

    @Override
    public String toString() {
        return "AuditRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", actor='" + actor + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
