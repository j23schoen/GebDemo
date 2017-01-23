package spec

import geb.spock.GebSpec
import pages.GebDemoPage
import pages.HomePage

class GebDemoSpec extends GebSpec {

    def setupSpec() {
        GebDemoPage.url = "${baseUrl}gebDemo/seinfeld"
    }

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

}
