package pl.anisz.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("../test-DispatcherServlet-context.xml")

public class PictureControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void test_picture_of_the_day_controller() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(model().attributeExists("pictureOfTheDay"));
	}

	@Test
	public void test_picture_by_date_controller() throws Exception {
		String date = "2019-01-01";
		this.mockMvc.perform(get("/date").param("date", date)).andExpect(model().attributeExists("pictureByDate"));
	}
	
	@Test
	public void test_recent_pictures_controller() throws Exception {
		this.mockMvc.perform(get("/pictures")).andExpect(model().attributeExists("recentPictures"));
	}
}