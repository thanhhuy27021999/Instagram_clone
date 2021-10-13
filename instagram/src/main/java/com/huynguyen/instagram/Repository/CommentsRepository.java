package com.huynguyen.instagram.Repository;

import com.huynguyen.instagram.Entities.comments;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<comments, Long> {
    @Query(
            value = "select * from comments where comments.user_id = ?1",
            nativeQuery = true
    )
    List<comments> findAllCommentsByUserId(Long userId);

    @Query(
            value = "select * from comments where comments.photo_id = :photoId",
            nativeQuery = true
    )
    List<comments> findAllCommentsForPhoto(@Param("photoId") Long photoId);
}
