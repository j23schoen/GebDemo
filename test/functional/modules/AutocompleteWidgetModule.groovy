package modules

import geb.Module

class AutocompleteWidgetModule extends Module {

    static content = {
        autocompleteWidget { $(".ui-autocomplete")}
        autocompleteResults { autocompleteWidget.children("li.ui-menu-item")}
    }

}
