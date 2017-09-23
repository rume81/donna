package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HCategory;

public class CategoryMapper extends BaseMapper implements RowMapper<HCategory> {

    public HCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

	HCategory ob = new HCategory();

	int colindex = 0;

	colindex = findColumn(rs, "ctgc");
	if (colindex > 0) {
	    ob.setCtgc(rs.getString(colindex));
	}
	colindex = findColumn(rs, "ctgnj");
	if (colindex > 0) {
	    ob.setCtgnj(rs.getString(colindex));
	}
	colindex = findColumn(rs, "ctgna");
	if (colindex > 0) {
	    ob.setCtgna(rs.getString(colindex));
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
