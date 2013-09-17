/** File:       Demographic.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package controllers;

import java.util.Collections;

import javax.inject.Inject;

import common.InvalidInputException;

import play.mvc.Controller;
import play.mvc.results.NotFound;
import pojo.Gender;
import service.DemographicService;
import sun.awt.image.BadDepthException;

/** Controller for Demographic REST API
 */
public class Demographic extends Controller {
	@Inject static DemographicService demographicService;
	
    public static void genderCount( String gender) {
    	Gender validatedGender = Gender.findForString( gender);
    	notFoundIfNull( validatedGender, "Gender does not exist");
    	int count = demographicService.countByGender( validatedGender);
    	renderJSON( Collections.singletonMap( "count", count));
    }
    
    public static void ageMaximum() {
    	String name = demographicService.findNameByAgeMax();
    	renderJSON( Collections.singletonMap( "name", name));
    }
    
    public static void ageCompare(String low, String high) {
    	try {
    		renderJSON( Collections.singletonMap( "days", demographicService.compareAgeInDays( low, high)));
		}
		catch( InvalidInputException e) {
			response.status = 400;
			renderJSON( Collections.singletonMap( "errorMessage", e.getMessage()));
		}        
    }
    
}
