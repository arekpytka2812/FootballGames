import com.fg.footballgames.AppComponents.PasswordChecker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PasswordCheckerTest {

    @Test
    public void providingValidPasswordTest(){
        Assertions.assertTrue(PasswordChecker.isValid("Nowe1234"));
        Assertions.assertTrue(PasswordChecker.isValid("Test1234"));
        Assertions.assertTrue(PasswordChecker.isValid("Haslo134"));
        Assertions.assertTrue(PasswordChecker.isValid("PopHaslo12"));
        Assertions.assertTrue(PasswordChecker.isValid("TezPop123"));
    }

    @Test
    public void providingTooShortPasswordTest(){
        Assertions.assertFalse(PasswordChecker.isValid("Nowe12"));
        Assertions.assertFalse(PasswordChecker.isValid("Tes1"));
        Assertions.assertFalse(PasswordChecker.isValid("34Ts"));
        Assertions.assertFalse(PasswordChecker.isValid("pHlo12"));
        Assertions.assertFalse(PasswordChecker.isValid("zPop123"));
    }

    @Test
    public void providingPasswordWithoutUpperCaseChar(){
        Assertions.assertFalse(PasswordChecker.isValid("nowe12"));
        Assertions.assertFalse(PasswordChecker.isValid("test1234"));
        Assertions.assertFalse(PasswordChecker.isValid("haslo134"));
        Assertions.assertFalse(PasswordChecker.isValid("pophaslo12"));
        Assertions.assertFalse(PasswordChecker.isValid("tezpop123"));
    }

    @Test
    public void providingPasswordWithoutLowerCaseChar(){
        Assertions.assertFalse(PasswordChecker.isValid("NOWE1234"));
        Assertions.assertFalse(PasswordChecker.isValid("TEST1234"));
        Assertions.assertFalse(PasswordChecker.isValid("HASLO134"));
        Assertions.assertFalse(PasswordChecker.isValid("POPHASLO12"));
        Assertions.assertFalse(PasswordChecker.isValid("TEZPOP123"));
    }

    @Test
    public void providingPasswordWithoutNumber(){
        Assertions.assertFalse(PasswordChecker.isValid("NoweDFsa"));
        Assertions.assertFalse(PasswordChecker.isValid("TestdfgqX"));
        Assertions.assertFalse(PasswordChecker.isValid("HaslosdfQQ"));
        Assertions.assertFalse(PasswordChecker.isValid("PopHasloGDS"));
        Assertions.assertFalse(PasswordChecker.isValid("TezPopEFds"));
    }

}
