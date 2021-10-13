package com.huynguyen.instagram.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class comments {
    @Id
    @SequenceGenerator(
            name = "comments_sequence",
            sequenceName = "comments_sequence",
            initialValue = 7489,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comments_sequence"
    )
    private Long Id;

    @Column(
            name = "comment_text",
            nullable = false
    )
    private String comment_text;

    @Column(name="created_at",
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "Id"
    )
    private Users user;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "photo_id",
            referencedColumnName = "Id"
    )
    private photos photo;
}
