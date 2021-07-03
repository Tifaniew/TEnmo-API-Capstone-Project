import com.techelevator.tenmo.model.Authority;
import org.junit.Assert;
import org.junit.Test;

public class AuthorityTest {
    Authority authority = new Authority("Lisa");

    @Test
    public void authority_equals_Lisa() {
        authority.setName("Lisa");
        Assert.assertEquals(authority.getName(), "Lisa");
    }
}
