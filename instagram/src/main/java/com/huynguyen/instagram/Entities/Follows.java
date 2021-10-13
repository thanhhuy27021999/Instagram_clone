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
public class Follows {
    @Id
    @SequenceGenerator(
            name = "follows_sequence",
            sequenceName = "follows_sequence",
            initialValue = 7624,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "follows_sequence"
    )
    private Long Id;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Date created_at;
    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "follower_id",
            referencedColumnName = "Id"
    )
    private Users follower;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "followee_id",
            referencedColumnName = "Id"
    )
    private Users followee;
}
