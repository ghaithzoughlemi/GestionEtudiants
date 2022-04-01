package com.example.TP1.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TP1.DAO.DepartementR;

@RestController
@RequestMapping(value = "/departement")
public class DepartementCont {

	@Autowired
	private DepartementR DT;
	
	@GetMapping("/allD")
	public Collection<Object> allD() {
		return DT.Afficher1();
	}
	
}
