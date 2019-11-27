This repo contains tests for makeMyTrip web application

-This repository contains a hybrid framework designed for the testing of round trip flight booking from https://www.makemytrip.com/

-This framework makes use of Selenium webdriver and is programmed in Java.


#
Machine Set up details to execute tests on your local machine:
--------------------------------------------------------------
Pre-requisites:

1.) Install JDK 8 (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

2.) Set up JAVA_HOME variable with proper path as system variable

3.) Install IntelliJ Community edition (https://www.jetbrains.com/idea/download/)

4.) Install Lombok plug in IntelliJ

6.) Rebuild the project on your machine


Detailed steps for running the test on your LOCAL Machine:
----------------------------------------------------------

1.) To run test from IDE, Right click and run.

2.) To run smoke tests from commandline   
    *LOCAL:
    ```gradle clean SanityTests -DdriverEnvironment=local -Dgroups=SMOKE -Denv=production -Ddriver=chrome```
