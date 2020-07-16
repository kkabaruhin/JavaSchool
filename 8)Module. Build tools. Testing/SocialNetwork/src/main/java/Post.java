import java.util.ArrayList;

public class Post {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String message;
    private int likes;
    private int ownerId;

    private ArrayList<String> comments;

    public Post(String name, String message, int ownerId) {
        this.name = name;
        this.message = message;
        this.ownerId = ownerId;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
