package com.huynguyen.instagram.Controller;

import com.huynguyen.instagram.Entities.comments;
import com.huynguyen.instagram.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentsService commentsService;
    @Autowired
    CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }
    @GetMapping()
    public List<comments> gettAllComments(){
        return this.commentsService.getAllComments();
    }
    @GetMapping("/byUser/{UserId}")
    public List<comments> gettAllCommentsByUserId(@PathVariable("UserId") Long id){
        return this.commentsService.getAllCommentsByUserId(id);
    }
    @GetMapping("/byPhoto/{photoId}")
    public List<comments> getAllCommentsForPhoto(@PathVariable("photoId") Long id){
        return this.commentsService.getAllCommentsForPhoto(id);
    }
}
