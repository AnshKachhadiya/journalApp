package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testAdd() {
        assertEquals(4, 2 + 2);
        assertTrue(5 > 3);
    }


    @Test
    public void testfindByUserName(){
//        assertNotNull(userRepository.findByUserName("ram"));
        User user = userRepository.findByUserName("hitesh");
        assertFalse(user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "hitesh",
            "ansh"
    })
    public void testfindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name));
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testsavenewuser(User user){
        assertTrue(userService.savenewuser(user));
    }

    @Test
    public void testdeleteByUserName(){
        userRepository.deleteByUserName("ram");
        assertNull(userRepository.findByUserName("ram"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "3,3,6",
            "5,5,10"
    })
    public void test (int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}
