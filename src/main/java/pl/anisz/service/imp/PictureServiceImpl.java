package pl.anisz.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.anisz.domain.Picture;
import pl.anisz.domain.repository.PictureRepository;
import pl.anisz.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	PictureRepository pictureRepository;

	private LocalDate todaysDate = LocalDate.now();

	public Picture getPictureByUrl(String url) {
		return pictureRepository.getPictureByUrl(url);
	}

	public Picture getPictureByDate(String date) {
		LocalDate localDate = LocalDate.parse(date);
		if (localDate.isAfter(todaysDate)) {		
			return setMockPicture();
		} else {
			return pictureRepository.getPictureByDate(date);
		}
	}

	public List<Picture> getRecentPictures() {
		return pictureRepository.getRecentPictures();
	}

	public void setNumberOfDays(int numberOfDays) {
		pictureRepository.setNumberOfDays(numberOfDays);
	}
	
	public Picture setMockPicture() {
		Picture pictureMock = new Picture();
		pictureMock.setTitle("There are no future pictures yet!");
		pictureMock.setExplanation("Choose today's or past date!");
		return pictureMock;
	}
}
