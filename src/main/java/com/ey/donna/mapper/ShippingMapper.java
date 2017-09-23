/* ========================================
* AMS v. 1.0 class library
* ========================================
*
* http://www.ams.com
*
* (C) Copyright 2016-2020, by EY.
*
* --------------------
* ShipmentMapper.java
* --------------------
* Created on Jun 5, 2017
*
* Revision: 
* Author: Abdullah-Al-Monsur (ALA)
* Source: 
* Id:  
*
* Jun 5, 2017: Original version (ALA)
*
*/
package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HShipping;

public class ShippingMapper extends BaseMapper implements RowMapper<HShipping> {
    @Override
    public HShipping mapRow(ResultSet rs, int rowNum) throws SQLException {
	HShipping ob = new HShipping();

	int colindex = 0;

	colindex = findColumn(rs, "smtc");
	if (colindex > 0) {
	    ob.setSmtc(rs.getString(colindex));
	}

	colindex = findColumn(rs, "smtn");
	if (colindex > 0) {
	    ob.setSmtn(rs.getString(colindex));
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
