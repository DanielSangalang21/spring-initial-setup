package dcs.project.barangay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dcs.project.barangay.bean.BarangayOfficialBean;
import dcs.project.barangay.mappers.BarangayOfficialMappers;

@Controller
@SessionAttributes("brgyOfficialBean")
@RequestMapping("/officeLogin")
@CrossOrigin
public class LoginController {

	@Autowired
	BarangayOfficialMappers mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public String returnView(ModelMap modelMap) {
		
		BarangayOfficialBean brgyBean = new BarangayOfficialBean();
		
		modelMap.addAttribute("brgyOfficialBean", brgyBean);
		return "welcome";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String verifyLogin(ModelMap modelMap,@ModelAttribute("brgyOfficialBean")BarangayOfficialBean bean) {
		BarangayOfficialBean bean2 = mapper.findUser(bean.getUserName());
		return "blankPage";
	}
}
