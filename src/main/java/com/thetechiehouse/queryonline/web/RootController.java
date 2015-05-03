package com.thetechiehouse.queryonline.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
	@RequestMapping("/dasdas")
	public class RootController
	{

	@RequestMapping(method = RequestMethod.GET)
	   public ModelAndView redirect2() {
	     
  return new ModelAndView("index");  

	      //return "redirect:/pages/index.jsp";
	   }

	}	
	
/*
	@RequestMapping(value = "/AnimalList", method = RequestMethod.GET)
	public String getAnimals(Model model) {
		List<Animal> animalList = animalService.getAnimalList();
		model.addAttribute("animalList", animalList);
		return "AnimalList";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<Animal> animalList = animalService.getAnimalList();
		return new ModelAndView("AnimalListExcel", "animalList", animalList);
	}
*/
/*@RequestMapping("/")
	public String hello() {
		return "hello";
	}
	*/
	/*
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(@RequestParam("name") String name, Model model) {
		String message = "Hi " + name + "!";
		model.addAttribute("message", message);
		return "hi";
	}
	*/
