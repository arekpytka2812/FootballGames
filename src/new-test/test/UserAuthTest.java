import com.fg.footballgames.AppComponents.AuthAccounts.LoggedUser;
import com.fg.footballgames.User.UserAuthentication;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserAuthTest {

    @Before
    public void setup(){
        UserAuthentication.processRegister("test1", "Nowe1234");
        LoggedUser.removeInstance();

        UserAuthentication.processRegister("test2", "Test1234");
        LoggedUser.removeInstance();

        UserAuthentication.processRegister("test3", "Stare1234");
        LoggedUser.removeInstance();

        UserAuthentication.processRegister("test4", "Haslo1234");
        LoggedUser.removeInstance();
    }

    @Test
    public void loginTest(){
        Assertions.assertTrue(UserAuthentication.processLogin("test1", "Nowe1234"));
        LoggedUser.removeInstance();

        Assertions.assertTrue(UserAuthentication.processLogin("test2", "Test1234"));
        LoggedUser.removeInstance();

        Assertions.assertTrue(UserAuthentication.processLogin("test3", "Stare1234"));
        LoggedUser.removeInstance();

        Assertions.assertTrue(UserAuthentication.processLogin("test4", "Haslo1234"));
        LoggedUser.removeInstance();
    }

    @Test
    public void tryRegisterAlreadyRegisterUser(){
        Assertions.assertFalse(UserAuthentication.processRegister("test1", "Nowe1234"));
        Assertions.assertFalse(UserAuthentication.processRegister("test2", "Test1234"));
        Assertions.assertFalse(UserAuthentication.processRegister("test3", "Stare1234"));
        Assertions.assertFalse(UserAuthentication.processRegister("test4", "Haslo1234"));
    }


}
