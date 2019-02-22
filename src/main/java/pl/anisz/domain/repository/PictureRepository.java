package pl.anisz.domain.repository;

import java.util.List;

import pl.anisz.domain.Picture;

public interface PictureRepository{
	
	Picture getPictureByUrl(String url);
	
	Picture getPictureByDate(String date);
	
	List<Picture> getRecentPictures();
	
	public void setNumberOfDays(int numberOfDays);
	
	public List<Picture> getPictureList();
}
