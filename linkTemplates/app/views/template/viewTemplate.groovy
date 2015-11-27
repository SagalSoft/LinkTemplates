package views.Template

import model.Template
import java.utils.*

def templateId = params.id as long
def template = Template.get(templateId)
// def templateWhere = Template.findAll({where id == templateId})
// def templateGet = Template.get(params.id as long)
// template = template.value

html.html{
    head {
        title "Add template"
    }

    body(){
        div("class": "container"){
            div(class: "row"){
                h1(class: "span12 page-header"){
                    mkp.yield template.name
                }
            }
            div("class":"row"){
                p { mkp.yield template.description }
                if(template.urlPreview){
                img(src: template.urlPreview)
                }else{
                    p "No hay preview"
                }
            }
            div(class:"row"){
                a(href:"/templates", class: "glyphicon glyphicon-arrow-left")
            }
        }
    }
}