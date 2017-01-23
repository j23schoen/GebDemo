package spec

import geb.spock.GebSpec
import pages.FormPage
import pages.GebDemoPage
import pages.HomePage
import spock.lang.IgnoreRest

class GebDemoSpec extends GebSpec {

    def "test navigation to the geb demo page" () {
        given: "I'm at the home page"
        to HomePage
        when: "I click the Seinfeld link"
        linkToSeinfeld.click()
        then: "I'm at the Seinfeld Demo Page"
    }

    def "test that the character name fields are populated after clicking go"() {
        given: "I'm at the geb demo page"
        to GebDemoPage
        when: "I click the go button"
        clickGo()
        then: "The character fields are populated"
        jerrySeinfeld.text() == "Jerry Seinfeld"
        kramer.text() == "Kramer"
        georgeCostanza.text() == "George Costanza"
        elaineBenes.text() == "Elaine Benes"
        newman.text() == "Newman"
    }

    def "test that typing a selecting a character from the search field will populate a little blurb about them" () {
        given: "I'm at the geb demo page"
        to GebDemoPage
        when: "I click the go button"
        clickGo()
        and: "I type 'n' in the search field"
        searchField.text = "n"
        and: "I select 'Newman'"
        waitFor{
            autocompleteModule.autocompleteWidget.displayed
        }
        autocompleteModule.autocompleteResults.children("div").find{it.text() == "Newman"}.click()
        waitFor {
            netWorthOfCharacter.displayed
        }
        then: "A little blurb about newman is populated"
        characterSelected.text() == "Real Name: Wayne Knight"
        ageOfCharacter.text() == "Age: 61"
        netWorthOfCharacter.text() == "Net Worth: \$8 million"
    }

    def "test that selecting a character from the drop down populates their information correctly" () {
        given: "I'm at the geb demo page"
        to GebDemoPage
        when: "I click the go button"
        clickGo()
        and: "I select Jerry Seinfeld from the drop down"
        selectCharacterName.selected = "Jerry Seinfeld"
        then: "A little blurb about Jerry is populated"
        characterSelected.text() == "Real Name: Jerry Seinfeld"
        ageOfCharacter.text() == "Age: 62"
        netWorthOfCharacter.text() == "Net Worth: \$800 million"
    }

    def "test I can navigate to the form page" () {
        given: "I'm at the home page"
        to HomePage
        when: "I click the link to go to the form page"
        linkToForm.click()
        then: "I'm at the form page"
    }

    def "test that I can fill out form fields and submit the form" () {
        given: "I am at the form page"
        to FormPage
        when: "I fill out the form fields"
        form.firstName = "Justin"
        form.lastName = "Schoen"
        form.age = 23
        form.favoriteLanguage = "Groovy"
        and: "I click submit"
        submitButton.click()
        waitFor {
            submissionMessage.displayed
        }
        then: "A message will say the form is submitted"
        submissionMessage.text() == "Form Submitted"
    }

}
