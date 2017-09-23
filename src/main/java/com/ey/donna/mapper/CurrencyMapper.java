package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HCurrency;

public class CurrencyMapper extends BaseMapper implements RowMapper<HCurrency> {

    public HCurrency mapRow(ResultSet rs, int rowNum) throws SQLException {

	HCurrency ob = new HCurrency();

	int colindex = 0;

	colindex = findColumn(rs, "curc");
	if (colindex > 0) {
	    ob.setCurc(rs.getString(colindex));
	}
	colindex = findColumn(rs, "curn");
	if (colindex > 0) {
	    ob.setCurn(rs.getString(colindex));
	}

	colindex = findColumn(rs, "isdeleted");
	if (colindex > 0) {
	    ob.setIsdeleted(rs.getBoolean(colindex));
	}

	colindex = findColumn(rs, "modifiedby");
	if (colindex > 0) {
	    ob.setModifiedby(rs.getString(colindex));
	}

	colindex = findColumn(rs, "instime");
	if (colindex > 0) {
	    ob.setInstime(rs.getDate(colindex));
	}

	colindex = findColumn(rs, "modifiedtime");
	if (colindex > 0) {
	    ob.setModifiedtime(rs.getDate(colindex));
	}

	return ob;

    }

}
