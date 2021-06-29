package com.example.demo.dao.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long uuid;
    private String userName;
    private String password;

}
