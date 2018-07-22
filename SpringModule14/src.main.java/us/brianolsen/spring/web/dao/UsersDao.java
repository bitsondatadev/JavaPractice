package us.brianolsen.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import us.brianolsen.spring.web.model.User;

@Repository
@Transactional
@Component("usersDao")
public class UsersDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SessionFactory sessionFactory;

	// private NamedParameterJdbcTemplate jdbc;

	// @Autowired
	// public void setJdbc(DataSource jdbc) {
	// this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	// }

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(User user) {
		// public boolean createUser(User user) {
		// BeanPropertySqlParameterSource parameters = new
		// BeanPropertySqlParameterSource(user);
		// MapSqlParameterSource params = new MapSqlParameterSource();
		//
		// params.addValue("username", user.getUsername());
		// params.addValue("password",
		// passwordEncoder.encode(user.getPassword()));
		// params.addValue("email", user.getEmail());
		// params.addValue("name", user.getName());
		// params.addValue("enabled", user.isEnabled());
		// params.addValue("authority", user.getAuthority());

		// return jdbc.update(
		// "insert into users (username, password, email, name, enabled,
		// authority) value (:username, :password, :email, :name, :enabled,
		// :authority)",
		// params) == 1;
		// }
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public boolean exists(String username) {
		// return jdbc.queryForObject("select count(*) from users where
		// username=:username",
		// new MapSqlParameterSource("username", username), Integer.class) > 0;
		Criteria crit = session().createCriteria(User.class);
		// crit.add(Restrictions.eq("username", username));
		crit.add(Restrictions.idEq(username));
		User user = (User) crit.uniqueResult();
		return user != null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		// return jdbc.query("select * from users",
		// BeanPropertyRowMapper.newInstance(User.class));
		return session().createQuery("from User").list();
	}

}
