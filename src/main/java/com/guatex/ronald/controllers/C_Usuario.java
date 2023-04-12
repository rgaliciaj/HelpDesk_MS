package com.guatex.ronald.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guatex.ronald.dao.D_Usuario;
import com.guatex.ronald.models.E_Usuario;

@RestController
public class C_Usuario {
	
	@GetMapping("/getUser")
	public @ResponseBody List<E_Usuario> getUser(@RequestParam (name = "id") String id){
		List<E_Usuario> listResult = new D_Usuario().getUser(id);
		return listResult;
	}
}
