import com.fg.footballgames.AppComponents.SelectQueryBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class StringBuilderTest {

    String equalStringQuery = "select * from Personal_data where name = 'Adam';";
    String equalNumberQuery = "select * from Personal_data where id_person = 1;";
    String limitQuery = "select * from Personal_data limit 3;";
    String lowerQuery = "select * from Personal_data where id_person < 4;";
    String higherQuery = "select * from Personal_data where id_person > 2;";
    String likeQuery = "select * from Personal_data where name LIKE 'Maciej';";
    String betweenQuery = "select * from Personal_data where id_person between 0 AND 3;";
    String joinQuery = "select * from Players join Personal_data ON Players.personal_data_id=Personal_data.id_person;";
    String passwordCheckQuery = "select * from Personal_data where login = 'pytkus' and password = SHA2('password',256);";

    @Test
    public void equalStringQueryTest(){
        Assertions.assertEquals(equalStringQuery, SelectQueryBuilder.buildQueryEqualString("Personal_data", "name", "Adam"));
    }

    @Test
    public void equalNumberQueryTest(){
        Assertions.assertEquals(equalNumberQuery, SelectQueryBuilder.buildQueryEqualNumber("Personal_data", "id_person", "1"));
    }

    @Test
    public void limitQueryTest(){
        Assertions.assertEquals(limitQuery, SelectQueryBuilder.buildQueryLimit("Personal_data", 3));
    }

    @Test
    public void lowerQueryTest(){
        Assertions.assertEquals(lowerQuery, SelectQueryBuilder.buildQueryLower("Personal_data", "id_person", "4"));
    }

    @Test
    public void higherQueryTest(){
        Assertions.assertEquals(higherQuery, SelectQueryBuilder.buildQueryHigher("Personal_data", "id_person", "2"));
    }

    @Test
    public void likeQueryTest(){
        Assertions.assertEquals(likeQuery, SelectQueryBuilder.buildQueryLike("Personal_data", "name", "Maciej"));
    }

    @Test
    public void betweenQueryTest(){
        Assertions.assertEquals(betweenQuery, SelectQueryBuilder.buildQueryBetween("Personal_data", "id_person", "0", "3"));
    }

    @Test
    public void joinQueryTest(){
        Assertions.assertEquals(joinQuery, SelectQueryBuilder.buildQueryJoin("Players", "Personal_data","personal_data_id", "id_person"));
    }

    @Test
    public void passwordCheckQueryTest(){
        Assertions.assertEquals(passwordCheckQuery, SelectQueryBuilder.buildPasswordCheckQuery("*", "Personal_data", "pytkus", "password"));
    }



}
