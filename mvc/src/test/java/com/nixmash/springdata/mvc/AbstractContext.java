package com.nixmash.springdata.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.nixmash.springdata.jpa.enums.DataConfigProfile;
import com.nixmash.springdata.solr.enums.Constants;

@SuppressWarnings("deprecation")
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
@ActiveProfiles({ DataConfigProfile.SPRING_PROFILE_H2, Constants.DEV })
public class AbstractContext {

	@Autowired
	protected WebApplicationContext context;

}
