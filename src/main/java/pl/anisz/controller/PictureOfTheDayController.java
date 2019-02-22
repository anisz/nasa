package pl.anisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.anisz.domain.Picture;
import pl.anisz.service.PictureService;

@Controller
public class PictureOfTheDayController {
	
	@Autowired
	private PictureService pictureService;
	
	private static final String PRIMARY_URL = "https://api.nasa.gov/planetary/apod?api_key=MipHissD9dRsI1jca7ZG00KGBhtUzzPtsILxxXeH";

	@RequestMapping("/")
	public String showPictureOfTheDay(Model model){
		Picture picture = new Picture();
		picture = pictureService.getPictureByUrl(PRIMARY_URL);
		
		model.addAttribute("pictureOfTheDay", picture);
		return "pictureOfTheDay";
	} 
}

