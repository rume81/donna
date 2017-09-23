package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HSettlement;

public class SettlementMapper extends BaseMapper implements RowMapper<HSettlement> {
	public HSettlement mapRow(ResultSet rs, int rowNum) throws SQLException {
		HSettlement ob = new HSettlement();

		int colindex = 0;

		colindex = findColumn(rs, "stlc");
		if (colindex > 0) {
			ob.setStlc(rs.getString(colindex));
		}
		
		colindex = findColumn(rs, "stln");
		if (colindex > 0) {
			ob.setStln(rs.getString(colindex));
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
