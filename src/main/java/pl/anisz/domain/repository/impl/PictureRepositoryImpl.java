package pl.anisz.domain.repository.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.anisz.domain.Picture;
import pl.anisz.domain.repository.PictureRepository;

@Repository
public class PictureRepositoryImpl implements PictureRepository {

	private final String DATE_URL = "https://api.nasa.gov/planetary/apod?api_key=MipHissD9dRsI1jca7ZG00KGBhtUzzPtsILxxXeH&date=";

	private int numberOfDays = 12;

	private Picture picture;
	private List<Picture> pictureList = new ArrayList<Picture>();

	ObjectMapper objectMapper = new ObjectMapper();

	public Picture getPictureByUrl(String url) {
		try {
			picture = objectMapper.readValue(new URL(url), Picture.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picture;
	}

	public Picture getPictureByDate(String date) {
			StringBuilder tempUrl = new StringBuilder(DATE_URL);
			String finalUrlWithDate = tempUrl.append(date).toString();
			return getPictureByUrl(finalUrlWithDate);
		}

	public List<Picture> getRecentPictures() {
		pictureList.clear();
		for (int i = 0; i < numberOfDays; i++) {
			StringBuilder tempUrl = new StringBuilder(DATE_URL);
			LocalDate pictureDate = LocalDate.now().minusDays(i);
			tempUrl.append(pictureDate);
			Picture picture = getPictureByUrl(tempUrl.toString());
			pictureList.add(picture);
		}
		return pictureList;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}
}
