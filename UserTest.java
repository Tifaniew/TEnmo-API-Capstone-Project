import com.techelevator.tenmo.model.Authority;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UserTest {
    User user = new User();
    @Test
    public void username_is_correct() {
        user.setUsername("Tiffany");
        Assert.assertEquals(user.getUsername(),"Tiffany");
    }
    @Test
    public void password_is_password1(){
        user.setPassword("password1");
        Assert.assertEquals(user.getPassword(), "password1");
    }
   @Test
    public void account_isActivated_equals_true() {
       user.setActivated(true);
       Assert.assertEquals(user.isActivated(), true);
    }
    @Test
    public void setAuthority_equals_ADMIN() {
        Set<Authority> ADMIN = new HashSet<Authority>();
        user.setAuthorities(ADMIN);
        Assert.assertEquals(user.getAuthorities(), ADMIN);
    }

}
