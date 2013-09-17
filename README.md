gumtree-address-book
====================

## Requirements

This requires Play Framework 1.2.x. The latest version is available from

    http://downloads.typesafe.com/play/1.2.7/play-1.2.7.zip

Installation instructions are at:

    http://www.playframework.com/documentation/1.2.7/install


## Build, Test & Run

### Build
To Build, run the dependencies command:

    play deps
    
Then (due to a bug in Guice module) please delete the generated directory at:

	$APP_PATH/modules/guice-1.2/test
	
### Test

Start play in test mode:

	play test
	
Then go to
 
	http://localhost:9000/@tests

and click "Run all"

<CTRL-C> to stop play server.

### Run 
Start play:

	play run
	
To view the answers to the tests, go to 

	http://localhost:9000/

<CTRL-C> to stop play server.

### Use RESTful API

TBD

## Design Decisions

Although TDD and tests were not mentioned in the requirements, I have written it as a test-driven project.

I have recently been interested by Cory Maksymchuk's talk "3 Patterns for Cleaner Code" - http://www.infoq.com/presentations/3-Patterns-Cleaner-Code.
This describes how separating an algorithm applied to a collection from the loop code can make testing the algorithm much easier. 
Google Guava has implementations that are very similar to those described by Cory, so I decided to try it out for this project.

I am aware that Guava documentation counsels against overusing functional approaches within Java versions before 8 
(see 'Caveats' in http://code.google.com/p/guava-libraries/wiki/FunctionalExplained) but for this code I was placing testability over simplicity.


I've also been wanting to have a look at Joda-Time for quite a long time.

Play framework was chosen because of ease with which the RESTful APIs could be created, and because it easily integrates with 
Guice to allow annotation-driven DI. 
Version 1 was chosen for familiarity and because some users have reported Java to be a 2nd-class citizen within Version 2.
