package com.neoteric.fullstackdemo_31082024.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="address",schema = "swiggy.1")
@Data
public class AddressEntity {
    public AddressEntity(){

    }
    @Id
    @Column(name = "id")
    public  Integer id;
    @Column(name = "state")
    public String state;
    @ManyToOne
    @JoinColumn(name="aadharNumber",referencedColumnName = "aadharNumber")
    public AdharEntity adharEntity;

}
