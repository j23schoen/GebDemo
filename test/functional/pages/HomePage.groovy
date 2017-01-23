package pages

import geb.Page

class HomePage extends Page {

    static url

    static at = {
        header.text() == "Geb Demo"
    }

    static content = {
        header { $("h1")}
        linkToSeinfeld(to: GebDemoPage) { $("div#seinfeldLink").children("a")}
    }

}
