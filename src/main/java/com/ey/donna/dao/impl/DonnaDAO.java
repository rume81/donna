package com.ey.donna.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;

import com.ey.donna.dao.interfaces.IDonnaDAO;
import com.ey.donna.mapper.BrandMapper;
import com.ey.donna.mapper.CategoryMapper;
import com.ey.donna.mapper.CurrencyMapper;
import com.ey.donna.mapper.DemandMapper;
import com.ey.donna.mapper.DemandPhotosMapper;
import com.ey.donna.mapper.HMemberMapper;
import com.ey.donna.mapper.SettlementMapper;
import com.ey.donna.mapper.ShippingMapper;
import com.ey.donna.mapper.SupplyMapper;
import com.ey.donna.mapper.SupplyPhotosMapper;
import com.ey.donna.mapper.TransactionLogMapper;
import com.ey.donna.model.HBrand;
import com.ey.donna.model.HCategory;
import com.ey.donna.model.HCurrency;
import com.ey.donna.model.HDemand;
import com.ey.donna.model.HDemandPhotos;
import com.ey.donna.model.HMember;
import com.ey.donna.model.HSettlement;
import com.ey.donna.model.HShipping;
import com.ey.donna.model.HSupply;
import com.ey.donna.model.HSupplyPhotos;
import com.ey.donna.model.HTransactionLog;
import com.ey.donna.model.HUpload;


