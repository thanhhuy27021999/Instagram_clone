-- Find the 5 oldest user
SELECT * 
FROM users 
ORDER BY created_at 
LIMIT 5;
-- we need to know which day of week the number users register is highest
SELECT 
    DAYNAME(created_at) AS day,
    COUNT(*) AS total
FROM users
GROUP BY day
ORDER BY total DESC;

-- we want to an email to users who are inactive that mean the users have not posted/comment any photos in Instagram
-- so we need to find inactive users

SELECT 
    users.username,
    comments.comment_text,
    photos.image_url
FROM users
LEFT JOIN photos
    ON users.id = photos.user_id
LEFT JOIN comments
    ON comments.user_id = users.id
WHERE photos.id IS NULL && comments.id IS NULL;


-- users who have not written any comments
SELECT users.username
FROM users
LEFT JOIN comments
    ON users.id = comments.user_id
WHERE comments.id IS NULL;
-- users who have not posted any photo
SELECT users.username
FROM users
LEFT JOIN photos
    ON users.id = photos.user_id
WHERE photos.id IS NULL;

-- we are running a new contest to find who can get the most likes per photo what he posted 
SELECT 
    photos.image_url,
    COUNT(*) AS total_likes,
    users.username
FROM photos 
LEFT JOIN likes
    ON photos.id = likes.photo_id
JOIN users
    ON photos.user_id = users.id
GROUP BY photos.id
ORDER BY total_likes DESC
LIMIT 1;

-- we need to know the average user post
SELECT
    (SELECT COUNT(*) AS total_image FROM photos)/(SELECT COUNT(*) AS total_users FROM users) AS avergae;
    
-- Find 5 hashtags commonly used
SELECT 
    tags.tag_name,
    COUNT(*) AS total
FROM tags 
LEFT JOIN photo_tags
    ON tags.id = photo_tags.tag_id
GROUP BY tags.id
ORDER BY total DESC
LIMIT 5;

-- Find users who have liked every single photo in our site

SELECT 
    users.username,
    COUNT(*) AS total_photo_likes
FROM users
LEFT JOIN likes
    ON users.id = likes.user_id
JOIN photos
    ON likes.photo_id = photos.id
GROUP BY users.id
HAVING total_photo_likes = (SELECT COUNT(*) FROM photos)
ORDER BY total_photo_likes DESC;

SELECT username, 
       Count(*) AS num_likes 
FROM   users 
       INNER JOIN likes 
               ON users.id = likes.user_id 
GROUP  BY likes.user_id 
HAVING num_likes = (SELECT Count(*) 
                    FROM   photos); 

-- find the other users who follow me
SELECT 
    follows.follower_id
FROM users
LEFT JOIN follows
    ON users.id = follows.followee_id
WHERE users.id = 1;