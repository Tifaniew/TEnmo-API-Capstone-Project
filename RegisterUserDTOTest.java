import com.techelevator.tenmo.model.RegisterUserDTO;
import org.junit.Assert;
import org.junit.Test;

public class RegisterUserDTOTest {
    RegisterUserDTO registerUserDTO = new RegisterUserDTO();

    @Test
    public void username_is_Wendy() {
        registerUserDTO.setUsername("Wendy");
        Assert.assertEquals(registerUserDTO.getUsername(), "Wendy");
    }

    @Test
    public void password_is_newpassword() {
        registerUserDTO.setPassword("newpassword");
        Assert.assertEquals(registerUserDTO.getPassword(), "newpassword");
    }
}
