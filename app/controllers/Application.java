package controllers;

import play.*;
import play.mvc.*;
import pojo.Gender;
import service.DemographicService;

import java.util.*;

import javax.inject.Inject;

import models.*;

public class Application extends Controller {
@Inject static DemographicService demographicService;
	
    public static void index() {
    	String answer1 = String.valueOf( demographicService.countByGender( Gender.MALE));
    	String answer2 = "N/A";
    	String answer3 = "N/A";
        render( answer1, answer2, answer3);
    }

}