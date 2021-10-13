package com.huynguyen.instagram.Entities.Projection;

import org.springframework.beans.factory.annotation.Value;

public interface UsersView {
    @Value("#{target.UserName + ' ' + target.created_at}")
    String getUserName();
}
