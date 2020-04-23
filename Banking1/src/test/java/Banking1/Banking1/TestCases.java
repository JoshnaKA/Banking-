package Banking1.Banking1;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.cg.service.AccountService;
import com.cg.service.CustomerService;
import com.cg.service.TransactionService;


public class TestCases {

	
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beanConfigg.xml");
    AccountService aserv = ctx.getBean("aservice", AccountService.class);
    CustomerService cserv = ctx.getBean("cservice", CustomerService.class);
    TransactionService tserv = ctx.getBean("tservice", TransactionService.class);      
    

    @Test
    public void paymentGatewayFieldsAreMandatory() {
                    assertTrue(tserv.makeTransaction(1001, 1111, 500, null).contains("PaymentGateway"));
    }

    @Test
    public void UserNameCannotBeNull() {
                    assertFalse(cserv.ValidateUser(null, "13456"));
    }
    
    @Test
    public void passwordCannotBeNull() {
                    assertFalse(cserv.ValidateUser("Sulo", null));
    }
    
    @Test
    public void CorrectDetailsMustAllowAccess() {
                    System.out.println("Test");
                    System.out.println(cserv.ValidateUser("sulo", "sulo@123"));
                    assertTrue(cserv.ValidateUser("sulo", "sulo@123"));
    }

    @Test
    public void transactionAmountCantBeZero() {
                    assertTrue(tserv.makeTransaction(1001, 1111, 0, "123PG").contains("Amount"));

    }

    @Test
    public void transactionResponsMustMentionStatusOfTransaction() {
                    assertTrue(tserv.makeTransaction(1001, 1111, 1000, "123PG").equals("Success"));
    }

    @Test
    public void transactionMustBeIncompleteDueToInsufficientBalance() {
                    assertTrue(tserv.makeTransaction(1001, 1111, 100000000, "123PG").contains("Insufficient"));
    }

    @Test
    public void userAccountCannoBeNull() {
                    System.out.println(tserv.makeTransaction(0, 1111, 1000, "123PG"));
                    assertTrue(tserv.makeTransaction(0, 1111, 1000, "123PG").contains("User account cannot be null"));
    }
    @Test
    public void merchantAccountInvalid() {
                    System.out.println(tserv.makeTransaction(1001, 11111, 1000, "123PG"));
    }

    @Test
    public void merchantAccountCannoBeNull() {
                    assertTrue(tserv.makeTransaction(1001, 0, 1000, "123PG").contains("Merchant account cannot be null"));
    }

}
