package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HTransactionLog;

public class TransactionLogMapper extends BaseMapper implements RowMapper<HTransactionLog> {

    @Override
    public HTransactionLog mapRow(ResultSet rs, int rowNum) throws SQLException {
	HTransactionLog ob = new HTransactionLog();
	
	int colindex = 0;
	
	colindex = findColumn(rs, "tsid");
	if (colindex > 0) {
	    ob.setTsid(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "dtts");
	if (colindex > 0) {
	    ob.setDtts(rs.getDate(colindex));
	}
	
	colindex = findColumn(rs, "action");
	if (colindex > 0) {
	    ob.setAction(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "actionid");
	if (colindex > 0) {
	    ob.setActionid(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "location");
	if (colindex > 0) {
	    ob.setLocation(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "updatedinfo");
	if (colindex > 0) {
	    ob.setUpdatedinfo(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "previousinfo");
	if (colindex > 0) {
	    ob.setPreviousinfo(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "changeby");
	if (colindex > 0) {
	    ob.setChangeby(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "isdeleted");
	if (colindex > 0) {
	    ob.setIsdeleted(rs.getBoolean(colindex));
	}
	    
	return ob;
    }

}
