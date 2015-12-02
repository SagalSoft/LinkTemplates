package views.templates

import model.Template
//import java.utils.*

def templateId = params.id as long
def template = Template.get(templateId)

// html.html{
//     head {
//         title "Edit template"
//     }

//     body(){
//         div("class": "container"){
//             div("class":"row"){
//                 form(method: "post", action: "/templates/${templateId}") {
//                     div {
//                         input(type: "text", name: "name", value:template.name)
//                     }
//                     div {
//                         textarea(type: "text", rows: 4, name: "description", value: template.description, class:"form-control"){
//                             mkp.yield template.description
//                         }
//                     }
//                     div{
//                         textarea(type:"text", rows: 2, name:"urlHeader", value: template.urlHeader, class:"form-control"){
//                             mkp.yield template.urlHeader
//                         }
//                     }
//                     div{
//                         textarea(type:"text", rows: 2, name:"urlFooter", value: template.urlFooter, class:"form-control"){
//                             mkp.yield template.urlFooter
//                         }
//                     }
//                     div {
//                         button(type: "submit", class: "glyphicon glyphicon-ok")
//                         a(href:"/templates", class: "glyphicon glyphicon-remove")
//                     }
//                 }
//             }
//         }
//     }
// }

html.html
{
    body()
    {
        div(class:"container")
        {

            form(method: "post", class: "form-horizontal", action: "/templates/${templateId}") 
            {
                legend "Edit Template"
                div(class:"form-group label-floating")
                {
                    label(class:"control-label", for: "focusedInput1") { mkp.yield "Name" }
                    input(type: "text", class:"form-control", id:"focusedInput1", name: "name", value: template?.name){
                        template.name
                    }
                }
                div(class:"form-group label-floating")
                {
                    label(class:"control-label", for: "focusedInput2") { mkp.yield "Description" }
                    textarea(type: "text", class:"form-control", id:"focusedInput2", rows: 4, name: "description", value: template?.description){
                        template.description
                    }
                }
                div(class:"form-group label-floating")
                {
                    label(class:"control-label", for: "focusedInput3") { mkp.yield "Url Header" }
                    textarea(type:"text", class:"form-control", id:"focusedInput3",rows: 10, name:"urlHeader", value:template?.urlHeader){
                        template.urlHeader
                    }
                }
                div(class:"form-group label-floating")
                {
                    label(class:"control-label", for: "focusedInput4") { mkp.yield "Url Footer" }
                    textarea(type:"text", class:"form-control", id:"focusedInput4",rows: 10, name:"urlFooter", value:template?.urlFooter){
                        template.urlFooter
                    }
                }

                a(class: "btn btn-default", href: "/templates") 
                {
                    mkp.yield "Cancel"
                }
                button(type: "submit", class: "btn btn-primary") 
                {
                    mkp.yield "Accept"
                }
            }
        }
    }
}