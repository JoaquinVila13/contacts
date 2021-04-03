package com.apis.colposapi.model.example;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.apis.colposapi.model.common.AuditModel;

@Entity
@Table(name = "contacts")
public class Contact extends AuditModel {
    @Id
    @GeneratedValue(generator = "contact_generator")
    @SequenceGenerator(
            name = "contact_generator",
            sequenceName = "contact_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    private String email;
   

    @NotBlank
    @Size(min = 6, max = 8)
    private String password;


    @Column(columnDefinition = "text")
    private String photourl;

    // Getters and Setters (Omitted for brevity)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}