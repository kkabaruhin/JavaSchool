import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Server {
    private String serverName;

    private Map<Integer, User> users;

    private Map<Integer, Post> posts;

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public Server(String name) {
        this.serverName = name;
        this.users = new TreeMap<Integer, User>();
        this.posts = new TreeMap<Integer, Post>();
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, Post> getPosts() {
        return posts;
    }

    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
    }
}
