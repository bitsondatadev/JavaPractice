package us.brianolsen.spring.model;

import java.util.List;
import java.util.Map;

public class Jungle {
	private Animal largest;
	private List<Animal> animals;
	private Map<String, String> foods;
	private Map<String, Animal> animalMap;

	public void setAnimalMap(Map<String, Animal> animalMap) {
		this.animalMap = animalMap;
	}

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	public Animal getLargest() {
		return largest;
	}

	public void setLargest(Animal largest) {
		this.largest = largest;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jungle [largest=");
		builder.append(largest);
		builder.append(", animals=");
		builder.append(animals);
		builder.append(", foods=");
		builder.append(foods);
		builder.append(", animalMap=");
		builder.append(animalMap);
		builder.append("]");
		return builder.toString();
	}

}
