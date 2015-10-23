# business-backednd-api

### This is a Bakend APP for the business Front End API.
***
## Steps Required to set up the application
***
  1. Running App using IDE (eclipse):
      -Open eclipse and import the project as maven project.
      -Setup the Server at 1010 port (or you would have to change the 'base api url' in appConfig of FRONT END Application.
      -Please change the database credentials in core-congig.properties in src/main/resources.
      -You can insert some dummy data for business in database using dataLoader.sql in src/main/resources.
      -insert the value for social.redirect property in properties file as the value of you web domain for front end app (eg.           the one we copied in step 4 of front end application setup.
  2. Using WAR FILE.
      -build a war of project using mvn(maven) from command prompt.
      -place the war file in webapp directory of your Tomcat container.
      -Run your tomcat instance. (Make Sure The BASE_URI for your backend api is correctly mentioned in appConfig.js file of            your front End application.
      -Rest steps are same as for eclipse as far as database configuration and population is concerned.

#### Please see documentation for front end for better integration process.
