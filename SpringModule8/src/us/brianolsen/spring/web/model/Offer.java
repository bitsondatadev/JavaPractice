package us.brianolsen.spring.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import us.brianolsen.spring.web.validation.ValidEmail;

public class Offer {
	private int id;
	
	
	@Size(min=5,max=100, message="Name must be between 5 and 100 characters.")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="Doesn't appear to be a valid email address.")
	@ValidEmail(message="This email address is not valid.")
	private String email;
	
	@Size(min=20,max=255, message="Name must be between 20 and 255 characters.")
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Offer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}
}
