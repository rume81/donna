package com.ey.donna.services.interfaces;

import java.util.List;
import java.util.Map;

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

public interface IDonnaService {
    /* Abdullah Al Monsur Start*/
    public List<HMember> getMemberList(String pid);
    
    public HMember getUserValidation(HMember user);
    
    public HMember getMemberVerifyState(String userName);
    
    public boolean registerMember(HMember obj);
    
    public boolean updateMemberDetails(HMember obj,int opt);
    
    public boolean verifyedMember(String pmid, int prevstat);
    
    public HMember getMemberByEmail(String email);
    
    public boolean registerBrand(HBrand obj);
    
    public List<HBrand> getBrandList(String bid);
    
    public boolean updateBrandDetails(HBrand obj,int opt);
    
    public List<HCategory> getCategoryList(String cid);
    
    public boolean registerCategory(HCategory obj);
    
    public boolean updateCategoryDetails(HCategory obj,int opt);
    
    public boolean registerCurrency(HCurrency obj);
    
    public List<HCurrency> getCurrencyList(String cid);
    
    public boolean updateCurrencyDetails(HCurrency obj,int opt);
    
    public boolean registerShipping(HShipping obj);
    
    public List<HShipping> getShippingList(String cid);
    
    public boolean updateShippingDetails(HShipping obj,int opt);
    
    public List<HTransactionLog> getTransactionLog(String cid);
    
    public Map<String,Integer> getLastWeekUpdate();
    
    public boolean deleteDemandPhotosList(String imgid);
    
    public boolean inserSupplyPhotos(HSupplyPhotos obj);
    
    public List<HSupplyPhotos> getSupplyPhotosList(String sid);
    
    public boolean deleteSupplyPhotosList(String imgid);
    
    /* Abdullah Al Monsur End*/
    /* Ole Ul Islam Start*/
    
    public List<HBrand> getAllBrand();
            
    public List<HCurrency> getAllCurrency();
    
    public String insertDemand(HDemand obj);
    
    public List<HDemand> getAllDemand();
    
    public List<HDemand> getEditDemand(String did);
    
    public boolean updteDemand(HDemand obj, int opt);
    
    public List<HSupply> getSupplyList(String sid);
    
    public String insertSupply(HSupply obj);
    
    public List<HSupply> getEditSupply(String sid);
    
    public boolean updateSupply(HSupply obj, int opt);
    
    public List<HSettlement> getSettlementList(String id);
    
    public boolean insertSettlement(HSettlement obj);
    
    public List<HSettlement> getEditSettlement(String sid);
    
    public boolean updateSettlement(HSettlement obj, int opt);
    
    public boolean editAssociation(String did, String sid);
    
    public List<HDemand> getAllDemandAssociation();
    
    public List<HSupply> getSupplyAssociation();
    
    public List<HDemand> getEditAssociationDemand();
    
    public List<HSupply> getEditAssociationSupply();
    
    public boolean inserDemandPhotos(HDemandPhotos obj);
    
    public List<HDemandPhotos> getDemandPhotosList(String did);
    
    /* Ole Ul Islam End*/
}
