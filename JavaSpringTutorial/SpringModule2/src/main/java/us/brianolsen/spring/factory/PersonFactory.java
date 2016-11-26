package us.brianolsen.spring.factory;

import us.brianolsen.spring.model.Person;

public class PersonFactory {
	public Person createPerson(int id, String name){
		System.out.println("Using factory to create method.");
		return new Person(id,name);
	}
}
