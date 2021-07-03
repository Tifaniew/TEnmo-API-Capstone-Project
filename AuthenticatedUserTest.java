import com.techelevator.tenmo.model.AuthenticatedUser;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatedUserTest {
    AuthenticatedUser authenticatedUser = new AuthenticatedUser();

    @Test
    public void token_is_correct() {
        authenticatedUser.setToken("1358tWhXCW");
        Assert.assertEquals(authenticatedUser.getToken(), "1358tWhXCW");

    }
}
