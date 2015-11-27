package views.Template

import model.Template
import java.utils.*

def titleText = "My templates"

html.html {
    head {
        title "My templates"
        link href: "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css", rel: "stylesheet"
        link href: "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css", rel: "stylesheet"
    }

    body() {
        div("class": "container") {
            div("class": "row") {
                h1("class": "span12 page-header"){
                        mkp.yield "My Templates"
                    } 

                //Obtener todas las plantillas
                def templates = Template.findAll({sort desc by creationDate}).each { template ->
                    div("class": "row") {
                        h3 "Title: " + template.name
                        h4 "ID: " + template.id 
                        h4 "Description: " + template.description
                        a(href:"/templates/${template.id}", class: "glyphicon glyphicon-eye-open")
                    }
                }

                if(Template.count() == 0){

                    div("class": "row"){
                        h2 "No hay templates"
                    }

                }

                a(href:"/templates/addtemplate", class: "glyphicon glyphicon-plus")
            } 
        }
    }
}