package com.ey.donna.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.ey.donna.model.HBrand;
import com.ey.donna.model.HCategory;
import com.ey.donna.model.HMember;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class CategoryController extends BaseController implements ApplicationContextAware {
    
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    
    private ApplicationContext applicationContext;
    
    private IDonnaService donnaService;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }

    public void setDonnaService(IDonnaService donnaService) {
        this.donnaService = donnaService;
    }
    
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView brand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HCategory> ctg = new ArrayList<HCategory>();
	//if(curuser.getRole().equalsIgnoreCase("Admin")){
	    ctg = donnaService.getCategoryList("");
	//} 
		
	mm.addAttribute("selUrl","category");
	mm.addAttribute("ctg",ctg);
	return new ModelAndView("category", mm);
    }
    
    @RequestMapping(value = "/addnewcategory", method = RequestMethod.GET)
    public ModelAndView addnewcategory(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	mm.addAttribute("selUrl","category");
	
	return new ModelAndView("addnewcategory", mm);
    }
    
    @RequestMapping(value = "/categoryedit/{id}", method = RequestMethod.GET)
    public ModelAndView categoryedit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	HCategory category = donnaService.getCategoryList(id).get(0);
	
	mm.addAttribute("selUrl","brand");
	mm.addAttribute("ctg", category);
	
	return new ModelAndView("categoryedit", mm);
    }
    
    @RequestMapping(value = "/categorydelete/{id}", method = RequestMethod.GET)
    public ModelAndView categorydelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	HCategory ctg = new HCategory();
	
	ctg.setCtgc(id);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateCategoryDetails(ctg,2);
	
	mm.addAttribute("selUrl","category");
	//mm.addAttribute("mem", mem);
	return new ModelAndView("redirect:/category");
    }
 // ==================================================POST============================================================
    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public ModelAndView addcategory(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String category_name = parameterMap.get("ctgna")[0];
	String category_name_jp = parameterMap.get("ctgnj")[0];
	

	ModelMap mm = new ModelMap();
	
	HCategory category = new HCategory();
	category.setCtgna(category_name);
	category.setCtgnj(category_name_jp);
	category.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.registerCategory(category);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/editcategory", method = RequestMethod.POST)
    public ModelAndView editcategory(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String category_code = parameterMap.get("ctgc")[0];
	String category_name = parameterMap.get("ctgna")[0];
	String category_name_jp = parameterMap.get("ctgnj")[0];
	

	ModelMap mm = new ModelMap();
	
	HCategory ctg = new HCategory();
	ctg.setCtgc(category_code);
	ctg.setCtgna(category_name);
	ctg.setCtgnj(category_name_jp);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateCategoryDetails(ctg,1);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
}
