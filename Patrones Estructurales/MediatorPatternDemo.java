import java.util.ArrayList;
import java.util.List;

// Interfaz Mediator
interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}

// Implementación concreta del Mediator
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        System.out.println(sender.getName() + " sends: " + message);
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
}

// Clase User
class User {
    private String name;
    private ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
        chatMediator.addUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatMediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Clase principal para probar el chat
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);
        User user3 = new User("Charlie", chatRoom);

        user1.sendMessage("Hola!");
        user2.sendMessage("¿Cómo están?");
        user3.sendMessage("Todo bien, gracias.");
    }
}
