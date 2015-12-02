package views.templates

import model.Template
//import java.utils.*

def templateId = params.id as long
def template = Template.get(templateId)

html.html
{

    body()
    {
        div("class": "container")
        {
            div(class: "row")
            {
                h1(class: "span12 page-header")
                {
                    mkp.yield template.name
                }
            }
            div(class:"row", style: "min-height: 80px !important")
            {
                p() 
                {
                    mkp.yield template.description 
                }
                div(class: "panel panel-default") 
                {
                    div(class:"panel-heading", style:"height: 45px !important")
                    {
                        a(href:"/templates/edit/${template.id}", style:"float:right", class:"material-icons") { mkp.yield "edit" }
                        a(href:"/templates", class: "material-icons", style:"float:left") { mkp.yield "keyboard_backspace"}  
                    }
                    div(class:"panel-body", style:"padding:10px; width:100%"){
                        if(template.html)
                        {

                            mkp.yieldUnescaped template.html

                        }
                        else
                        {
                            p "Your template doesn't have anything to show"
                        }
                    }
                }
            }
        }
    }
}