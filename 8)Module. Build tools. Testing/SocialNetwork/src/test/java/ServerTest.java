
import org.junit.*;

import static org.junit.Assert.*;

public class ServerTest {

    private Server server;

    @Before
    public void beforeTest() {
        server = new Server("myServer");
        System.out.println("beforeTest done");
    };

    @After
    public void afterTest() {
        server = null;
        System.out.println("afterTest done");
    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User("nick1", 18);

        server.addUser(user);

        assertEquals(true, server.getUsers().containsValue(user));
        System.out.println("addUserTest done");
    }

    @Test
    public void addPostTest() {
        Post post = new Post("myPost", "message", 0);

        server.addPost(post);

        assertEquals(true, server.getPosts().containsValue(post));
        System.out.println("addPostTest done");
    }
}
