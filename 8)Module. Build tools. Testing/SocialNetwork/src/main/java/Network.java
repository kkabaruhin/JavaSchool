public class Network {


    public static void main (String[] argv) {
        Server server = new Server("myServer");

        User user1 = new User("nick1", 18);

        server.addUser(user1);

        System.out.println(server.getUsers().containsValue(user1));
    }
}
