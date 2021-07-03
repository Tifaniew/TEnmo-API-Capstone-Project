import com.techelevator.tenmo.model.LoginDTO;
import org.junit.Assert;
import org.junit.Test;

public class LoginDTOTest {
    LoginDTO loginDTO = new LoginDTO();
    @Test
    public void username_is_John() {
        loginDTO.setUsername("John");
        Assert.assertEquals(loginDTO.getUsername(), "John");
    }

    @Test
    public void password_equals_mypassword() {
        loginDTO.setPassword("mypassword");
        Assert.assertEquals(loginDTO.getPassword(), "mypassword");
    }
}
