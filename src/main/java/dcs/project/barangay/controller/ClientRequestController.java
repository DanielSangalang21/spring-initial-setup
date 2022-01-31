package dcs.project.barangay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dcs.project.barangay.bean.BarangayOfficialBean;

@RestController
@RequestMapping("/request")
public class ClientRequestController {

	@GetMapping("/brgyClearance/{name}")
	public Object getUserCredentials(@PathVariable("name") String name, ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		BarangayOfficialBean bean = new BarangayOfficialBean();
		bean.setUserName(name);
		bean.setPassword("Sangalang");
		
		return bean;
	}
	
}
