package com.ey.donna.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ey.donna.model.HBrand;
import com.ey.donna.model.HMember;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class BrandController extends BaseController implements ApplicationContextAware {
    
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
    
    private ApplicationContext applicationContext;
    
    private IDonnaService donnaService;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }
    
    public void setDonnaService(IDonnaService donnaService) {
        this.donnaService = donnaService;
    }
    
    @RequestMapping(value = "/brand", method = RequestMethod.GET)
    public ModelAndView brand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HBrand> brd = new ArrayList<HBrand>();
	//if(curuser.getRole().equalsIgnoreCase("Admin")){
	    brd = donnaService.getBrandList("");
	//} 
		
	mm.addAttribute("selUrl","brand");
	mm.addAttribute("brd",brd);
	return new ModelAndView("brand", mm);
    }
    
    @RequestMapping(value = "/addnewbrand", method = RequestMethod.GET)
    public ModelAndView addnewbrand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	mm.addAttribute("selUrl","brand");
	
	return new ModelAndView("addnewbrand", mm);
    }
    
    @RequestMapping(value = "/brandedit/{id}", method = RequestMethod.GET)
    public ModelAndView brandedit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	HBrand brand = donnaService.getBrandList(id).get(0);
	
	mm.addAttribute("selUrl","brand");
	mm.addAttribute("brd", brand);
	
	return new ModelAndView("brandedit", mm);
    }
    
    @RequestMapping(value = "/branddelete/{id}", method = RequestMethod.GET)
    public ModelAndView branddelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	HBrand brd = new HBrand();
	brd.setBrdc(id);
	brd.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateBrandDetails(brd,2);
	
	mm.addAttribute("selUrl","brand");
	//mm.addAttribute("mem", mem);
	return new ModelAndView("redirect:/brand");
    }
 // ==================================================POST============================================================
 
    @RequestMapping(value = "/addbrand", method = RequestMethod.POST)
    public ModelAndView addmember(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String brand_name = parameterMap.get("bn")[0];
	String brand_name_jp = parameterMap.get("bnj")[0];
	

	ModelMap mm = new ModelMap();
	
	HBrand brand = new HBrand();
	brand.setBrdna(brand_name);
	brand.setBrdnj(brand_name_jp);
	brand.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.registerBrand(brand);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/editbrand", method = RequestMethod.POST)
    public ModelAndView editmemberdetails(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String brand_code = parameterMap.get("bid")[0];
	String brand_name = parameterMap.get("bn")[0];
	String brand_name_jp = parameterMap.get("bnj")[0];
	

	ModelMap mm = new ModelMap();
	
	HBrand brand = new HBrand();
	brand.setBrdc(brand_code);
	brand.setBrdna(brand_name);
	brand.setBrdnj(brand_name_jp);
	brand.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateBrandDetails(brand,1);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
}
