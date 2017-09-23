package com.ey.donna.services.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ey.donna.dao.interfaces.IDonnaDAO;
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
import com.ey.donna.services.interfaces.IDonnaService;


public class DonnaService implements IDonnaService {
    private IDonnaDAO donnaDao;
        
    public void setDonnaDao(IDonnaDAO donnaDao) {
        this.donnaDao = donnaDao;
    }

    // ==================================================================Local_Function=================================================================
    public String Right(String str, int pos){
	String val = str;
	int len = val.length();
	int right_pos = len-(pos);
		 
	String right = val.substring(right_pos, len);
		 
	return right;
    }
    
    public String LeftB(String st, int len) {
	String res = "";
	for (int i = 1; i < st.length(); i++) {
		if (res.getBytes().length > len)
			break;
		res = st.substring(0, i + 1);
	}
	return res;
    }
    
    public String Ignore(String str,String ch) {
	String res="";
	for(int i=0;i<str.length();i++) {
	    String partstring = str.substring(i, i+1);
	    if(!partstring.equals(ch)){
		res = res+partstring;
	    }
	}
	return res;
    }

    // ==================================================================Local_Function_End=============================================================
    /* Abdullah Al Monsur Start*/
    @Override
    public List<HMember> getMemberList(String pid){
	return donnaDao.getMemberList(pid);
    }
    
    @Override
    public HMember getMemberVerifyState(String userName){
	return donnaDao.getMemberVerifyState(userName);
    }
    
    @Override
    public HMember getUserValidation(HMember user) {
	return donnaDao.getEmployeeByPassword(false, user.getPid(), user.getPass());
    }
    
    @Override
    public boolean registerMember(HMember obj) {
	return donnaDao.registerMember(obj);
    }
    
    @Override
    public boolean updateMemberDetails(HMember obj,int opt) {
	return donnaDao.updateMemberDetails(obj,opt);
    }
    
    @Override
    public boolean verifyedMember(String pmid, int prevstat) {
	return donnaDao.verifyedMember(pmid,prevstat);
    }
    
    @Override
    public HMember getMemberByEmail(String email) {
	return donnaDao.getMemberByEmail(email);
    }
    
    @Override
    public boolean registerBrand(HBrand obj){
	return donnaDao.registerBrand(obj);
    }
    
    @Override
    public List<HBrand> getBrandList(String bid){
	return donnaDao.getBrandList(bid);
    }
    
    @Override
    public boolean updateBrandDetails(HBrand obj,int opt){
	return donnaDao.updateBrandDetails(obj, opt);
    }
    
    @Override
    public List<HCategory> getCategoryList(String cid){
	return donnaDao.getCategoryList(cid);
    }
    
    @Override
    public boolean registerCategory(HCategory obj){
	return donnaDao.registerCategory(obj);
    }
    
    @Override
    public boolean updateCategoryDetails(HCategory obj,int opt){
	return donnaDao.updateCategoryDetails(obj, opt);
    }
    
    @Override
    public boolean registerCurrency(HCurrency obj){
	return donnaDao.registerCurrency(obj);
    }
    
    @Override
    public List<HCurrency> getCurrencyList(String cid){
	return donnaDao.getCurrencyList(cid);
    }
    
    @Override
    public boolean updateCurrencyDetails(HCurrency obj,int opt){
	return donnaDao.updateCurrencyDetails(obj, opt);
    }
    
    @Override
    public boolean registerShipping(HShipping obj) {
	return donnaDao.registerShipping(obj);
    }
    
    @Override
    public List<HShipping> getShippingList(String cid) {
	return donnaDao.getShippingList(cid);
    }
    
    @Override
    public boolean updateShippingDetails(HShipping obj,int opt){
	return donnaDao.updateShippingDetails(obj, opt);
    }
    
    @Override
    public List<HTransactionLog> getTransactionLog(String cid) {
	return donnaDao.getTransactionLog(cid);
    }
    
    @Override
    public Map<String,Integer> getLastWeekUpdate() {
	return donnaDao.getLastWeekUpdate();
    }
    
    @Override
    public List<HDemandPhotos> getDemandPhotosList(String did) {
	return donnaDao.getDemandPhotosList(did);
    }
    
    @Override
    public boolean deleteDemandPhotosList(String imgid) {
	return donnaDao.deleteDemandPhotosList(imgid);
    }
    
    @Override
    public boolean inserSupplyPhotos(HSupplyPhotos obj){
	return donnaDao.inserSupplyPhotos(obj);
    }
    
    @Override
    public List<HSupplyPhotos> getSupplyPhotosList(String sid){
	return donnaDao.getSupplyPhotosList(sid);
    }
    
    @Override
    public boolean deleteSupplyPhotosList(String imgid){
	return donnaDao.deleteSupplyPhotosList(imgid);
    }
    
    /* Abdullah Al Monsur End*/
    /* Ole Ul Islam Start*/
      
    @Override
    public List<HBrand> getAllBrand() {
    	return donnaDao.getAllBrand();
    }

    @Override
    public List<HCurrency> getAllCurrency() {
    	return donnaDao.getAllCurrency();
    }
    
    @Override
    public String insertDemand(HDemand obj) {
    	return donnaDao.insertDemand(obj);
    }
    
    @Override
    public List<HDemand> getAllDemand() {
    	return donnaDao.getAllDemand();
    }
    @Override
    public List<HDemand> getEditDemand(String did) {
    	return donnaDao.getEditDemand(did);
    }
    
    @Override
    public boolean updteDemand(HDemand obj, int opt) {
    	return donnaDao.updteDemand(obj, opt);
    }
    
    @Override
    public List<HSupply> getSupplyList(String sid) {
    	return donnaDao.getSupplyList(sid);
    }
    
    @Override
    public String insertSupply(HSupply obj) {
    	return donnaDao.insertSupply(obj);
    }
    
    @Override
    public List<HSupply> getEditSupply(String sid) {
    	return donnaDao.getEditSupply(sid);
    }
    
    @Override
    public boolean updateSupply(HSupply obj, int opt) {
    	return donnaDao.updateSupply(obj, opt);
    }
    
    @Override
    public List<HSettlement> getSettlementList(String id) {
    	return donnaDao.getSettlementList(id);
    }
    
    @Override
    public boolean insertSettlement(HSettlement obj) {
    	return donnaDao.insertSettlement(obj);
    }
    
    @Override
    public List<HSettlement> getEditSettlement(String sid) {
    	return donnaDao.getEditSettlement(sid);
    }
    
    @Override
    public boolean updateSettlement(HSettlement obj, int opt){
    	return donnaDao.updateSettlement(obj,opt);
    }
    
    @Override
    public boolean editAssociation(String did, String sid) {
    	return donnaDao.editAssociation(did, sid);
    }
    
    @Override
    public List<HDemand> getAllDemandAssociation() {
    	return donnaDao.getAllDemandAssociation();
    }
    
    @Override
    public List<HSupply> getSupplyAssociation() {
    	return donnaDao.getSupplyAssociation();
    }
    
    @Override
    public List<HDemand> getEditAssociationDemand(){
    	return donnaDao.getEditAssociationDemand();
    }
    
    @Override
    public List<HSupply> getEditAssociationSupply() {
    	return donnaDao.getEditAssociationSupply();
    }
    
    
    @Override
    public boolean inserDemandPhotos(HDemandPhotos obj){
	return donnaDao.inserDemandPhotos(obj);
    }
    
    /* Ole Ul Islam End*/

    
}
