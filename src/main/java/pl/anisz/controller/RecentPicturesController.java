package pl.anisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anisz.service.PictureService;

@Controller
public class RecentPicturesController {

	@Autowired
	private PictureService pictureService;

	@RequestMapping("/pictures")
	public String showRecentPictures(Model model) {

		model.addAttribute("recentPictures", pictureService.getRecentPictures());

		return "recentPictures";
	}
}
