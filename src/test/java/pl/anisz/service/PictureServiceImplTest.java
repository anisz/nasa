package pl.anisz.service;

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
import pl.anisz.service.imp.PictureServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("../test-DispatcherServlet-context.xml")

public class PictureServiceImplTest {

	@Autowired
	PictureServiceImpl pictureServiceImpl;
	
	private static final String PRIMARY_URL = "https://api.nasa.gov/planetary/apod?api_key=MipHissD9dRsI1jca7ZG00KGBhtUzzPtsILxxXeH";
	
	private String todaysDate = LocalDate.now().toString();
	
	@Test
	public void apod_not_null() {
		Picture picture = pictureServiceImpl.getPictureByUrl(PRIMARY_URL);
		Assert.assertNotNull(picture);
	}

	@Test
	public void apod_date_should_be_equal_todays_date() {
		Picture picture = pictureServiceImpl.getPictureByUrl(PRIMARY_URL);
		Assert.assertEquals(todaysDate, picture.getDate());
	}

	@Test
	public void past_pictures_date_should_be_equal_to_requested_date() {
		String exampleDate = LocalDate.of(2019, 01, 01).toString();
		Picture picture = pictureServiceImpl.getPictureByDate(exampleDate);
		Assert.assertEquals(exampleDate, picture.getDate());
	}

	@Test
	public void future_pictures_date_should_have_special_title() {
		String exampleDate = LocalDate.of(2030, 01, 01).toString();
		Picture picture = pictureServiceImpl.getPictureByDate(exampleDate);
		Assert.assertEquals("There are no future pictures yet!", picture.getTitle());
	}

	@Test
	public void future_pictures_date_should_have_special_explanation() {
		String exampleDate = LocalDate.of(2030, 01, 01).toString();
		Picture picture = pictureServiceImpl.getPictureByDate(exampleDate);
		Assert.assertEquals("Choose today's or past date!", picture.getExplanation());
	}
}
