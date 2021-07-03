import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Assert;
import org.junit.Test;

public class TransferTest {
    Transfer transfer = new Transfer();

    @Test
    public void transferId_equals_7() {
        transfer.setTransferId(7);
        Assert.assertEquals(transfer.getTransferId(), 7);
    }

    @Test
    public void transferTypeId_equals_1() {
        transfer.setTransferTypeId(1);
        Assert.assertEquals(transfer.getTransferTypeId(), 1);

    }
    @Test
    public void transferStatusId_equals_2(){
        transfer.setTransferStatusId(2);
        Assert.assertEquals(transfer.getTransferStatusId(),2);
    }
    @Test
    public void accountFrom_is_correct(){
        transfer.setAccountFrom(1001);
        Assert.assertEquals(transfer.getAccountFrom(), 1001,1001);
        }
    @Test
    public void accountTo_is_correct(){
        transfer.setAccountTo(1003);
        Assert.assertEquals(transfer.getAccountTo(), 1003,1003);
    }
    @Test
    public void amountOfTransfer_is_correct(){
        transfer.setAmount(5000);
        Assert.assertEquals(transfer.getAmount(),5000, 5000);
    }
    }

