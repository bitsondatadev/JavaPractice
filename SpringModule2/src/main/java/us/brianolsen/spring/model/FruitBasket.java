package us.brianolsen.spring.model;

import java.util.List;

public class FruitBasket {
	private String name;
	private List<String> fruits;

	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FruitBasket [name=");
		builder.append(name);
		builder.append(", fruits=");
		builder.append(fruits);
		builder.append("]");
		return builder.toString();
	}

}
