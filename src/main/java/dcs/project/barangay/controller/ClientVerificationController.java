package dcs.project.barangay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dcs.project.barangay.bean.BarangayOfficialBean;

@RestController
@RequestMapping("/verifyClient")
public class ClientVerificationController {

	@PostMapping("/{user}/{password}")
	public Object verifyClient(@PathVariable("user") String user,@PathVariable("password") String password, ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		BarangayOfficialBean bean = new BarangayOfficialBean();
		bean.setUserName("daniel");
		bean.setPassword("123");
		
		if (user.equals(bean.getUserName()) && password.equals(bean.getPassword())) {
			return "login success";
		}else {
			return "try again";
		}
	}
}
