package us.brianolsen.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

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
		
		System.out.println("------getOffersByName()-----");
		try {
			List<Offer> offers = offersDao.getOffersByName();
			
			for(Offer offer : offers){
				System.out.println(offer);
			}
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------getOffer(int id)-----");
		try {
			Offer offer = offersDao.getOffer(2);
			System.out.println(offer);
			
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------delteOffer(int id)-----");
		try {
			System.out.println(offersDao.deleteOffer(3));
			
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------createOffer(Offer offer)-----");
		try {
			Offer offer = new Offer();
			offer.setEmail("sue@nowhere.com");
			offer.setName("Sue");
			offer.setText("Php Programmer");
			//offersDao.creatOffer(offer);
			
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------createOffers(List<Offer> offers)-----");
		try {
			Offer offer1 = new Offer();
			Offer offer2 = new Offer();
			Offer offer3 = new Offer();
			
			offer1.setEmail("phil@nowhere.com");
			offer1.setName("Phil");
			offer1.setText("Ruby Programmer");
			offer1.setId(11);
			
			offer2.setEmail("jerry@nowhere.com");
			offer2.setName("Jerry");
			offer2.setText("Database MySql Programmer");
			offer2.setId(12);
			
			offer3.setEmail("alan@nowhere.com");
			offer3.setName("Alan");
			offer3.setText("C++ Programmer");
			offer3.setId(11);
			
			offersDao.createOffers(Arrays.asList(offer1, offer2, offer3));
			
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------updateOffer(Offer offer)-----");
		try {
			Offer offer = new Offer();
			offer.setEmail("sue@nowhere.com");
			offer.setName("Sue");
			offer.setText("Php and Java Programmer");
			offer.setId(4);
			offersDao.updateOffer(offer);
			
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		System.out.println("------getOffers()-----");
		try {
			List<Offer> offers = offersDao.getOffers();
			
			for(Offer offer : offers){
				System.out.println(offer);
			}
		}catch(CannotGetJdbcConnectionException e){
			System.out.println("No good database connection");
		}
		catch (DataAccessException e) {
			System.out.println("My Error Report:");
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}

	}



}
