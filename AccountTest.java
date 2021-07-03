import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Test;



public class AccountTest {

    Account account = new Account();

    @Test
    public void accountId_equals_10() {
        account.setAccountId(10);
        Assert.assertEquals(account.getAccountId(), 10);
    }

    @Test
    public void userId_equals_10() {
        account.setUserId(10);
        Assert.assertEquals(account.getUserId(), 10);

    }
    @Test
    public void accountBalance_equals_3000(){
        account.setBalance(3000);
        Assert.assertEquals(account.getBalance(),3000, 3000);
    }
}
