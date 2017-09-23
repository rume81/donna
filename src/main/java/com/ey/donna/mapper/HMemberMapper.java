package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HMember;


public class HMemberMapper extends BaseMapper implements RowMapper<HMember> {

	public HMember mapRow(ResultSet rs, int rowNum) throws SQLException {
	    HMember ob = new HMember();
		
	    int colindex = 0;
		
	    colindex = findColumn(rs, "pid");
	    if (colindex > 0) {
		ob.setPid(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "fname");
	    if (colindex > 0) {
		ob.setFname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "lname");
	    if (colindex > 0) {
		ob.setLname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "mname");
	    if (colindex > 0) {
		ob.setMname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "nname");
	    if (colindex > 0) {
		ob.setNname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "fdname");
	    if (colindex > 0) {
		ob.setFdname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "ldname");
	    if (colindex > 0) {
		ob.setLdname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "mdname");
	    if (colindex > 0) {
		ob.setMdname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "ndname");
	    if (colindex > 0) {
		ob.setNdname(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "pass");
	    if (colindex > 0) {
		ob.setPass(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "mad");
	    if (colindex > 0) {
		ob.setMad(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "adr");
	    if (colindex > 0) {
		ob.setAdr(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "adrj");
	    if (colindex > 0) {
		ob.setAdrj(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "cna");
	    if (colindex > 0) {
		ob.setCna(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "cnj");
	    if (colindex > 0) {
		ob.setCnj(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "stlc");
	    if (colindex > 0) {
		ob.setStlc(rs.getString(colindex));
	    }
	    
	    colindex = findColumn(rs, "msta");
	    if (colindex > 0) {
		String mstaindb = rs.getString(colindex);
		String msta = "";
		if(mstaindb!=null)
		    msta =mstaindb.substring(0,5);
		ob.setMsta(msta);
	    }
	    
	    colindex = findColumn(rs, "verified");
	    if (colindex > 0) {
		ob.setVerified(rs.getInt(colindex));
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
