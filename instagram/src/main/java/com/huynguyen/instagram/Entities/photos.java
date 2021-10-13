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
public class photos {
    @Id
    @SequenceGenerator(
            name = "photos_sequence",
            sequenceName = "photos_sequence",
            initialValue = 258,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photos_sequence"
    )
    private Long Id;
    @Column(
            name = "image_url",
            nullable = false
    )
    private String Image_url;
    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "Id"
    )
    private Users user;

    @Column(name="created_at",
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;
}
