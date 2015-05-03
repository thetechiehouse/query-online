package com.thetechiehouse.queryonline.web;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.thetechiehouse.queryonline.service.ExcelService;
import com.thetechiehouse.queryonline.service.QueryService;
import com.thetechiehouse.queryonline.vo.Animal;
import com.thetechiehouse.queryonline.vo.QueryVO;

@Controller
@RequestMapping("/queryonline")
public class QueryRestService {
	protected ExcelService animalService = new ExcelService();

	@Autowired
	private QueryService userService;

	@RequestMapping(value = "/2", method = RequestMethod.GET)
	public ModelAndView redirect2() {

		return new ModelAndView("index");

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String redirect() {

		return "redirect:/index.html";
	}

	@RequestMapping(value = "/allQueries222", method = RequestMethod.GET)
	public int getNumberOfUsers2() {
		return userService.getNumberOfDBQueries();
	}

	@RequestMapping("/allQueries")
	public @ResponseBody
	List<QueryVO> getAllUsersInJSON() {
		return userService.getAllDBQuries();
	}

	@RequestMapping("/query/{id}")
	public @ResponseBody
	QueryVO getUserById(@PathVariable("id") String id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/addQuery", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	QueryVO create(@RequestBody QueryVO queryVO) {
		QueryVO queryVONew = new QueryVO();
		queryVONew.setName(queryVO.getName());
		queryVONew.setDescription(queryVO.getDescription());
		queryVONew.setDefinition(queryVO.getDefinition());
		return userService.createNewQuery(queryVONew);
	}

	@RequestMapping(value = "/updateQuery", method = RequestMethod.PUT)
	public @ResponseBody
	QueryVO update(@RequestBody QueryVO queryVO) {
		return userService.update(queryVO);
	}

	@RequestMapping(value = "/deleteQuery", method = RequestMethod.DELETE)
	public @ResponseBody
	void remove(@RequestParam("id") String id) {
		userService.remove(id);
	}

	@RequestMapping(value = "/downloadData", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
		// get your file as InputStream

		BufferedReader br = null;

	}

	@RequestMapping(value = "/AnimalList", method = RequestMethod.GET)
	public @ResponseBody
	String getAnimals(Model model) {
		List<Animal> animalList = animalService.getAnimalList();
		model.addAttribute("animalList", animalList);
		return "AnimalList";
	}

	@RequestMapping(value = "/export.xslx", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<Animal> animalList = animalService.getAnimalList();
		Map revenueData = new HashMap();
		revenueData.put("Jan-2010", "$100,000,000");
		revenueData.put("Feb-2010", "$110,000,000");
		revenueData.put("Mar-2010", "$130,000,000");
		revenueData.put("Apr-2010", "$140,000,000");
		revenueData.put("May-2010", "$200,000,000");
		System.out.println("revenueData=" + revenueData.size());
		return new ModelAndView("AnimalListExcel", "revenueData", revenueData);

		// return new ModelAndView("AnimalListExcel", "animalList", animalList);
	}

	@RequestMapping("/4234232")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(@RequestParam("name") String name, Model model) {
		String message = "Hi " + name + "!";
		model.addAttribute("message", message);
		return "hi";
	}

}