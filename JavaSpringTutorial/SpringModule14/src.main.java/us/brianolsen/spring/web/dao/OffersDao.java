package us.brianolsen.spring.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import us.brianolsen.spring.web.model.Offer;

@Transactional
@Repository
@Component("offersDao")
public class OffersDao {

	// private NamedParameterJdbcTemplate jdbc;
	//
	// @Autowired
	// public void setJdbc(DataSource jdbc) {
	// this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	// }

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public List<Offer> getOffers() {
		// return jdbc.query(
		// "select * from offers, users where offers.users_username =
		// users.username and users.enabled = true",
		// new OfferRowMapper());
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));

		return crit.list();
	}

	public List<Offer> getOffers(String username) {
		// return jdbc.query(
		// "select * from offers, users where offers.users_username =
		// users.username and users.enabled = true and
		// users.username=:username",
		// new MapSqlParameterSource("username", username), new
		// OfferRowMapper());

		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.username", username));
		crit.add(Restrictions.eq("u.enabled", true));

		return crit.list();
	}

	public Offer getOffer(int id) {
		// MapSqlParameterSource parameterMap = new MapSqlParameterSource();
		// parameterMap.addValue("id", id);
		// return jdbc.queryForObject(
		// "select * from offers, users where offers.users_username =
		// users.username and users.enabled = true and id = :id",
		// parameterMap, new OfferRowMapper());

		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.idEq(id));
		crit.add(Restrictions.eq("u.enabled", true));

		return (Offer) crit.uniqueResult();
	}

	public boolean deleteOffer(int id) {

		// MapSqlParameterSource parameters = new MapSqlParameterSource();
		// parameters.addValue("id", id);
		// return jdbc.update("delete from offers where id = :id", parameters)
		// == 1;

		// Even though this looks identical to the SQL statements, the advantage
		// of using HQL is that if you ever change the database schema, or
		// change the database itself. This same query will still work
		// regardless of these changes provided you update the Offer mapping.
		Query query = session().createQuery("delete from Offer where id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public void saveOrUpdate(Offer offer) {
		// BeanPropertySqlParameterSource parameters = new
		// BeanPropertySqlParameterSource(offer);
		// return jdbc.update("insert into offers (users_username, text) values
		// (:username, :text)", parameters) == 1;
		session().saveOrUpdate(offer);
	}

	//
	// public List<Offer> getOffersByName() {
	// MapSqlParameterSource parameterMap = new MapSqlParameterSource();
	// parameterMap.addValue("name", "Sue");
	// return jdbc.query("select * from offers where name = :name",
	// parameterMap, new RowMapper<Offer>() {
	//
	// public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException
	// {
	// Offer offer = new Offer();
	//
	// offer.setId(resultSet.getInt("id"));
	// offer.setText(resultSet.getString("text"));
	//
	// return offer;
	// }
	//
	// });
	// }

	// search for hibernate batch to do this.
	// @Transactional
	// public int[] createOffers(List<Offer> offers) {
	// SqlParameterSource[] parameters =
	// SqlParameterSourceUtils.createBatch(offers.toArray());
	// return jdbc.batchUpdate("insert into offers (users_username, text) values
	// (:username, :text)", parameters);
	// }
}
