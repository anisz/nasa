package pl.anisz.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.anisz.domain.Picture;
import pl.anisz.domain.repository.impl.PictureRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("../../test-DispatcherServlet-context.xml")

public class PictureRepositoryImplTest {
		
	@Autowired
	PictureRepositoryImpl pictureRespositoryImpl;

	private static final String PRIMARY_URL = "https://api.nasa.gov/planetary/apod?api_key=MipHissD9dRsI1jca7ZG00KGBhtUzzPtsILxxXeH";
	
	private String todaysDate = LocalDate.now().toString();
	
	@Test
	public void apod_not_null() {
		Picture picture = pictureRespositoryImpl.getPictureByUrl(PRIMARY_URL);	
		Assert.assertNotNull(picture);
	}
	
	@Test
	public void apod_date_should_be_equal_todays_date() {
		Picture picture = pictureRespositoryImpl.getPictureByUrl(PRIMARY_URL);	
		Assert.assertEquals(todaysDate, picture.getDate());
	}
	
	@Test
	public void number_of_days_should_be_equal_to_pictureList_size() {
		int numberOfDays = 5;
		pictureRespositoryImpl.setNumberOfDays(numberOfDays);
		pictureRespositoryImpl.getRecentPictures();
		List<Picture> pictureList = pictureRespositoryImpl.getPictureList();
		Assert.assertEquals(numberOfDays, pictureList.size());
	}
	
	@Test
	public void pictures_date_should_be_equal_to_requested_date() {
		String exampleDate = LocalDate.of(2019, 01, 01).toString();
		Picture picture = pictureRespositoryImpl.getPictureByDate(exampleDate);	
		Assert.assertEquals(exampleDate, picture.getDate());
	}
}
