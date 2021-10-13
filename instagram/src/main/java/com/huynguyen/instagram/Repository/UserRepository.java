package com.huynguyen.instagram.Repository;

import com.huynguyen.instagram.Entities.Projection.UserLikeMostPhotos;
import com.huynguyen.instagram.Entities.Projection.UsersClassBased;
import com.huynguyen.instagram.Entities.Projection.UsersView;
import com.huynguyen.instagram.Entities.UserLikesTotal;
import com.huynguyen.instagram.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(
            value = "SELECT \n" +
                    "    users.*,\n" +
                    "    COUNT(*) AS total_photo_likes\n" +
                    "FROM users\n" +
                    "LEFT JOIN likes\n" +
                    "    ON users.id = likes.user_id\n" +
                    "JOIN photos\n" +
                    "    ON likes.photo_id = photos.id\n" +
                    "GROUP BY users.id\n" +
                    "HAVING total_photo_likes = (SELECT COUNT(*) FROM photos)\n",
            nativeQuery = true
    )
    List<Users> findUserLikeEveryPhotos();

    @Query(
            value = "SELECT *\n" +
                    "FROM users\n" +
                    "ORDER BY created_at\n" +
                    "LIMIT :N",
            nativeQuery = true
    )
    List<UsersView> findNUserOldest(@Param("N") int n);

    @Query(
            value = "SELECT\n" +
                    "    users.*\n" +
                    "FROM users\n" +
                    "LEFT JOIN photos\n" +
                    "    ON users.id = photos.user_id\n" +
                    "LEFT JOIN comments\n" +
                    "    ON comments.user_id = users.id\n" +
                    "WHERE photos.id IS NULL && comments.id IS NULL",
            nativeQuery = true
    )
    List<Users> getUnactiveUsers();

    @Query(
            value = "SELECT\n" +
                    "    users.*\n" +
                    "FROM users\n" +
                    "LEFT JOIN photos\n" +
                    "    ON users.id = photos.user_id\n" +
                    "LEFT JOIN comments\n" +
                    "    ON comments.user_id = users.id\n" +
                    "WHERE photos.id IS NULL && comments.id IS NULL",
            nativeQuery = true
    )
    List<UsersClassBased> getUnactiveUsersClassBased();

//
//    @Query(
//            value = "SELECT\n" +
//                    "new com.huynguyen.instagram.Entities.UserLikesTotal(u.username, p.image_url, COUNT(*)\n"+
//                    "FROM photos p\n" +
//                    "LEFT JOIN likes l\n" +
//                    "    ON p.id = l.photo_id\n" +
//                    "JOIN users u\n" +
//                    "    ON p.user_id = u.id\n" +
//                    "GROUP BY p.id\n" +
//                    "ORDER BY COUNT(*) DESC\n" +
//                    "LIMIT 2",
//            nativeQuery = false
//    )
//    List<UsersClassBased> getMostLikesPerPhotosClassBean();

    @Query(
            value = "SELECT\n" +
                    "    photos.image_url,\n" +
                    "    users.username,\n" +
                    "    COUNT(*) AS total_likes\n" +
                    "FROM photos\n" +
                    "LEFT JOIN likes\n" +
                    "    ON photos.id = likes.photo_id\n" +
                    "JOIN users\n" +
                    "    ON photos.user_id = users.id\n" +
                    "GROUP BY photos.id\n" +
                    "ORDER BY total_likes DESC\n" +
                    "LIMIT 5;",
            nativeQuery = true
    )
    List<UserLikeMostPhotos> getMostLikesPerPhotosNativeQuery();
}
