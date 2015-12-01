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
       script() {
         mkp.yieldUnescaped "console.log('HOLA');"
         mkp.yieldUnescaped "function DeleteTemplateXHR(templateId){"
         mkp.yieldUnescaped "            var objHTTP = new XMLHttpRequest();"
         mkp.yieldUnescaped "            objHTTP.open('DELETE', '/templates/' + templateId);"
         mkp.yieldUnescaped "            objHTTP.setRequestHeader('Content-Type', 'application/json; charset=utf-8');"
         mkp.yieldUnescaped "            objHTTP.send();"
         // mkp.yieldUnescaped "            if(objHTTP.Status != 200){"
         // mkp.yieldUnescaped "                console.log('error');"
         // mkp.yieldUnescaped "            }"
         // mkp.yieldUnescaped "            else{"
         mkp.yieldUnescaped "                location.reload();"
         // mkp.yieldUnescaped "            }"
         mkp.yieldUnescaped "        }"
     }

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
                    a(href:"/templates/${template.id}", class: "glyphicon glyphicon-eye-open") { }

                    span(class: "glyphicon glyphicon-minus", id: "delete-template-${template.id}")        

                    script(){

                        mkp.yieldUnescaped "document.getElementById('delete-template-${template.id}').addEventListener('click', function(){ DeleteTemplateXHR(${template.id}) });"                        
                    }

                    form(method: "DELETE", action: "/templates/${template.id}") {
                       button(type: "submit", class: "glyphicon glyphicon-minus")
                   }
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