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

public class Likes {
    @Id
    @SequenceGenerator(
            name = "likes_sequence",
            sequenceName = "likes_sequence",
            initialValue = 8783,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "likes_sequence"
    )
    private Long Id;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Date created_at;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "Id"
    )
    private Users user;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "photo_id",
            referencedColumnName = "Id"
    )
    private photos photo;
}
