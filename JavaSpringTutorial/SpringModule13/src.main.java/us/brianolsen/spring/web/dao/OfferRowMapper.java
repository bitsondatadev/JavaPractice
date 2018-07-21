package us.brianolsen.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import us.brianolsen.spring.web.model.Offer;
import us.brianolsen.spring.web.model.User;

public class OfferRowMapper implements RowMapper<Offer>{

	@Override
	public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Offer offer = new Offer();
		User user = new User();
		
		user.setAuthority(resultSet.getString("authority"));
		user.setEnabled(true);
		user.setName(resultSet.getString("name"));
		user.setEmail(resultSet.getString("email"));
		user.setUsername(resultSet.getString("username"));

		offer.setId(resultSet.getInt("id"));
		offer.setText(resultSet.getString("text"));
		offer.setUser(user);

		return offer;
	}

}
