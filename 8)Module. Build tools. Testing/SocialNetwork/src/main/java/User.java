import java.util.Map;

public class User {
    private static int idCounter = 0;

    private int id;
    private String nickname;
    private int age;
    private Map<Integer, Post> myPosts;
    private Map<Integer, User> friends;

    public User(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
        this.id = idCounter++;
    }

    public Post addNewPost(String name, String message) {
        Post post = new Post(name, message, id);
        myPosts.put(post.getId(), post);
        return post;
    }

    public void addFriend(User user) {
        this.friends.put(user.getId(), user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<Integer, User> getFriends() {
        return friends;
    }

    public void setFriends(Map<Integer, User> friends) {
        this.friends = friends;
    }

    public Map<Integer, Post> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(Map<Integer, Post> myPosts) {
        this.myPosts = myPosts;
    }


}
