package com.wonde.celebritiesofficialpageinfoservice;

import com.wonde.celebritiesofficialpageinfoservice.controller.AppUsersController;
import com.wonde.celebritiesofficialpageinfoservice.controller.PersonsInfoController;
import com.wonde.celebritiesofficialpageinfoservice.controller.SocialMediasController;
import com.wonde.celebritiesofficialpageinfoservice.model.PersonsInfo;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
public class CelebritiesOfficialPersonsInfoControllerApplicationTests {

	@Autowired
	AppUsersController appUsersController;
	@Autowired
	PersonsInfoController personsInfoController;
	@Autowired
	SocialMediasController socialMediasController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void appUsersControllerNotNullTest() {
		Assert.assertNotNull(appUsersController);
	}
	@Test
	public void psrsonInfoControllerNotNullTest() {
		Assert.assertNotNull(personsInfoController);
	}
	@Test
	public void socialMediaControllerNotNullTest() {
		Assert.assertNotNull(socialMediasController);
	}

	@Test
	public void testCreateReadDelete() {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://localhost:8080/secured/user/person/";

//		PersonsInfo personsInfo = new PersonsInfo(25, "Wonde-Test",
//								"Tade Test", "Maried",
//								41, null);
//		ResponseEntity<PersonsInfo> entity = restTemplate.postForEntity(baseUrl + "create", personsInfo, PersonsInfo.class);
//		PersonsInfo[] personsInfos = restTemplate.getForObject(baseUrl + "create", PersonsInfo[].class);
//		Assertions.assertThat(personsInfos).extracting(PersonsInfo::getFirstName).containsOnly("Wonde");
//
//		restTemplate.delete(baseUrl + "/delete" + entity.getBody().getPersonId());
//		Assertions.assertThat(restTemplate.getForObject(baseUrl, PersonsInfo[].class)).isEmpty();
	}
}
