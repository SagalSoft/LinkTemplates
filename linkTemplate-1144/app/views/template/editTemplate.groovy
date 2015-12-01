package views.templates

import model.Template
import java.utils.*

def templateId = params.id as long
def template = Template.get(templateId)

html.html{
    head {
        title "Edit template"
    }

    body(){
        div("class": "container"){
            div("class":"row"){
                form(method: "post", action: "/templates/${templateId}") {
                    div {
                        input(type: "text", name: "name", value:template.name)
                    }
                    div {
                        textarea(type: "text", rows: 4, name: "description", value: template.description, class:"form-control"){
                            mkp.yield template.description
                        }
                    }
                    div{
                        textarea(type:"text", rows: 10, name:"html", value: template.html, class:"form-control"){
                            mkp.yield template.html
                        }
                    }
                    div {
                        button(type: "submit", class: "glyphicon glyphicon-ok")
                        a(href:"/templates", class: "glyphicon glyphicon-remove")
                    }
                }
            }
        }
    }
}