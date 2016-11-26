package us.brianolsen.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import us.brianolsen.spring.model.Address;
import us.brianolsen.spring.model.FruitBasket;
import us.brianolsen.spring.model.Jungle;
import us.brianolsen.spring.model.Person;

public class App {
	public static void main(String[] args) {
		// fileSystemContext and classPathContext can be used interchangeably
		// for the most part.
		ApplicationContext fileSystemContext = new FileSystemXmlApplicationContext(
				"/src/main/resources/us/brianolsen/spring/beans.xml");
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext(
				"us/brianolsen/spring/beans.xml");

		testGetBean(classPathContext);
		testGetSingletonBeanVsPrototypeBeanScope(classPathContext);
		testUsingPNamespaceSetter(fileSystemContext);
		testInjectingCollections(fileSystemContext);
		testReferencingBeans(classPathContext);

		System.out.println("-------------------CLOSE CONTEXTS-------------------");
		((ClassPathXmlApplicationContext) classPathContext).close();
		((FileSystemXmlApplicationContext) fileSystemContext).close();
	}

	public static void testGetBean(ApplicationContext context) {
		beforeTest("testGetBean");
		// notice how person depends on Address and that this is
		// automatically injected upon calling getBean
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}

	public static void testGetSingletonBeanVsPrototypeBeanScope(ApplicationContext context) {
		beforeTest("testGetSingletonBeanVsPrototypeBeanScope");
		Person person = (Person) context.getBean("person");
		Person person2 = (Person) context.getBean("person");
		// notice how we are also using a person factory to create below
		Person protoPerson = (Person) context.getBean("personPrototype");
		Person protoPerson2 = (Person) context.getBean("personPrototype");

		person2.setTaxId(666);
		protoPerson2.setTaxId(666);

		System.out.println("Singleton");
		System.out.println(person);
		System.out.println(person2);

		System.out.println("Prototype");
		System.out.println(protoPerson);
		System.out.println(protoPerson2);
	}

	public static void testUsingPNamespaceSetter(ApplicationContext context) {
		beforeTest("testUsingPNamespaceSetter");
		// Setting values using p namespace
		Address address2 = (Address) context.getBean("address2");
		System.out.println(address2);
	}

	public static void testInjectingCollections(ApplicationContext context) {
		beforeTest("testInjectingCollections");
		// How to set list values in
		FruitBasket basket = (FruitBasket) context.getBean("basket");
		System.out.println(basket);
	}
	
	public static void testReferencingBeans(ApplicationContext context){
		beforeTest("testReferencingBeans");
		 Jungle jungle = (Jungle) context.getBean("jungle");
		 System.out.println(jungle);
	}

	public static void beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}
}
