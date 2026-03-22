import Zad1_2.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testValidUserCreation() {
        User user = new User("jan_kowalski", "jan@example.com", 25);
        assertNotNull(user);
        assertEquals("jan_kowalski", user.getUsername());
        assertEquals("jan@example.com", user.getEmail());
        assertEquals(25, user.getAge());
    }

    @Test
    public void testEmptyUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("", "jan@example.com", 25);
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        // Brak znaku @
        assertThrows(IllegalArgumentException.class, () -> {
            new User("jan", "janexample.com", 25);
        });

        // Pusty email
        assertThrows(IllegalArgumentException.class, () -> {
            new User("jan", "", 25);
        });
    }

    @Test
    public void testNegativeAge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("jan", "jan@example.com", -5);
        });
        assertEquals("Age cannot be negative", exception.getMessage());
    }
}