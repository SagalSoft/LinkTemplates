package views.templates

import model.Template
//import java.utils.*

def templateId = params.id as long
def template = Template.get(templateId)

html.html
{
    body()
    {
        div(class:"container")
        {
            //
            div(class: "panel panel-default") 
            {
                div(class: "panel-heading")
                {
                    b() { mkp.yield "Edit Template" }
                }

                div(class:"panel-body")
                {
                    form(method: "post", class: "form-horizontal", style:"padding:10px", action: "/templates/${templateId}") 
                    {
                        div(class:getClass(template.name))
                        {
                            label(class:"control-label", for: "focusedInput1") { mkp.yield "Name" }
                            input(type: "text", class:"form-control", id:"focusedInput1", name: "name", value: getValue(template.name))
                        }
                        div(class:getClass(template.description))
                        {
                            label(class:"control-label", for: "focusedInput2") { mkp.yield "Description" }
                            textarea(type: "text", class:"form-control", id:"focusedInput2", rows: 4, name: "description", value: getValue(template.description))
                            {
                                mkp.yield getValue(template.description)
                            }
                        }
                        div(class:getClass(template.urlHeader))
                        {
                            label(class:"control-label", for: "focusedInput3") { mkp.yield "Url Header" }
                            textarea(type:"text", class:"form-control", id:"focusedInput3",rows: 10, name:"urlHeader", value:getValue(template.urlHeader))
                            {
                                mkp.yield  getValue(template.urlHeader)
                            }
                        }

                        div(class:getClass(template.urlFooter))
                        {
                            label(class:"control-label", for: "focusedInput4") { mkp.yield "Url Footer" }
                            textarea(type:"text", class:"form-control", id:"focusedInput4",rows: 10, name:"urlFooter", value:getValue(template.urlFooter))
                            {
                                mkp.yield  getValue(template.urlFooter)
                            }
                        }

                    }

                    a(class: "btn btn-default", href: "/templates") 
                    {
                        mkp.yield "cancel"
                    }
                    button(type: "submit", class: "btn btn-primary") 
                    {
                        mkp.yield "Accept"
                    }
                }
            }
        }
    }
}

def getClass(variable)
{
    if(variable == null || variable == "")
    {
        return "form-group label-floating is-empty"
    }
    else{
        return "form-group label-floating"
    }
}

def getValue(variable)
{
    if(variable == null)
    {
        return ""
    }
    else{
        return variable
    }
}