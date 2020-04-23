package Banking1.Banking1;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.cg.service.AccountService;
import com.cg.service.CustomerService;
import com.cg.service.TransactionService;


public class MainMethod {
	public static void main(String []args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beanConfigg.xml");
		AccountService aserv = ctx.getBean("aservice", AccountService.class);
		CustomerService cserv = ctx.getBean("cservice", CustomerService.class);
		TransactionService tserv = ctx.getBean("tservice", TransactionService.class);
		
		System.out.println(tserv.makeTransaction(1001, 1111, 500.0, "101PG"));
		//System.out.println(aserv.getAccount("sulo"));
		
		//System.out.println(cserv.ValidateUser("sulo", "serfe"));
		System.out.println(aserv.findById(1).getAccount_no()+"dfsdgsdgsf");
		System.out.println(cserv.getCustomerDetails("sulo").getAccount().getAccount_no());
	}

}
