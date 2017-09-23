package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HDemand;

public class DemandMapper extends BaseMapper implements RowMapper<HDemand> {

    public HDemand mapRow(ResultSet rs, int rowNum) throws SQLException {

	HDemand ob = new HDemand();

	int colindex = 0;

	colindex = findColumn(rs, "did");
	if (colindex > 0) {
	    ob.setDid(rs.getString(colindex));
	}
	colindex = findColumn(rs, "brdc");
	if (colindex > 0) {
	    ob.setBrdc(rs.getString(colindex));
	}
	colindex = findColumn(rs, "brdnj");
	if (colindex > 0) {
	    ob.setBrdnj(rs.getString(colindex));
	}
	colindex = findColumn(rs, "brdna");
	if (colindex > 0) {
	    ob.setBrdna(rs.getString(colindex));
	}
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
	colindex = findColumn(rs, "pdtp");
	if (colindex > 0) {
	    ob.setPdtp(rs.getString(colindex));
	}
	colindex = findColumn(rs, "pdnm");
	if (colindex > 0) {
	    ob.setPdnm(rs.getString(colindex));
	}
	colindex = findColumn(rs, "dam");
	if (colindex > 0) {
	    ob.setDam(rs.getDouble(colindex));
	}
	colindex = findColumn(rs, "unt");
	if (colindex > 0) {
	    ob.setUnt(rs.getString(colindex));
	}
	colindex = findColumn(rs, "utp");
	if (colindex > 0) {
	    ob.setUtp(rs.getDouble(colindex));
	}
	colindex = findColumn(rs, "cur");
	if (colindex > 0) {
	    ob.setCur(rs.getString(colindex));
	}
	colindex = findColumn(rs, "dta");
	if (colindex > 0) {
	    ob.setDta(rs.getDouble(colindex));
	}
	colindex = findColumn(rs, "pddc");
	if (colindex > 0) {
	    ob.setPddc(rs.getString(colindex));
	}
	colindex = findColumn(rs, "dtop");
	if (colindex > 0) {
	    ob.setDtop(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtod");
	if (colindex > 0) {
	    ob.setDtod(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtpm");
	if (colindex > 0) {
	    ob.setDtpm(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtsp");
	if (colindex > 0) {
	    ob.setDtsp(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtrc");
	if (colindex > 0) {
	    ob.setDtrc(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtcc");
	if (colindex > 0) {
	    ob.setDtcc(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtrf");
	if (colindex > 0) {
	    ob.setDtrf(rs.getDate(colindex));
	}
	colindex = findColumn(rs, "dtdd");
	if (colindex > 0) {
	    ob.setDtdd(rs.getDate(colindex));
	}

	colindex = findColumn(rs, "dpid");
	if (colindex > 0) {
	    ob.setDpid(rs.getString(colindex));
	}

	colindex = findColumn(rs, "sadr");
	if (colindex > 0) {
	    ob.setSadr(rs.getString(colindex));
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
	colindex = findColumn(rs, "sid");
	if (colindex > 0) {
	    ob.setSid(rs.getString(colindex));
	}
	
	return ob;
    }

}
