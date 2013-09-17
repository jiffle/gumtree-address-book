/** File:       Application.java
 *  Created by: davidhamilton
 *          on: 16 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package controllers;

import play.*;
import play.mvc.*;
import pojo.Gender;
import service.DemographicService;

import java.util.*;

import javax.inject.Inject;

import common.InvalidInputException;

import models.*;

public class Application extends Controller {
private static final String NOT_AVAILABLE = "N/A";
@Inject static DemographicService demographicService;
	
    public static void index() {
    	final String answer1 = String.valueOf( demographicService.countByGender( Gender.MALE));
    	String answer2 = demographicService.findNameByAgeMax();
    	if( answer2 == null) {
    		answer2 = NOT_AVAILABLE;
    	}
    	String answer3;
    	try {
			answer3 = String.valueOf( demographicService.compareAgeInDays( "Paul", "Bill"));
		}
		catch( InvalidInputException e) {
			answer3 = NOT_AVAILABLE;
		}
        render( answer1, answer2, answer3);
    }

}