package com.huynguyen.instagram.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            initialValue = 101,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long Id;
    @Column(
            name = "username",
            nullable = false
    )
    String userName;
    @Column(name="created_at",
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;
//
//    @OneToMany(
//            mappedBy = "user",          //mappedBy is used for bi-directive relation between two tables; "user" is an attribute in comments object
//            cascade = CascadeType.ALL
//   )
//    private List<comments> comments;
}

