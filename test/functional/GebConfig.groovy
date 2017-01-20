/*
This is the Geb configuration file.

        See: http://www.gebish.org/manual/current/configuration.html
*/

//To Run Geb Tests use the dev grails environment:  grails dev test-app functional:

import org.openqa.selenium.chrome.ChromeDriver

driver = {

}

environments {

    chromeLocal {
        driver = {
            System.setProperty('webdriver.chrome.driver', 'C:\\drivers\\chromedriver.exe')
            new ChromeDriver()
        }
        quitCachedDriverOnShutdown = false
    }
}