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

import com.ey.donna.model.HCategory;
import com.ey.donna.model.HCurrency;
import com.ey.donna.model.HMember;
import com.ey.donna.model.HShipping;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class ShippingController extends BaseController implements ApplicationContextAware {
    
    private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);
    
    private ApplicationContext applicationContext;
    
    private IDonnaService donnaService;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }

    public void setDonnaService(IDonnaService donnaService) {
        this.donnaService = donnaService;
    }
    
    @RequestMapping(value = "/shipping", method = RequestMethod.GET)
    public ModelAndView brand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HShipping> ctg = new ArrayList<HShipping>();
	//if(curuser.getRole().equalsIgnoreCase("Admin")){
	    ctg = donnaService.getShippingList("");
	//} 
		
	mm.addAttribute("selUrl","shipping");
	mm.addAttribute("ctg",ctg);
	return new ModelAndView("shipping", mm);
    }
    
    @RequestMapping(value = "/addnewshipping", method = RequestMethod.GET)
    public ModelAndView addnewcurrency(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	mm.addAttribute("selUrl","shipping");
	
	return new ModelAndView("addnewshipping", mm);
    }
    
    @RequestMapping(value = "/shippingedit/{id}", method = RequestMethod.GET)
    public ModelAndView currencyedit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	HShipping shipping = donnaService.getShippingList(id).get(0);
	
	mm.addAttribute("selUrl","shipping");
	mm.addAttribute("ctg", shipping);
	
	return new ModelAndView("shippingedit", mm);
    }
    
    @RequestMapping(value = "/shippingdelete/{id}", method = RequestMethod.GET)
    public ModelAndView shippingdelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	HShipping ctg = new HShipping();
	
	ctg.setSmtc(id);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateShippingDetails(ctg,2);
	
	mm.addAttribute("selUrl","shipping");
	return new ModelAndView("redirect:/shipping");
    }
    
 // ==================================================POST============================================================
    @RequestMapping(value = "/addshipping", method = RequestMethod.POST)
    public ModelAndView addshipping(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String shipping_name = parameterMap.get("smtn")[0];	

	ModelMap mm = new ModelMap();
	
	HShipping shipping = new HShipping();
	shipping.setSmtn(shipping_name);
	shipping.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.registerShipping(shipping);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/editshipping", method = RequestMethod.POST)
    public ModelAndView editshipping(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String shipping_code = parameterMap.get("smtc")[0];
	String shipping_name = parameterMap.get("smtn")[0];
	
	ModelMap mm = new ModelMap();
	
	HShipping ctg = new HShipping();
	ctg.setSmtc(shipping_code);
	ctg.setSmtn(shipping_name);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateShippingDetails(ctg,1);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
}
