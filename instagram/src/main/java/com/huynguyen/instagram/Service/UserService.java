package com.huynguyen.instagram.Service;

import com.huynguyen.instagram.Entities.Projection.UserLikeMostPhotos;
import com.huynguyen.instagram.Entities.Projection.UsersClassBased;
import com.huynguyen.instagram.Entities.Projection.UsersView;
import com.huynguyen.instagram.Entities.UserLikesTotal;
import com.huynguyen.instagram.Entities.Users;
import com.huynguyen.instagram.Error.UserNotFoundException;
import com.huynguyen.instagram.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IntefaceUserService{
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("user not found")
        );
    }

    @Override
    public List<Users> getUserLikeEveryPhotos() {
        return this.userRepository.findUserLikeEveryPhotos();
    }

    @Override
    public List<UsersView> getNUserOldest(int N) {
        return this.userRepository.findNUserOldest(N);
    }

    @Override
    public List<Users> getUnactiveUsers() {
        return this.userRepository.getUnactiveUsers();
    }

    @Override
    public List<UsersClassBased> getUnactiveUsersClassBased() {
        return this.userRepository.getUnactiveUsersClassBased();
    }

    @Override
    public Users updateUser(Long id, Users user) {
        Users exsitingUser = this.userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User not found")
        );
        exsitingUser.setUserName(user.getUserName());
        this.userRepository.save(exsitingUser);
        return exsitingUser;
    }

    @Override
    public List<UserLikeMostPhotos> getMostLikesPerPhotoNativeQuery() {
        return this.userRepository.getMostLikesPerPhotosNativeQuery();
    }

    @Override
    public List<UsersClassBased> getMostLikePerPhotoBeanClass() {
        return this.userRepository.getUnactiveUsersClassBased();
    }
}
