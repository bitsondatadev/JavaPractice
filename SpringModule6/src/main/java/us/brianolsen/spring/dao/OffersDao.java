package us.brianolsen.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import us.brianolsen.spring.model.Offer;

@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(resultSet.getInt("id"));
				offer.setName(resultSet.getString("name"));
				offer.setEmail(resultSet.getString("email"));
				offer.setText(resultSet.getString("text"));

				return offer;
			}

		});
	}

	public List<Offer> getOffersByName() {
		MapSqlParameterSource parameterMap = new MapSqlParameterSource();
		parameterMap.addValue("name", "Sue");
		return jdbc.query("select * from offers where name = :name", parameterMap, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(resultSet.getInt("id"));
				offer.setName(resultSet.getString("name"));
				offer.setEmail(resultSet.getString("email"));
				offer.setText(resultSet.getString("text"));

				return offer;
			}

		});
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource parameterMap = new MapSqlParameterSource();
		parameterMap.addValue("id", id);
		return jdbc.queryForObject("select * from offers where id = :id", parameterMap, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(resultSet.getInt("id"));
				offer.setName(resultSet.getString("name"));
				offer.setEmail(resultSet.getString("email"));
				offer.setText(resultSet.getString("text"));

				return offer;
			}

		});
	}
	
	public boolean updateOffer(Offer offer){
		BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", parameters) == 1;
	}

	public boolean deleteOffer(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbc.update("delete from offers where id = :id", parameters) == 1;
	}
	
	public boolean createOffer(Offer offer){
		BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name, text, email) value (:name, :text, :email)", parameters) == 1;
	}
	
	@Transactional
	public int[] createOffers(List<Offer> offers){
		SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offers (id, name, text, email) value (:id, :name, :text, :email)", parameters);
	}
}
