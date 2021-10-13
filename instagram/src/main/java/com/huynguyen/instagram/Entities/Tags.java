package com.huynguyen.instagram.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @SequenceGenerator(
            name = "tags_sequence",
            sequenceName = "tags_sequence",
            initialValue = 22,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tags_sequence"
    )
    private Long Id;
    @Column(
            name = "tag_name",
            nullable = false,
            unique = true
    )
    private String tag_name;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Date created_at;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "photo_tags",
            joinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "Id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "photo_id",
                    referencedColumnName = "Id"
            )
    )
    private List<photos> photos;
}
