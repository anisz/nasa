package pl.anisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.anisz.service.PictureService;

@Controller
public class NumberOfDaysController {
	
	int numberOfDays;
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value = "/setDays", method = RequestMethod.GET)
	public String getNumberOfDaysForm(Model model) {			
		model.addAttribute("numberOfDays", numberOfDays);
		return "setNumberOfDays";
	}
	
	@RequestMapping(value = "/setDays", method = RequestMethod.POST)
	public String processNumberOfDaysForm(@ModelAttribute("numberOfDays") int numberOfDays) {	
		pictureService.setNumberOfDays(numberOfDays);
		return "numberOfDaysConfirmation";
	}
}
