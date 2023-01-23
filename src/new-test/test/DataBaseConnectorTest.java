import com.fg.footballgames.AppComponents.DataBaseConnector;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

public class DataBaseConnectorTest {

    @Test
    public void returnNullWhenConnectingWithWrongCredentials(){
        try {
            Assertions.assertNull(DataBaseConnector.connect("test",""));
            Assertions.assertNull(DataBaseConnector.connect("tesdsa","pass"));
            Assertions.assertNull(DataBaseConnector.connect("dssdfsdf","fsdhgf"));
            Assertions.assertNull(DataBaseConnector.connect("wewe","ewr"));

        } catch (SQLException e) {
        }
    }


}
