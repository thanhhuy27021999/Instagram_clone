package com.huynguyen.instagram.Controller;


import com.huynguyen.instagram.Entities.Projection.UserLikeMostPhotos;
import com.huynguyen.instagram.Entities.Projection.UsersClassBased;
import com.huynguyen.instagram.Entities.Projection.UsersView;
import com.huynguyen.instagram.Entities.UserLikesTotal;
import com.huynguyen.instagram.Entities.Users;
import com.huynguyen.instagram.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping()
    public ResponseEntity<Users> saveUser(@RequestBody Users users){
        return new ResponseEntity<Users>(userService.saveUser(users), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/Unactive")
    public List<Users> getUnactiveUsers(){
        return this.userService.getUnactiveUsers();
    }
    @GetMapping("/LikeEveryPhotos")
    public List<Users> getUserLikeEveryPhotos(){
        return this.userService.getUserLikeEveryPhotos();
    }

    @GetMapping("/MostLikePerPhoto")
    public List<UserLikeMostPhotos> getMostLikePerPhotos(){
        return this.userService.getMostLikesPerPhotoNativeQuery();
    }
//    @GetMapping("/MostLikePerPhotoBeanClass")
//    public List<UsersClassBased> getMostLikePerPhotosBeanClass(){
//        return this.userService.getMostLikePerPhotoBeanClass();
//    }
    @GetMapping("/NOldest/{count}")
    public List<UsersView> getNUserOldest(@PathVariable("count") int N){
        return this.userService.getNUserOldest(N);
    }
    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<Users>(this.userService.getUserById(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable("id") Long id,
                                                @RequestBody Users user){
        return new ResponseEntity<Users>(this.userService.updateUser(id, user), HttpStatus.OK);
    }
}
