package pl.anisz.service;

import java.util.List;

import pl.anisz.domain.Picture;

public interface PictureService {

	public Picture getPictureByUrl(String url);
	
	public Picture getPictureByDate(String date);
	
	public List<Picture> getRecentPictures();
	
	public void setNumberOfDays(int numberOfDays);	
}
