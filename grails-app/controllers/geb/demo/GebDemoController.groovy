package geb.demo

import grails.converters.JSON

class GebDemoController {

    def index() { }

    def seinfeld() {}

    def getCharactersOnSeinfeld() {
        def listOfCharacters = []
        listOfCharacters.push('Jerry Seinfeld')
        listOfCharacters.push('Kramer')
        listOfCharacters.push('George Costanza')
        listOfCharacters.push('Elaine Benes')
        listOfCharacters.push('Newman')
        def map = [
                character: listOfCharacters
        ]
        render map as JSON
    }

    def getCharacterInfo(String character) {
        def map
        if(character == "Jerry Seinfeld"){
            map = [
                    fullName: "Jerry Seinfeld",
                    age: "62",
                    netWorth: "\$800 million"
            ]
        } else if(character == "Kramer") {
            map = [
                    fullName: "Michael Richards",
                    age: "67",
                    netWorth: "\$45 million"
            ]
        } else if(character == "George Costanza") {
            map = [
                    fullName: "Jason Alexander",
                    age: "57",
                    netWorth: "\$50 million"
            ]
        } else if(character == "Elaine Benes") {
            map = [
                    fullName: "Julia Louis-Dreyfus",
                    age: "56",
                    netWorth: "\$200 million"
            ]
        } else if(character == "Newman"){
            map = [
                    fullName: "Wayne Knight",
                    age: "61",
                    netWorth: "\$8 million"
            ]
        }
        def fullInformation = [
                "${character}": map
        ]
        render fullInformation as JSON
    }
}
