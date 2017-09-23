package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HBrand;

public class BrandMapper extends BaseMapper implements RowMapper<HBrand> {

	public HBrand mapRow(ResultSet rs, int rowNum) throws SQLException {
		HBrand ob = new HBrand();
		
		int colindex = 0;
		
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
