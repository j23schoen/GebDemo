package pages

import geb.Page
import geb.module.Select
import geb.module.TextInput
import modules.AutocompleteWidgetModule

class GebDemoPage extends Page {

    static url

    static at = {
        header.text() == "Welcome to Geb - Seinfeld Example"
    }

    static content = {
        header { $("h1")}
        findCharactersButton { $("button#findCharacters")}
        jerrySeinfeld { $("li", id: "character0") }
        kramer { $("ul#charactersFound").children("li#character1") }
        georgeCostanza { $("li#character2") }
        elaineBenes { $("#character3") }
        newman { $("#character4") }
        searchField { $("#searchForName").module(TextInput)}
        autocompleteModule { module AutocompleteWidgetModule}
        characterSelected { $("h5#characterSelected") }
        ageOfCharacter { $("h5", id: "age")}
        netWorthOfCharacter { $("h5#netWorth")}
        selectCharacterName { $("#selectName").module(Select)}
    }

    def clickGo() {
        findCharactersButton.click()
        waitFor {
            $("#waitingDialog").displayed
        }
        waitFor {
            !$("#waitingDialog").displayed
        }
    }

}