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
import com.ey.donna.model.HCurrency;
import com.ey.donna.model.HMember;
import com.ey.donna.model.HSettlement;
import com.ey.donna.model.HShipping;
import com.ey.donna.model.HSupply;
import com.ey.donna.services.interfaces.IDonnaService;

@Controller
public class SettlementController extends BaseController implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(SettlementController.class);

	private ApplicationContext applicationContext;

	private IDonnaService donnaService;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void setDonnaService(IDonnaService donnaService) {
		this.donnaService = donnaService;
	}
	
	@RequestMapping(value = "/settlement", method = RequestMethod.GET)
	public ModelAndView settlement(HttpServletRequest request) throws Exception {
		boolean validSession = getSessionService().isSessionValid();

		HMember curuser = getUser();
		ModelMap mm = new ModelMap();
		mm.addAttribute("validSession", validSession);
		mm.addAttribute("currentuser", curuser);

		if (!validSession) {
			return new ModelAndView("redirect:/");
		}

		List<HSettlement> set = new ArrayList<HSettlement>();

		set = donnaService.getSettlementList("");

		mm.addAttribute("selUrl", "settlement");
		mm.addAttribute("set", set);
		
		return new ModelAndView("settlement", mm);
	}
	
	@RequestMapping(value = "/add-settlement", method = RequestMethod.GET)
	public ModelAndView addSettlement(HttpServletRequest request) throws Exception {
		boolean validSession = getSessionService().isSessionValid();

		HMember curuser = getUser();
		ModelMap mm = new ModelMap();
		mm.addAttribute("validSession", validSession);
		mm.addAttribute("currentuser", curuser);

		if (!validSession) {
			return new ModelAndView("redirect:/");
		}

		mm.addAttribute("selUrl", "settlement");
		
		return new ModelAndView("addsettlement", mm);
	}
	
	@RequestMapping(value = "/edit-settlement/{id}", method = RequestMethod.GET)
	public ModelAndView getEditSettlement(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
		boolean validSession = getSessionService().isSessionValid();

		ModelMap mm = new ModelMap();
		mm.addAttribute("validSession", validSession);
		mm.addAttribute("currentuser", getUser());

		if (!validSession) {
			return new ModelAndView("redirect:/");
		}


		HSettlement settlement = donnaService.getEditSettlement(id).get(0);
		

		mm.addAttribute("selUrl", "settlement");

		mm.addAttribute("settlement", settlement);		

		return new ModelAndView("editsettlement", mm);
	}
	
	@RequestMapping(value = "/settlementdelete/{id}", method = RequestMethod.GET)
    public ModelAndView currencydelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
		boolean validSession = getSessionService().isSessionValid();
			
		ModelMap mm = new ModelMap();
		mm.addAttribute("validSession", validSession);
		mm.addAttribute("currentuser", getUser());
	
		if (!validSession) {
		    return new ModelAndView("redirect:/");
		}
		
		HSettlement settlement = new HSettlement();
		
		settlement.setStlc(id);;
		settlement.setModifiedby(getUser().getFname());
		
		boolean res = donnaService.updateSettlement(settlement,2);
		
		mm.addAttribute("selUrl","settlement");
	return new ModelAndView("redirect:/settlement");
    }
	
	// POST Mehtod
	@RequestMapping(value = "/insertSettlement", method = RequestMethod.POST)
	public ModelAndView postAddSettlement(HttpServletRequest request) throws Exception {

		Map<String, String[]> parameterMap = request.getParameterMap();

		String stln = parameterMap.get("stln")[0];

		ModelMap mm = new ModelMap();

		HSettlement settlement = new HSettlement();
		
		settlement.setStln(stln);
		settlement.setModifiedby(getUser().getFname());

		boolean res = donnaService.insertSettlement(settlement);

		if (res) {
			mm.addAttribute("msg", "OK");

		} else
			mm.addAttribute("msg", "ERROR");

		return new ModelAndView("result", mm);
	}
	
	@RequestMapping(value = "/editsettlement", method = RequestMethod.POST)
	public ModelAndView postEditSettlement(HttpServletRequest request) throws Exception {

		Map<String, String[]> parameterMap = request.getParameterMap();

		String stlc = parameterMap.get("stlc")[0];		
		String stln = parameterMap.get("stln")[0];

		ModelMap mm = new ModelMap();

		HSettlement settlement = new HSettlement();
		
		settlement.setStlc(stlc);
		settlement.setStln(stln);
		settlement.setModifiedby(getUser().getFname());

		boolean res = donnaService.updateSettlement(settlement, 1);

		if (res) {
			mm.addAttribute("msg", "OK");

		} else
			mm.addAttribute("msg", "ERROR");

		return new ModelAndView("result", mm);
	}

}
