package us.brianolsen.spring.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import us.brianolsen.spring.web.dao.FormValidationGroup;
import us.brianolsen.spring.web.dao.PersistenceValidationGroup;
import us.brianolsen.spring.web.validation.ValidEmail;

@Entity
@Table(name = "users")
public class User {

	@NotBlank(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Size(min = 8, max = 15, groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Pattern(regexp = "^\\w{8,}$", groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Id
	// @Column(name = "username") // optional unless different username
	private String username;

	@NotBlank(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Size(min = 8, max = 15, groups = { FormValidationGroup.class })
	@Pattern(regexp = "^\\S+$", groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	private String password;

	@ValidEmail(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	private String email;

	@NotBlank(groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	@Size(min = 8, max = 60, groups = { PersistenceValidationGroup.class, FormValidationGroup.class })
	private String name;

	private boolean enabled = false;
	private String authority;

	public User() {
	}

	public User(String username, String password, String email, String name, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (enabled != other.enabled)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", name=");
		builder.append(name);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", authority=");
		builder.append(authority);
		builder.append("]");
		return builder.toString();
	}

}
