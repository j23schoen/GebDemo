/*
This is the Geb configuration file.

        See: http://www.gebish.org/manual/current/configuration.html
*/

//To Run Geb Tests use the dev grails environment:  grails dev test-app -Dgeb.env=chromeLocal functional:

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    baseUrl = "http://localhost:8080/Geb-Demo-0.1/"
    System.setProperty('webdriver.chrome.driver', '//usr/local/chromeDriver/chromedriver')
    new ChromeDriver()
}

//different environments can be set up to use a different baseUrl for a server you want to hit, for example
//the chromeLocal environment will spin up a local host
environments {

    chromeLocal {
        driver = {
            baseUrl = "http://localhost:8080/Geb-Demo-0.1/"
            System.setProperty('webdriver.chrome.driver', '//usr/local/chromeDriver/chromedriver')
            new ChromeDriver()
        }
        //this variable will not close the window after tests have run
        quitCachedDriverOnShutdown = false
    }

    phantomMac {
        driver = {
            baseUrl = "http://localhost:8080/Geb-Demo-0.1/"
            System.setProperty('phantomjs.binary.path', '//usr/local/phantomjs/bin/phantomjs')
            driver = new PhantomJSDriver(new DesiredCapabilities())
            driver
        }
    }
}