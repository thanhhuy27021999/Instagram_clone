package com.huynguyen.instagram.Service;

import com.huynguyen.instagram.Entities.Projection.UserLikeMostPhotos;
import com.huynguyen.instagram.Entities.Projection.UsersClassBased;
import com.huynguyen.instagram.Entities.Projection.UsersView;
import com.huynguyen.instagram.Entities.UserLikesTotal;
import com.huynguyen.instagram.Entities.Users;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IntefaceUserService {
    Users saveUser(Users user);
    List<Users> getAllUsers();
    Users getUserById(Long id);
    List<Users> getUserLikeEveryPhotos();
    List<UsersView> getNUserOldest(int N);
    List<Users> getUnactiveUsers();
    List<UsersClassBased> getUnactiveUsersClassBased();
    Users updateUser(Long id, Users user);
    List<UserLikeMostPhotos> getMostLikesPerPhotoNativeQuery();
    List<UsersClassBased> getMostLikePerPhotoBeanClass();
}
