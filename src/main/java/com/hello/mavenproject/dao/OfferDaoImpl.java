package com.hello.mavenproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.hello.mavenproject.api.Offer;

public class OfferDaoImpl implements OfferDao {
     
	@Autowired 
	NamedParameterJdbcTemplate nameParameterJdbcTemplete;
	@Override
	public List<Offer> loadAllOffer() {
		String sql = "SELECT id, companyname, offerdetails, price FROM School.simOffer;";
		nameParameterJdbcTemplete.query(sql, getSqlParameter(null), new OfferMapper());
		return null;
	}
	
	private SqlParameterSource getSqlParameter(Offer offer) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", offer.getId());
		parameterSource.addValue("companyname", offer.getCompanayName());
		parameterSource.addValue("offerdetails", offer.getOfferDetails());
		parameterSource.addValue("price", offer.getPrice());
		return parameterSource;
	}
	private static final class OfferMapper implements RowMapper<Offer>{

		@Override
		public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
			Offer offer = new Offer();
			offer.setId(rs.getInt("id"));
			offer.setCompanayName(rs.getString("companyname"));
			offer.setOfferDetails(rs.getString("offerdetails"));
			offer.setPrice(rs.getInt("price"));
			
			return offer;
		}
		
		
	}

	@Override
	public void addOffer(Offer offer) {
	 String sql = "INSERT INTO companyname, offerdetails, price VALUES (?, ?, ?)";
	 nameParameterJdbcTemplete.update(sql, getSqlParameter(offer));

	}

	@Override
	public void updateOffer() {
      String sql ="";
	}

	@Override
	public void deleteOffer() {
     String sql ="";		

	}

	@Override
	public Offer findByOfferId() {
		
		return null;
	}

}