public class DonnaDAO extends BaseDAO implements IDonnaDAO {
    private final Logger logger = LoggerFactory.getLogger(DonnaDAO.class);
    /* Abdullah Al Monsur Start*/
    @Override
    public List<HMember> getMemberList(String pid) {
	List<HMember> mem = new ArrayList<HMember>();
	try {
	    if(pid.equals("")){
		mem = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM member WHERE isdeleted=false",
			    new HMemberMapper());
	    } else{    
		mem = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM member WHERE pid ='" + pid + "' AND isdeleted=false",
		    new HMemberMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return mem;
    }
    
    @Override
    public HMember getEmployeeByPassword(boolean isDeleted, String userName, String pass) {
	HMember profile = null;
	try {
		profile = getJdbcService().getJdbcTemplate().queryForObject(
		    "SELECT * FROM member WHERE pid ='" + userName + "' AND pass=MD5('" + pass + "') AND verified>0 AND isdeleted=false",
		    new HMemberMapper());
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return profile;
    }
    
    @Override
    public HMember getMemberVerifyState(String userName) {
	HMember profile = null;
	try {
	    	    
	    profile = getJdbcService().getJdbcTemplate().queryForObject(
		    "SELECT * FROM member WHERE pid ='" + userName + "' AND verified>0 AND isdeleted=false",
		    new HMemberMapper());
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return profile;
    }
    
    @Override
    public boolean registerMember(HMember obj) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL insertmember('"+obj.getFdname()+"',MD5('"+obj.getPass()+"'),'"+obj.getMad()+"','"+obj.getMsta()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerMember(HMember obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public boolean updateMemberDetails(HMember obj,int opt) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL member("+opt+",'"+obj.getPid()+"','"+obj.getFname()+"','"+obj.getFdname()+"','"+obj.getLname()+"','"+obj.getLdname()+"','"+obj.getMname()+"','"+obj.getMdname()+"','"+obj.getNname()+"','"+obj.getNdname()+"','"+obj.getAdr()+"','"+obj.getAdrj()+"','"+obj.getCna()+"','"+obj.getCnj()+"','"+obj.getStlc()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerMember(HMember obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    //CALL verifymember('P0000000001')
    
    @Override
    public boolean verifyedMember(String pmid, int prevstat) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL verifymember('"+pmid+"',"+prevstat+")");
	    
	    logger.info("verifyedMember(HMember obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public HMember getMemberByEmail(String email) {
	HMember profile = null;
	try {
	    profile = getJdbcService().getJdbcTemplate().queryForObject(
		    "SELECT * FROM member WHERE mad ='" + email + "' AND isdeleted=false",
		    new HMemberMapper());
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return profile;
    }
    
    @Override
    public boolean registerBrand(HBrand obj) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL insertbrand('"+obj.getBrdna()+"','"+obj.getBrdnj()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerBrand(HBrand obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public List<HBrand> getBrandList(String bid) {
	List<HBrand> brn = new ArrayList<HBrand>();
	try {
	    if(bid.equals("")){
		brn = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM brand WHERE isdeleted=false",
			    new BrandMapper());
	    } else{    
		brn = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM brand WHERE brdc ='" + bid + "' AND isdeleted=false",
		    new BrandMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return brn;
    }
    
    @Override
    public boolean updateBrandDetails(HBrand obj,int opt) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL brand("+opt+",'"+obj.getBrdc()+"','"+obj.getBrdna()+"','"+obj.getBrdnj()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("updateBrandDetails(HMember obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public List<HCategory> getCategoryList(String cid) {
	List<HCategory> ctg = new ArrayList<HCategory>();
	try {
	    if(cid.equals("")){
		ctg = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM category WHERE isdeleted=false",
			    new CategoryMapper());
	    } else{    
		ctg = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM category WHERE ctgc ='" + cid + "' AND isdeleted=false",
		    new CategoryMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
    }
    
    @Override
    public boolean registerCategory(HCategory obj) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL insertcategory('"+obj.getCtgna()+"','"+obj.getCtgnj()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerCategory(HCategory obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public boolean updateCategoryDetails(HCategory obj,int opt) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL category("+opt+",'"+obj.getCtgc()+"','"+obj.getCtgna()+"','"+obj.getCtgnj()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("updateCategoryDetails(HCategory obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public boolean registerCurrency(HCurrency obj) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL insertcurrency('"+obj.getCurn()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerCurrency(HCurrency obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public List<HCurrency> getCurrencyList(String cid) {
	List<HCurrency> ctg = new ArrayList<HCurrency>();
	try {
	    if(cid.equals("")){
		ctg = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM currency WHERE isdeleted=false",
			    new CurrencyMapper());
	    } else{    
		ctg = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM currency WHERE curc ='" + cid + "' AND isdeleted=false",
		    new CurrencyMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
    }
    
    @Override
    public boolean updateCurrencyDetails(HCurrency obj,int opt) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL currency("+opt+",'"+obj.getCurc()+"','"+obj.getCurn()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("updateCurrencyDetails(HCurrency obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public boolean registerShipping(HShipping obj) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL insertshipping('"+obj.getSmtn()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("registerShipping(HShipping obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public List<HShipping> getShippingList(String cid) {
	List<HShipping> ctg = new ArrayList<HShipping>();
	try {
	    if(cid.equals("")){
		ctg = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM shipping WHERE isdeleted=false",
			    new ShippingMapper());
	    } else{    
		ctg = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM shipping WHERE smtc ='" + cid + "' AND isdeleted=false",
		    new ShippingMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
    }
    
    @Override
    public boolean updateShippingDetails(HShipping obj,int opt) {
	boolean fo = false;
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL shipping("+opt+",'"+obj.getSmtc()+"','"+obj.getSmtn()+"','"+obj.getModifiedby()+"')");
	    
	    logger.info("updateShippingDetails(HShipping obj) Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
    
    @Override
    public List<HTransactionLog> getTransactionLog(String cid) {
	List<HTransactionLog> ctg = new ArrayList<HTransactionLog>();
	try {
	    if(cid.equals("")){
		ctg = getJdbcService().getJdbcTemplate().query(
			    "SELECT * FROM transactionlog WHERE isdeleted=false",
			    new TransactionLogMapper());
	    } else{    
		ctg = getJdbcService().getJdbcTemplate().query(
		    "SELECT * FROM transactionlog WHERE tsid ='" + cid + "' AND isdeleted=false",
		    new TransactionLogMapper());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
    }
    @Override
    public Map<String,Integer> getLastWeekUpdate() {
	Map<String,Integer> reccount=new HashMap<String,Integer>();
	try{
	    Integer mem = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM member Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer dem = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM demand Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer sup = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM supply Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer cat = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM category Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer set = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM settlement Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer shi = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM shipping Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer cur = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM currency Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer bra = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM brand Where instime > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    Integer tra = getJdbcService().getJdbcTemplate().queryForInt("SELECT count(*) FROM transactionlog Where dtts > (NOW() - INTERVAL 7 DAY) AND isdeleted =false");
	    
	    reccount.put("member", mem);
	    reccount.put("demand", dem);
	    reccount.put("supply", sup);
	    reccount.put("category", cat);
	    reccount.put("settlement", set);
	    reccount.put("shipping", shi);
	    reccount.put("currency", cur);
	    reccount.put("brand", bra);
	    reccount.put("trans", tra);
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return reccount;
    }
    
    @Override
    public List<HDemandPhotos> getDemandPhotosList(String did) {
	List<HDemandPhotos> ctg = new ArrayList<HDemandPhotos>();
	try {
	    ctg = getJdbcService().getJdbcTemplate().query(
		"SELECT * FROM demand_photos,photouploads WHERE demand_photos.link=photouploads.id AND demand_photos.did='"+did+"'",
		  new DemandPhotosMapper());
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
    }
   @Override
    public boolean deleteDemandPhotosList(String imgid) {
	boolean fo = false;
	
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL deletedemandphoto("+imgid+")");
	    
	    logger.info("deleteDemandPhotosList Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
    }
   
   @Override
   public List<HSupplyPhotos> getSupplyPhotosList(String sid) {
	List<HSupplyPhotos> ctg = new ArrayList<HSupplyPhotos>();
	try {
	    ctg = getJdbcService().getJdbcTemplate().query(
		"SELECT * FROM supply_photos,photouploads WHERE supply_photos.link=photouploads.id AND supply_photos.sid='"+sid+"'",
		  new SupplyPhotosMapper());
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return ctg;
   }
  @Override
   public boolean deleteSupplyPhotosList(String imgid) {
	boolean fo = false;
	
	try {
	    StringBuffer strSql = new StringBuffer(
		    "CALL deletesupplyphoto("+imgid+")");
	    
	    logger.info("deleteSupplyPhotosList Query - > " + strSql.toString());
	    
	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

	    fo = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return fo;
   }
    /* Abdullah Al Monsur End*/
   /* Ole Ul Islam Start*/
      
    @Override
    public List<HBrand> getAllBrand() {
    	List<HBrand> brandList = new ArrayList<HBrand>();
    	
    	try {
    		
    	    StringBuffer strSql = new StringBuffer("SELECT * FROM brand WHERE isdeleted = 0");
    	    
    	    logger.info("projectCode() Query - > " + strSql.toString());
    	    brandList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {},
    		    new BrandMapper());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return brandList;
    }
    
    
    @Override
    public List<HCurrency> getAllCurrency() {
    	List<HCurrency> currencyList = new ArrayList<HCurrency>();
    	
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM currency WHERE isdeleted = 0");
			
			currencyList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new CurrencyMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return currencyList;
    }
    
    @Override
    public String insertDemand(HDemand obj) {
    	String did = "";
    	TransactionStatus status = getJdbcService().getTransactionStatus();
	      
	getJdbcService().beginTran();
    	try {
    	    StringBuffer strSql = new StringBuffer(
    			    "CALL inserdemand('"+obj.getBrdc()+"','"+obj.getCtgc()+"','"+obj.getPdtp()+"','"+obj.getPdnm()+"','"+obj.getDam()+"','"+obj.getUnt()+"','"+obj.getUtp()+"','"+obj.getCur()+"','"+obj.getPddc()+"','"+obj.getSadr()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("registerMember(HMember obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());
    	    
    	    StringBuffer strQry = new StringBuffer("SELECT did FROM demand WHERE id = (SELECT MAX(id) FROM demand)");
    	    
    	    HDemand dem = getJdbcService().getJdbcTemplate().queryForObject(strQry.toString(),new DemandMapper());
    	
    	    getJdbcService().commitTran(status);
    	    if(dem!=null && dem.getDid()!=null){
    		did= dem.getDid();
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    getJdbcService().rollbackTran(status);
    	}

    	return did;
    }
    
    @Override
    public String insertSupply(HSupply obj) {
	String sid = "";
    	TransactionStatus status = getJdbcService().getTransactionStatus();
	      
	getJdbcService().beginTran();
    	
    	try {
    		StringBuffer strSql = new StringBuffer(
    			    "CALL insertsupply('"+obj.getBrdc()+"','"+obj.getCtgc()+"','"+obj.getPdtp()+"','"+obj.getPdnm()+"','"+obj.getDam()+"','"+obj.getUnt()+"','"+obj.getUtp()+"','"+obj.getCurc()+"','"+obj.getPddc()+"','"+obj.getSadr()+"','"+obj.getSmtc()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("registerSupply(HSupply obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    StringBuffer strQry = new StringBuffer("SELECT sid FROM supply WHERE id = (SELECT MAX(id) FROM supply)");
	    
    	    HSupply sem = getJdbcService().getJdbcTemplate().queryForObject(strQry.toString(),new SupplyMapper());
	
	    getJdbcService().commitTran(status);
	    if(sem!=null && sem.getSid()!=null){
		sid= sem.getSid();
	    }
    		
	} catch (Exception e) {
	    e.printStackTrace();
	}
    	
    	return sid;
    }
    
    @Override
    public boolean inserDemandPhotos(HDemandPhotos obj) {
    	boolean fo = false;
    	try {
		StringBuffer strSql = new StringBuffer("CALL insertDemandPhotos('"+obj.getDid()+"',"+obj.getLink().getLength()+",'"+obj.getLink().getName()+"','"+obj.getLink().getSaveName()+"','"+obj.getLink().getType()+"','"+obj.getLink().getPath()+"')");
			
		getJdbcService().getJdbcTemplate().execute(strSql.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
    	return fo;
    }
    
    @Override
    public boolean inserSupplyPhotos(HSupplyPhotos obj) {
    	boolean fo = false;
    	try {
		StringBuffer strSql = new StringBuffer("CALL insertSupplyPhotos('"+obj.getSid()+"',"+obj.getLink().getLength()+",'"+obj.getLink().getName()+"','"+obj.getLink().getSaveName()+"','"+obj.getLink().getType()+"','"+obj.getLink().getPath()+"')");
			
		getJdbcService().getJdbcTemplate().execute(strSql.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
    	return fo;
    }
    
    @Override
    public List<HDemand> getAllDemand() {
    	List<HDemand> demandList = new ArrayList<HDemand>();
    	
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM demand WHERE isdeleted = 0");
			
			demandList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new DemandMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return demandList;
    }
    
    @Override
    public List<HDemand> getEditDemand(String did) {
    	List<HDemand> demandList = new ArrayList<HDemand>();
    	
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM demand WHERE did ='" + did + "' AND isdeleted=false");
			
			demandList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new DemandMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return demandList;
    }
    
    @Override
    public boolean updteDemand(HDemand obj, int opt) {
    	boolean fo = false;
    	
    	try {
    	    StringBuffer strSql = new StringBuffer(
    		    "CALL editdemand("+opt+",'"+obj.getDid()+"','"+obj.getBrdc()+"','"+obj.getCtgc()+"','"+obj.getPdtp()+"','"+obj.getPdnm()+"','"+obj.getDam()+"','"+obj.getUnt()+"','"+obj.getUtp()+"','"+obj.getCur()+"','"+obj.getPddc()+"','"+obj.getSadr()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("Update Demand(HDemand obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    fo = true;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	
    	return fo;
    }
    
    @Override
    public List<HSupply> getSupplyList(String sid) {
    	List<HSupply> supplylist = new ArrayList<HSupply>();
    	
    	try {
			if(sid.equals("")) {
				supplylist = getJdbcService().getJdbcTemplate().query("SELECT * FROM supply WHERE isdeleted=false", new SupplyMapper());
			} else {
				supplylist = getJdbcService().getJdbcTemplate().query("SELECT * FROM supply WHERE brdc ='" + sid + "' AND isdeleted=false", new SupplyMapper());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return supplylist;
    }
    
    public List<HSupply> getEditSupply(String sid) {
    	List<HSupply> supply = new ArrayList<HSupply>();
    	
    	try {
    		StringBuffer strSql = new StringBuffer("SELECT * FROM supply WHERE sid ='" + sid + "' AND isdeleted=false");
			
    		supply = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new SupplyMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return supply;
    }
    
    public boolean updateSupply(HSupply obj, int opt) {
    	boolean fo = false;
    	
    	try {
    	    StringBuffer strSql = new StringBuffer(
    		    "CALL supply("+opt+",'"+obj.getSid()+"','"+obj.getBrdc()+"','"+obj.getCtgc()+"','"+obj.getPdtp()+"','"+obj.getPdnm()+"','"+obj.getDam()+"','"+obj.getUnt()+"','"+obj.getUtp()+"','"+obj.getCurc()+"','"+obj.getPddc()+"','"+obj.getSadr()+"','"+obj.getSmtc()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("Update Supply(HSupply obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    fo = true;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	
    	return fo;
    }
    
    @Override
    public List<HSettlement> getSettlementList(String id) {
    	List<HSettlement> settlementList = new ArrayList<HSettlement>();
    	
    	try {
			if(id.equals("")) {
				settlementList = getJdbcService().getJdbcTemplate().query("SELECT * FROM settlement WHERE isdeleted=false", new SettlementMapper());
			} else {
				settlementList = getJdbcService().getJdbcTemplate().query("SELECT * FROM settlement WHERE stlc ='" + id + "' AND isdeleted=false", new SettlementMapper());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return settlementList;
    }
    
    public boolean insertSettlement(HSettlement obj) {
    	boolean fo = false;
    	
    	try {
    		StringBuffer strSql = new StringBuffer("CALL insertsettlement('"+obj.getStln()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("registerSettlement(HSettlement obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    fo = true;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return fo;
    }
    
    @Override
    public List<HSettlement> getEditSettlement(String sid) {
    	List<HSettlement> settlement = new ArrayList<HSettlement>();
    	
    	try {
    		StringBuffer strSql = new StringBuffer("SELECT * FROM settlement WHERE stlc ='" + sid + "' AND isdeleted=false");
			
    		settlement = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new SettlementMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return settlement;
    }
    
    @Override
    public boolean updateSettlement(HSettlement obj, int opt) {
    	boolean fo = false;
    	
    	try {
    	    StringBuffer strSql = new StringBuffer(
    		    "CALL settlement("+opt+",'"+obj.getStlc()+"','"+obj.getStln()+"','"+obj.getModifiedby()+"')");
    	    
    	    logger.info("Update Settlement(HSettlement obj) Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    fo = true;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}   	
    	return fo;
    }
    
    @Override
    public boolean editAssociation(String did, String sid){
    	boolean fo = false;
    	
    	try {
    	    StringBuffer strSql = new StringBuffer(
    		    "CALL editassociation('"+did+"','"+sid+"')");
    	    
    	    logger.info("Update Association Query - > " + strSql.toString());
    	    
    	    getJdbcService().getJdbcTemplate().execute(strSql.toString());

    	    fo = true;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}   	
    	return fo;
    }
    
    @Override
    public List<HDemand> getAllDemandAssociation() {
    	List<HDemand> demandList = new ArrayList<HDemand>();
    	
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM demand WHERE isdeleted = 0");
			
			demandList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new DemandMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return demandList;
    }
    
    @Override
    public List<HSupply> getSupplyAssociation() {
    	List<HSupply> supply = new ArrayList<HSupply>();
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM supply WHERE isdeleted = 0");
			
			supply = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new SupplyMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return supply;
    }
    
    @Override
    public List<HDemand> getEditAssociationDemand() {
    	List<HDemand> demandList = new ArrayList<HDemand>();
    	
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM demand WHERE isdeleted = 0 AND sid != ''");
			
			demandList = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new DemandMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return demandList;
    }
    
    @Override
    public List<HSupply> getEditAssociationSupply() {
    	List<HSupply> supply = new ArrayList<HSupply>();
    	try {
			StringBuffer strSql = new StringBuffer("SELECT * FROM supply WHERE isdeleted = 0 AND did != ''");
			
			supply = getJdbcService().getJdbcTemplate().query(strSql.toString(), new Object[] {}, new SupplyMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return supply;
    }
   
    /* Ole Ul Islam's code End*/
}
