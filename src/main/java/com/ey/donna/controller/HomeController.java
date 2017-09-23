package com.ey.donna.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ey.donna.controller.BaseController;
import com.ey.donna.model.HMember;
import com.ey.donna.model.HSettlement;
import com.ey.donna.model.HTransactionLog;
import com.ey.donna.model.UserSession;
import com.ey.donna.services.interfaces.IDonnaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController implements ApplicationContextAware{

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private ApplicationContext applicationContext;
    
    private IDonnaService donnaService;
    
    private JavaMailSenderImpl donnamailSender;

    public void setApplicationContext(ApplicationContext applicationContext) {
	this.applicationContext = applicationContext;
    }
  
    public void setDonnaService(IDonnaService donnaService) {
        this.donnaService = donnaService;
    }
     
    public void setDonnamailSender(JavaMailSenderImpl donnamailSender) {
        this.donnamailSender = donnamailSender;
    }

    // ==================================================GET============================================================
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (validSession) {
	    return new ModelAndView("redirect:/home");
	}

	return new ModelAndView("redirect:/login");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) throws Exception {

	boolean validSession = getSessionService().isSessionValid();

	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (validSession) {
	    return new ModelAndView("redirect:/");
	}

	return new ModelAndView("login", mm);
    }
    
    @RequestMapping(value="/user/logout", method=RequestMethod.GET)
    public ModelAndView userLogout(HttpServletRequest request) throws Exception {
	String requestUri = getStringFromHttpRequest(request);
		
	logger.info("requestUri="+requestUri);
		
	getSessionService().invalidateSession(getSessionService().getUserSession().getSessionId());
					
				
	return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	Map<String,Integer> reccount=new HashMap<String,Integer>();
	reccount = donnaService.getLastWeekUpdate();
	 for(Map.Entry m:reccount.entrySet()){  
	     mm.addAttribute(m.getKey().toString(), m.getValue().toString());
	 }  
	return new ModelAndView("home", mm);
    }
    
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public ModelAndView member(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HMember> mem = new ArrayList<HMember>();
	if(curuser.getMsta().equalsIgnoreCase("Admin")){
	    mem = donnaService.getMemberList("");
	} else{
	    mem = donnaService.getMemberList(curuser.getPid());
	}
	
	
	
	mm.addAttribute("selUrl","member");
	mm.addAttribute("mem", mem);
	return new ModelAndView("member", mm);
    }
    
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelAndView transaction(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();

	HMember curuser = getUser();
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", curuser);
	
	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HTransactionLog> tlog = new ArrayList<HTransactionLog>();
	
	tlog = donnaService.getTransactionLog("");
	
	mm.addAttribute("selUrl","transaction");
	mm.addAttribute("tlog", tlog);
	return new ModelAndView("transaction", mm);
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request) throws Exception {
	ModelMap mm = new ModelMap();
	
	return new ModelAndView("registration", mm);
    }
    
    @RequestMapping(value = "/addnewmember", method = RequestMethod.GET)
    public ModelAndView addnewmember(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	mm.addAttribute("selUrl","member");
	
	return new ModelAndView("addnewmember", mm);
    }
    
    //localhost:8080/donna/verified/P0000000001
    @RequestMapping(value = "/verified/{id}", method = RequestMethod.GET)
    public ModelAndView verified(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
	logger.info("id=" + id);
	
	boolean Fo = donnaService.verifyedMember(id,0);
		
	return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/memberdetailregistration", method = RequestMethod.GET)
    public ModelAndView memberdetailregistration(HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	List<HSettlement> settlement = donnaService.getSettlementList("");
	
	
	mm.addAttribute("settlement",settlement);
		
	return new ModelAndView("memberdetails", mm);
    }
    
    @RequestMapping(value = "/memberedit/{id}", method = RequestMethod.GET)
    public ModelAndView memberedit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	
	HMember mem = donnaService.getMemberList(id).get(0);
	
	mm.addAttribute("selUrl","member");
	mm.addAttribute("mem", mem);
	
	return new ModelAndView("memberedit", mm);
    }
    
    @RequestMapping(value = "/memberdelete/{id}", method = RequestMethod.GET)
    public ModelAndView memberdelete(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	boolean validSession = getSessionService().isSessionValid();
		
	ModelMap mm = new ModelMap();
	mm.addAttribute("validSession", validSession);
	mm.addAttribute("currentuser", getUser());

	if (!validSession) {
	    return new ModelAndView("redirect:/");
	}
	HMember mem = new HMember();
	mem.setPid(id);
	mem.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateMemberDetails(mem,3);
	
	//mm.addAttribute("selUrl","member");
	//mm.addAttribute("mem", mem);
	return new ModelAndView("redirect:/member");
    }
    
 // ==================================================POST============================================================   
    @RequestMapping(value = "/users/valideduser", method = RequestMethod.POST)
    public ModelAndView userVerify(HttpServletRequest request) throws Exception {

	String requestUri = getStringFromHttpRequest(request);

	logger.info("requestUri=" + requestUri);

	String[] requestUriSplit = requestUri.split("~");

	if (requestUriSplit.length < 2) {
	    logger.warn("Expecting atleast 2 arguments but received " + requestUriSplit.length);
	    return null;
	}

	String pid = requestUriSplit[0];
	String pass = requestUriSplit[1];

	HMember user = new HMember();
	user.setPid(pid);
	user.setPass(pass);
	
	HMember sysuser = donnaService.getMemberVerifyState(user.getPid());
	
	String user_name = "-1";
	
	if(sysuser!=null){
	    sysuser = donnaService.getUserValidation(user);
	} else{
	    user_name = "-2";
	}
	
	if (sysuser != null) {
	    UserSession session = getSessionService().insertSession(request, sysuser);
	    if(sysuser.getVerified()==2)
		user_name = sysuser.getPid();
	    else if(sysuser.getVerified()==1)
		user_name = "-3";
	}

	ModelMap mm = new ModelMap();
	mm.addAttribute("msg", user_name);

	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/addmember", method = RequestMethod.POST)
    public ModelAndView addmember(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String first_name = parameterMap.get("first-name")[0];
	String email = parameterMap.get("email")[0];
	String password = parameterMap.get("password")[0];
	String confirm_password = parameterMap.get("confirm-password")[0];
	String accounttype = parameterMap.get("accounttype")[0];

	ModelMap mm = new ModelMap();
	
	if(password==confirm_password){
	    mm.addAttribute("msg", "PASS");
	    return new ModelAndView("result", mm);
	}
	HMember sesuser = getUser();
	
	HMember user = new HMember();
	user.setMad(email);
	user.setPass(password);
	user.setFdname(first_name);
	user.setMsta(accounttype);
	if(sesuser!=null && sesuser.getFname()!=null)
	    user.setModifiedby(sesuser.getFname());
	else
	    user.setModifiedby("");
	
	HMember extuser = donnaService.getMemberByEmail(user.getMad());
	if(extuser!=null)
	{
	    mm.addAttribute("msg", "EXIST");
	    return new ModelAndView("result", mm);
	}
	boolean res = donnaService.registerMember(user);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    HMember sysuser = donnaService.getMemberByEmail(user.getMad());
	    Map<String, String> emailtxt = new HashMap<String, String>();
	    String EMailto[] = new String[1];
	    EMailto[0] = email;
	    emailtxt.put("<#FIRSTNAME#>", sysuser.getFname());
	    emailtxt.put("<#PID#>", sysuser.getPid());
	    String requestUri ="http://123.200.14.12:8080/";
	    //String requestUri ="http://sharing.com.bd:8181/";
	    emailtxt.put("<#APPROVE_LINK#>", requestUri + "donna/verified/"+sysuser.getPid());
	    
	    String body = getEmialTemplateFromResource("verificationrequest", emailtxt);
	    
	    sendEmail(EMailto, "", "Donna Member verification", body, donnamailSender);
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    
    @RequestMapping(value = "/addmemberdetails", method = RequestMethod.POST)
    public ModelAndView addmemberdetails(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String pid = parameterMap.get("pid")[0];
	String fname = parameterMap.get("fname")[0];
	String lname = parameterMap.get("lname")[0];
	String mname = parameterMap.get("mname")[0];
	String nname = parameterMap.get("nname")[0];
	
	String fdname = parameterMap.get("fdname")[0];
	String ldname = parameterMap.get("ldname")[0];
	String mdname = parameterMap.get("mdname")[0];
	String ndname = parameterMap.get("ndname")[0];
	
	String adr = parameterMap.get("adr")[0];
	String cna = parameterMap.get("cna")[0];
	String adrj = parameterMap.get("adrj")[0];
	String cnj = parameterMap.get("cnj")[0];
	
	String stlc = parameterMap.get("stlc")[0];

	ModelMap mm = new ModelMap();
	
	HMember mem = new HMember();
	
	mem.setPid(pid);
	mem.setFname(fname);
	mem.setFdname(fdname);
	mem.setLname(lname);
	mem.setLdname(ldname);
	mem.setMname(mname);
	mem.setMdname(mdname);
	mem.setNname(nname);
	mem.setNdname(ndname);
	
	mem.setAdr(adr);
	mem.setAdrj(adrj);
	mem.setCna(cna);
	mem.setCnj(cnj);
	
	mem.setStlc(stlc);
	mem.setModifiedby(getUser().getFname());
	
	boolean res = donnaService.updateMemberDetails(mem,2);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
    
    @RequestMapping(value = "/editmemberdetails", method = RequestMethod.POST)
    public ModelAndView editmemberdetails(HttpServletRequest request) throws Exception {

	Map<String, String[]> parameterMap = request.getParameterMap();
	
	String pid = parameterMap.get("pid")[0];
	String fname = parameterMap.get("fname")[0];
	String lname = parameterMap.get("lname")[0];
	String mname = parameterMap.get("mname")[0];
	//String nname = parameterMap.get("nname")[0];
	
	String fdname = parameterMap.get("fdname")[0];
	String ldname = parameterMap.get("ldname")[0];
	String mdname = parameterMap.get("mdname")[0];
	//String ndname = parameterMap.get("ndname")[0];
	
	String adr = parameterMap.get("adr")[0];
	String cna = parameterMap.get("cna")[0];
	String adrj = parameterMap.get("adrj")[0];
	String cnj = parameterMap.get("cnj")[0];
	
	//String stlc = parameterMap.get("stlc")[0];

	ModelMap mm = new ModelMap();
	
	HMember mem = new HMember();
	
	mem.setPid(pid);
	mem.setFname(fname);
	mem.setFdname(fdname);
	mem.setLname(lname);
	mem.setLdname(ldname);
	mem.setMname(mname);
	mem.setMdname(mdname);
	//mem.setNname(nname);
	//mem.setNdname(ndname);
	
	mem.setAdr(adr);
	mem.setAdrj(adrj);
	mem.setCna(cna);
	mem.setCnj(cnj);
	mem.setModifiedby(getUser().getFname());
	
	//mem.setStlc(stlc);
	
	boolean res = donnaService.updateMemberDetails(mem,1);
	
	if(res){
	    mm.addAttribute("msg", "OK");
	    
	} else
	    mm.addAttribute("msg", "ERROR");
	
	return new ModelAndView("result", mm);
    }
}
