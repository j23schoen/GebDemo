package pages

import geb.Page

class FormPage extends Page {

    static url

    static at = {
        header.text() == "Form Completion"
    }

    static content = {
        header { $("h1")}
        form { $("form")}
        submissionMessage { $("h3#success")}
        submitButton { $("button#submit")}
    }

}
