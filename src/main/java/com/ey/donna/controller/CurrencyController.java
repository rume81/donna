/* ========================================
* AMS v. 1.0 class library
* ========================================
*
* http://www.ams.com
*
* (C) Copyright 2016-2020, by EY.
*
* --------------------
* CurrencyController.java
* --------------------
* Created on Jun 5, 2017
*
* Revision: 
* Author: Abdullah-Al-Monsur (ALA)
* Source: 
* Id:  
*
* Jun 5, 2017: Original version (ALA)
*
*/
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
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class CurrencyController extends BaseController implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
    
    private ApplicationContext applicationContext;
    
    private IDonnaService donnaService;
    
    public void setDonnaService(IDonnaService donnaService) {
        this.donnaService = donnaService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
    }
    
    @RequestMapping(value = "/currency", method = RequestMethod.GET)
    public ModelAndView brand(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HCurrency> ctg = new ArrayList<HCurrency>();
	//if(curuser.getRole().equalsIgnoreCase("Admin")){
	    ctg = donnaService.getCurrencyList("");
	//} 
		
	mm.addAttribute("selUrl","currency");
	mm.addAttribute("ctg",ctg);
	return new ModelAndView("currency", mm);
    }
    
    @RequestMapping(value = "/addnewcurrency", method = RequestMethod.GET)
    public ModelAndView addnewcurrency(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	mm.addAttribute("selUrl","currency");
	
	return new ModelAndView("addnewcurrency", mm);
    }
    
    @RequestMapping(value = "/currencyedit/{id}", method = RequestMethod.GET)
    public ModelAndView currencyedit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	HCurrency currency = donnaService.getCurrencyList(id).get(0);
	
	mm.addAttribute("selUrl","currency");
	mm.addAttribute("ctg", currency);
	
	return new ModelAndView("currencyedit", mm);
    }
    
    @RequestMapping(value = "/currencydelete/{id}", method = RequestMethod.GET)
    public ModelAndView currencydelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	HCurrency ctg = new HCurrency();
	
	ctg.setCurc(id);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateCurrencyDetails(ctg,2);
	
	mm.addAttribute("selUrl","currency");
	//mm.addAttribute("mem", mem);
	return new ModelAndView("redirect:/currency");
    }
    
 // ==================================================POST============================================================
    @RequestMapping(value = "/addcurrency", method = RequestMethod.POST)
    public ModelAndView addcurrency(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String currency_name = parameterMap.get("curn")[0];	

	ModelMap mm = new ModelMap();
	
	HCurrency currency = new HCurrency();
	currency.setCurn(currency_name);
	currency.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.registerCurrency(currency);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/editcurrency", method = RequestMethod.POST)
    public ModelAndView editcurrency(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String currency_code = parameterMap.get("curc")[0];
	String currency_name = parameterMap.get("curn")[0];
	
	ModelMap mm = new ModelMap();
	
	HCurrency ctg = new HCurrency();
	ctg.setCurc(currency_code);
	ctg.setCurn(currency_name);
	ctg.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateCurrencyDetails(ctg,1);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
}
