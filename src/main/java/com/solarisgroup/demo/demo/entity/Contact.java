package com.solarisgroup.demo.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
public class Contact extends BaseEntity {

    @Column(unique = true)
    public String uid;
    public String firstName;
    public String lastName;

    public String userId;

    @OneToMany(mappedBy = "contact")
    public List<Email> emails;

    @OneToMany(mappedBy = "contact")
    public List<PhoneNumber> phoneNumbers;

}
