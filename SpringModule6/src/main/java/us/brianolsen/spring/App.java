package us.brianolsen.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.dao.OffersDao;
import us.brianolsen.spring.model.Offer;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("us/brianolsen/spring/beans.xml");

		executeQueriesOnOffersDao(classPathContext);
		
		System.out.println("-------------------CLOSE CONTEXTS-------------------");
		((ClassPathXmlApplicationContext) classPathContext).close();
	}
	public static void executeQueriesOnOffersDao(ApplicationContext context) {
		OffersDao offersDao = (OffersDao) context.getBean("offersDao");
		
		List<Offer> offers = offersDao.getOffers();
		
		for(Offer offer : offers){
			System.out.println(offer);
		}

	}



}
