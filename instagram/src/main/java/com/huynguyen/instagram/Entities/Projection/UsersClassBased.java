package com.huynguyen.instagram.Entities.Projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersClassBased {
    private String userName;
    private String image_url;
    private int totals_likes;
}
