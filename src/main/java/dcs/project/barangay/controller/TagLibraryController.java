package dcs.project.barangay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dcs.project.barangay.mappers.BarangayOfficialMappers;

@RestController
public class TagLibraryController {
	
	@Autowired
	BarangayOfficialMappers brgyMapper;
	
	public String returnView() {
		return "viewWithTld";
	}
}
