# GebDemo

This is a Grails app to aid in the learning of functional testing using Geb. All the dependencies and plugins are set up in the BuildConfig.groovy.

There is also a Geb Presentation powerpoint in this repository to walk you through set up and basic Geb functionality.

Important note: be sure to download the [chrome webdriver](https://chromedriver.storage.googleapis.com/index.html?path=2.27/) to be able to run the functional tests in the app. You may need to change the path to your webdriver in the GebConfig.groovy class.

Command for running all functional tests with default configurations:
<code>grails dev test-app functional:</code>

To specify grails environments:
<code>grails dev test-app -Dgrails.env=backupDB functional:</code>

To specify a geb environment in the GebConfig.groovy class:
<code>grails dev test-app -Dgeb.env=chrome functional:</code>

To specify a certain spec file:
<code>grails dev test-app functional: GebDemoSpec</code>
