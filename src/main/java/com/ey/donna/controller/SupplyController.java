package com.ey.donna.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.ey.donna.model.HShipping;
import com.ey.donna.model.HSupply;
import com.ey.donna.model.HSupplyPhotos;
import com.ey.donna.model.HUpload;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class SupplyController extends BaseController implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SupplyController.class);

    private ApplicationContext applicationContext;

    private IDonnaService donnaService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }

    public void setDonnaService(IDonnaService donnaService) {
	this.donnaService = donnaService;
    }

    @RequestMapping(value = "/supply", method = RequestMethod.GET)
    public ModelAndView supply(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HSupply> sup = new ArrayList<HSupply>();

	sup = donnaService.getSupplyList("");

	mm.addAttribute("selUrl", "supply");
	mm.addAttribute("sup", sup);
	return new ModelAndView("supply", mm);
    }

    @RequestMapping(value = "/add-supply", method = RequestMethod.GET)
    public ModelAndView getAddSupply(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	List<HBrand> brand = donnaService.getAllBrand();
	List<HCategory> categories = donnaService.getCategoryList("");
	List<HCurrency> currencies = donnaService.getAllCurrency();
	List<HShipping> shipping = donnaService.getShippingList("");

	mm.addAttribute("brand", brand);
	mm.addAttribute("categories", categories);
	mm.addAttribute("currencies", currencies);
	mm.addAttribute("shipping", shipping);
	mm.addAttribute("selUrl", "supply");

	return new ModelAndView("addsupply", mm);
    }

    @RequestMapping(value = "/edit-supply/{id}", method = RequestMethod.GET)
    public ModelAndView getEditsupply(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
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
	HSupply supply = donnaService.getEditSupply(id).get(0);
	List<HShipping> shipping = donnaService.getShippingList("");
	
	List<HSupplyPhotos> supply_photo = new ArrayList<HSupplyPhotos>();
	supply_photo = donnaService.getSupplyPhotosList(supply.getSid());
	
	int supply_photo_size = supply_photo.size();

	mm.addAttribute("selUrl", "supply");

	mm.addAttribute("brand", brand);
	mm.addAttribute("categories", categories);
	mm.addAttribute("currencies", currencies);
	mm.addAttribute("supply", supply);
	mm.addAttribute("shipping", shipping);
	mm.addAttribute("sph", supply_photo);
	mm.addAttribute("sphsize", supply_photo_size);

	return new ModelAndView("editsupply", mm);
    }

    @RequestMapping(value = "/deletesupply/{id}", method = RequestMethod.GET)
    public ModelAndView getDeleteSupply(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}

	HSupply supply = new HSupply();
	supply.setSid(id);
	supply.setModifiedby(getUser().getFname());

	boolean res = donnaService.updateSupply(supply, 2);
	
	if(res){
	    List<HSupplyPhotos> supply_photo = new ArrayList<HSupplyPhotos>();
	    supply_photo = donnaService.getSupplyPhotosList(supply.getSid());
	    for(HSupplyPhotos old_img:supply_photo){
		donnaService.deleteSupplyPhotosList(String.valueOf(old_img.getLink().getId()));
	    }
	}

	return new ModelAndView("redirect:/supply");
    }

    /*** POST Method Start **/
    @RequestMapping(value = "/insertSupply", method = RequestMethod.POST)
    public ModelAndView postAddsupply(MultipartHttpServletRequest request, HttpServletRequest response)
	    throws Exception {

	HSupplyPhotos supplyPhotos = new HSupplyPhotos();
	Map<String, String[]> parameterMap = request.getParameterMap();
	Map<String, MultipartFile> fileMap = request.getFileMap();

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
	String smtc = parameterMap.get("smtc")[0];
	String image_count = parameterMap.get("sph_count")[0];

	ModelMap mm = new ModelMap();

	HSupply supply = new HSupply();

	supply.setBrdc(brand);
	supply.setCtgc(category);
	supply.setPdtp(product_type);
	supply.setPdnm(product_name);
	supply.setDam(Double.parseDouble(product_amount));
	supply.setUnt(unit_count);
	supply.setUtp(Double.parseDouble(price_per_unit));
	supply.setCurc(currency_types);
	supply.setPddc(product_description);
	supply.setSadr(shipping_address);
	supply.setSmtc(smtc);
	supply.setModifiedby(getUser().getFname());

	String res = donnaService.insertSupply(supply);

	if (!res.equals("")) {
	    int im_count = 0;
	    if (null != image_count) {
		im_count = Integer.parseInt(image_count);
	    }
	    for (int i = 1; i <= im_count; i++) {
		MultipartFile photos = fileMap.get("supply_photos" + i);
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

			supplyPhotos.setLink(ufile);
			supplyPhotos.setSid(res);

			donnaService.inserSupplyPhotos(supplyPhotos);

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

    @RequestMapping(value = "/editsupply", method = RequestMethod.POST)
    public ModelAndView postEditSupply(MultipartHttpServletRequest request, HttpServletRequest response) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	Map<String, MultipartFile> fileMap = request.getFileMap();

	String sid = parameterMap.get("psid")[0];
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
	String smtc = parameterMap.get("smtc")[0];
	String image_count = parameterMap.get("sph_count")[0];

	ModelMap mm = new ModelMap();

	HSupply supply = new HSupply();

	supply.setSid(sid);
	supply.setBrdc(brand);
	supply.setCtgc(category);
	supply.setPdtp(product_type);
	supply.setPdnm(product_name);
	supply.setDam(Double.parseDouble(product_amount));
	supply.setUnt(unit_count);
	supply.setUtp(Double.parseDouble(price_per_unit));
	supply.setCurc(currency_types);
	supply.setPddc(product_description);
	supply.setSadr(shipping_address);
	supply.setSmtc(smtc);
	supply.setModifiedby(getUser().getFname());

	boolean res = donnaService.updateSupply(supply, 1);
	
	HSupplyPhotos supplyPhotos = new HSupplyPhotos();
	if (res) {
	    String old_image = parameterMap.get("delete_supply_photos")[0];
	    
	    if(!old_image.equals("")){
		String[] old_img = old_image.split(",");
		int si = old_img.length;
		for(int i=0;i<si;i++){
		    donnaService.deleteSupplyPhotosList(old_img[i]);
		}
	    }
	    int im_count = 0;
	    if (null != image_count) {
		im_count = Integer.parseInt(image_count);
	    }
	    for (int i = 1; i <= im_count; i++) {
		MultipartFile photos = fileMap.get("supply_photos" + i);
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
			
			supplyPhotos.setLink(ufile);
			supplyPhotos.setSid(sid);
			
			donnaService.inserSupplyPhotos(supplyPhotos);
			    
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} 
	    }	
	}
	
	if (res) {
	    mm.addAttribute("msg", "OK");

	} else
	    mm.addAttribute("msg", "ERROR");

	return new ModelAndView("result", mm);
    }
}
