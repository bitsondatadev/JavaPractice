package us.brianolsen.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import us.brianolsen.spring.model.Offer;

@Component("offersDao")
public class OffersDao {

	private JdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
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
}
