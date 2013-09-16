package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	String answer1 = "N/A";
    	String answer2 = "N/A";
    	String answer3 = "N/A";
        render( answer1, answer2, answer3);
    }

}