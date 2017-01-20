var gebDemo = {

    characters: [],
    init: function() {
        gebDemo.events.init();
    },

    events: {
        init: function () {
            gebDemo.events.registerFindCharactersButton();
            gebDemo.events.registerSelectName();
        },

        registerFindCharactersButton: function () {
            $("#findCharacters").on("click", function () {
                gebDemo.server.getCharactersOfSeinfeld();
            })
        },

        registerAutocomplete: function () {
            $("#searchForName").autocomplete({
                source: gebDemo.characters,
                select: function(event, ui) {
                    gebDemo.server.getInfoOnCharacter(ui.item.value);
                }
            });
        },

        registerSelectName: function () {
            $("#selectName").on('change', function () {
                gebDemo.server.getInfoOnCharacter($(this).find(":selected").text());
            })
        },

        populateListOfCharacters: function (data) {
            gebDemo.characters = [];
            var $selectCharacter = $("#selectName");
            $selectCharacter.empty();
            $selectCharacter.append('<option value="" disabled selected>Select a character...</option>');
            $("#charactersFound").empty();
            $.each(data.character, function(index, val){
                gebDemo.characters.push(val);
                $("#charactersFound").append(
                    '<li id="character'+ index + '">' + val + '</li>'
                );
                gebDemo.events.populateCharacterDropDown($selectCharacter, index, val)
            });
            $("#seinfeldCharacters").show();
            $("#searchByCharacterName").show();
            $("#selectNameDiv").show();
            gebDemo.events.registerAutocomplete();
            waitingDialog.hide();
        },

        populateCharacterDropDown: function ($selectCharacter, index, val) {
            $selectCharacter.append($('<option>', {
                value: index,
                text: val
            }));
        },

        populateCharacterInformation: function (data) {
            $.each(data, function (index, val) {
                $("#characterSelected").text("Real Name: " + val.fullName);
                $("#age").text("Age: " + val.age);
                $("#netWorth").text("Net Worth: " + val.netWorth);
            });
            $("#characterInfoWell").show();
        }
    },

    server: {

        getCharactersOfSeinfeld: function () {
            waitingDialog.show();
            setTimeout(function() {
                $.ajax({
                    url: appContextPath + "/gebDemo/getCharactersOnSeinfeld",
                    type: "GET",
                    success: gebDemo.events.populateListOfCharacters
                })
            }, 3000);
        },

        getInfoOnCharacter: function(characterName) {
            $.ajax({
                url: appContextPath + "/gebDemo/getCharacterInfo",
                data: { character: characterName},
                success: gebDemo.events.populateCharacterInformation
            })
        }
    }

};