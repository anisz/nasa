package pl.anisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.anisz.service.PictureService;

@Controller
public class PictureByDateController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/date")
	public String showPictureByDate(Model model, @RequestParam String date){	
		model.addAttribute("pictureByDate", pictureService.getPictureByDate(date));
		return "pictureByDate";
	}
}
