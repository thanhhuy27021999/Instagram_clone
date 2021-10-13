package com.huynguyen.instagram.Service;

import com.huynguyen.instagram.Entities.comments;
import com.huynguyen.instagram.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService implements InterfaceComment{
    private CommentsRepository commentsRepository;
    @Autowired
    CommentsService(CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
    }
    @Override
    public List<comments> getAllComments() {
        return this.commentsRepository.findAll();
    }

    @Override
    public List<comments> getAllCommentsByUserId(Long UserId) {
        return this.commentsRepository.findAllCommentsByUserId(UserId);
    }

    @Override
    public List<comments> getAllCommentsForPhoto(Long PhotoId) {
        return this.commentsRepository.findAllCommentsForPhoto(PhotoId);
    }
}
