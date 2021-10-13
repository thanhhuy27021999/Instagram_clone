package com.huynguyen.instagram.Service;


import com.huynguyen.instagram.Entities.comments;

import java.util.List;

public interface InterfaceComment {
    List<comments> getAllComments();
    List<comments> getAllCommentsByUserId(Long UserId);
    List<comments> getAllCommentsForPhoto(Long PhotoId);
}
