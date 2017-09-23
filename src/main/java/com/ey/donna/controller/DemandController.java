package com.ey.donna.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ey.donna.model.HBrand;
import com.ey.donna.model.HCategory;
import com.ey.donna.model.HCurrency;
import com.ey.donna.model.HDemand;
import com.ey.donna.model.HDemandPhotos;
import com.ey.donna.model.HMember;
import com.ey.donna.model.HSupply;
import com.ey.donna.model.HSupplyPhotos;
import com.ey.donna.model.HUpload;
import com.ey.donna.model.UserSession;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class DemandController extends BaseController implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(DemandController.class);

    private ApplicationContext applicationContext;

    private IDonnaService donnaService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }

    public void setDonnaService(IDonnaService donnaService) {
	this.donnaService = donnaService;
    }

    public HMember getUser() {
	HMember user = getSessionService().getUserSession().getUser();
	return user;
    }

    @RequestMapping(value = "/demand", method = RequestMethod.GET)
    public ModelAndView demand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HDemand> demand = donnaService.getAllDemand();

	mm.addAttribute("selUrl", "demand");
	mm.addAttribute("demand", demand);

	return new ModelAndView("demand", mm);
    }

    @RequestMapping(value = "/add-demand", method = RequestMethod.GET)
    public ModelAndView adddemand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HBrand> brand = donnaService.getAllBrand();
	List<HCategory> categories = donnaService.getCategoryList("");
	List<HCurrency> currencies = donnaService.getAllCurrency();

	mm.addAttribute("brand", brand);
	mm.addAttribute("categories", categories);
	mm.addAttribute("currencies", currencies);
	mm.addAttribute("selUrl", "demand");

	return new ModelAndView("adddemand", mm);
    }

    @RequestMapping(value = "/edit-demand/{id}", method = RequestMethod.GET)
    public ModelAndView editdemand(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HBrand> brand = donnaService.getAllBrand();
	List<HCategory> categories = donnaService.getCategoryList("");
	List<HCurrency> currencies = donnaService.getAllCurrency();
	HDemand demand = donnaService.getEditDemand(id).get(0);
	
	List<HDemandPhotos> demand_photo = new ArrayList<HDemandPhotos>();
	demand_photo = donnaService.getDemandPhotosList(demand.getDid());
	
	int demand_photo_size = demand_photo.size();

	mm.addAttribute("selUrl", "edit-demand/{id}");

	mm.addAttribute("brand", brand);
	mm.addAttribute("categories", categories);
	mm.addAttribute("currencies", currencies);
	mm.addAttribute("demand", demand);
	mm.addAttribute("dph", demand_photo);
	mm.addAttribute("dphsize", demand_photo_size);

	return new ModelAndView("editdemand", mm);
    }

    @RequestMapping(value = "/deleteDemand/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDemand(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	HDemand dem = new HDemand();
	dem.setDid(id);
	dem.setModifiedby(getUser().getFname());

	boolean res = donnaService.updteDemand(dem, 2);
	
	if(res){
	    List<HDemandPhotos> demand_photo = new ArrayList<HDemandPhotos>();
	    demand_photo = donnaService.getDemandPhotosList(dem.getDid());
	    for(HDemandPhotos old_img:demand_photo){
		donnaService.deleteDemandPhotosList(String.valueOf(old_img.getLink().getId()));
	    }
	}

	return new ModelAndView("redirect:/demand");
    }

    @RequestMapping(value = "/association", method = RequestMethod.GET)
    public ModelAndView getAssociation(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HDemand> demand = donnaService.getAllDemandAssociation();

	// List<HSupply> sup = donnaService.getSupplyList("");
	List<HSupply> sup = donnaService.getSupplyAssociation();

	mm.addAttribute("selUrl", "association");
	mm.addAttribute("demand", demand);
	mm.addAttribute("sup", sup);

	return new ModelAndView("association", mm);
    }

    @RequestMapping(value = "/edit-association", method = RequestMethod.GET)
    public ModelAndView getEditAssociation(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HDemand> demand = donnaService.getEditAssociationDemand();

	List<HSupply> sup = donnaService.getEditAssociationSupply();

	mm.addAttribute("selUrl", "association");
	mm.addAttribute("demand", demand);
	mm.addAttribute("sup", sup);

	return new ModelAndView("editassociation", mm);
    }


    /*** POST Method */

    /*
     * @RequestMapping(value = "/demand_photos", method = RequestMethod.POST)
     * public ModelAndView demand_photos(MultipartHttpServletRequest request,
     * HttpServletResponse response) { UserSession session =
     * getSessionService().getUserSession();
     * 
     * 
     * return new M }
     */

    @RequestMapping(value = "/insertDemand", method = RequestMethod.POST)
    public ModelAndView addDemand(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

	HDemandPhotos demandPhotos = new HDemandPhotos();
	Map<String, String[]> parameterMap = request.getParameterMap();
	Map<String, MultipartFile> fileMap = request.getFileMap();

	// MultipartFile photos = fileMap.get("demand_photos");

	String brand = parameterMap.get("brand")[0];
	String category = parameterMap.get("category")[0];
	String product_type = parameterMap.get("product_type")[0];
	String product_name = parameterMap.get("product_name")[0];
	String product_amount = parameterMap.get("product_amount")[0];
	String unit_count = parameterMap.get("unit_count")[0];
	String price_per_unit = parameterMap.get("price_per_unit")[0];
	String currency_types = parameterMap.get("currency_types")[0];
	String product_description = parameterMap.get("product_description")[0];
	String shipping_address = parameterMap.get("shipping_address")[0];
	String image_count = parameterMap.get("dph_count")[0];
	
	ModelMap mm = new ModelMap();

	HDemand demand = new HDemand();

	demand.setBrdc(brand);
	demand.setCtgc(category);
	demand.setPdtp(product_type);
	demand.setPdnm(product_name);
	demand.setDam(Double.parseDouble(product_amount));
	demand.setUnt(unit_count);
	demand.setUtp(Double.parseDouble(price_per_unit));
	demand.setCur(currency_types);
	demand.setPddc(product_description);
	demand.setSadr(shipping_address);
	demand.setModifiedby(getUser().getFname());

	String res = donnaService.insertDemand(demand);

	if (!res.equals("")) {
	    int im_count = 0;
	    if (null != image_count) {
		im_count = Integer.parseInt(image_count);
	    }
	    for (int i = 1; i <= im_count; i++) {
		MultipartFile photos = fileMap.get("demand_photos" + i);
		if (null != photos) {
		    HUpload ufile = new HUpload();
		    try {
			ufile.setLength(photos.getBytes().length);
			ufile.setBytes(photos.getBytes());
			ufile.setType(photos.getContentType());
			ufile.setName(photos.getOriginalFilename());
			ufile.setSaveName(String.valueOf(System.currentTimeMillis()));

			String path = WriteFile(ufile);
			ufile.setPath(path);
			
			demandPhotos.setLink(ufile);
			demandPhotos.setDid(res);
			
			donnaService.inserDemandPhotos(demandPhotos);
			    
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		}
	    }	
	    mm.addAttribute("msg", "OK");

	} else
	    mm.addAttribute("msg", "ERROR");

	return new ModelAndView("result", mm);
    }

    @RequestMapping(value = "/editdemand", method = RequestMethod.POST)
    public ModelAndView editdemand(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	Map<String, MultipartFile> fileMap = request.getFileMap();

	String did = parameterMap.get("pdid")[0];
	String brand = parameterMap.get("brand")[0];
	String category = parameterMap.get("category")[0];
	String product_type = parameterMap.get("product_type")[0];
	String product_name = parameterMap.get("product_name")[0];
	String product_amount = parameterMap.get("product_amount")[0];
	String unit_count = parameterMap.get("unit_count")[0];
	String price_per_unit = parameterMap.get("price_per_unit")[0];
	String currency_types = parameterMap.get("currency_types")[0];
	String product_description = parameterMap.get("product_description")[0];
	String shipping_address = parameterMap.get("shipping_address")[0];
	String image_count = parameterMap.get("dph_count")[0];

	ModelMap mm = new ModelMap();

	HDemand demand = new HDemand();

	demand.setDid(did);
	demand.setBrdc(brand);
	demand.setCtgc(category);
	demand.setPdtp(product_type);
	demand.setPdnm(product_name);
	demand.setDam(Double.parseDouble(product_amount));
	demand.setUnt(unit_count);
	demand.setUtp(Double.parseDouble(price_per_unit));
	demand.setCur(currency_types);
	demand.setPddc(product_description);
	demand.setSadr(shipping_address);
	demand.setModifiedby(getUser().getFname());

	boolean res = donnaService.updteDemand(demand, 1);
	
		
	HDemandPhotos demandPhotos = new HDemandPhotos();
	if (res) {
	    String old_image = parameterMap.get("delete_demand_photos")[0];
	    
	    if(!old_image.equals("")){
		String[] old_img = old_image.split(",");
		int si = old_img.length;
		for(int i=0;i<si;i++){
		    donnaService.deleteDemandPhotosList(old_img[i]);
		}
	    }
	    int im_count = 0;
	    if (null != image_count) {
		im_count = Integer.parseInt(image_count);
	    }
	    for (int i = 1; i <= im_count; i++) {
		MultipartFile photos = fileMap.get("demand_photos" + i);
		if (null != photos) {
		    HUpload ufile = new HUpload();
		    try {
			ufile.setLength(photos.getBytes().length);
			ufile.setBytes(photos.getBytes());
			ufile.setType(photos.getContentType());
			ufile.setName(photos.getOriginalFilename());
			ufile.setSaveName(String.valueOf(System.currentTimeMillis()));

			String path = WriteFile(ufile);
			ufile.setPath(path);
			
			demandPhotos.setLink(ufile);
			demandPhotos.setDid(did);
			
			donnaService.inserDemandPhotos(demandPhotos);
			    
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} 
		    //DELETE FROM photouploads WHERE photouploads.id in(SELECT link FROM demand_photos WHERE demand_photos.did=pdid);
		    //DELETE FROM demand_photos WHERE demand_photos.did=pdid;
	    }	
	}

	if (res) {
	    mm.addAttribute("msg", "OK");

	} else
	    mm.addAttribute("msg", "ERROR");

	return new ModelAndView("result", mm);
    }

    @RequestMapping(value = "/editassociation", method = RequestMethod.POST)
    public ModelAndView postEditAssociation(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();

	String demandid = parameterMap.get("demandid")[0];
	String supplyid = parameterMap.get("supplyid")[0];

	ModelMap mm = new ModelMap();

	boolean res = donnaService.editAssociation(demandid, supplyid);

	if (res) {
	    mm.addAttribute("msg", "OK");

	} else
	    mm.addAttribute("msg", "ERROR");

	return new ModelAndView("result", mm);
    }

}
