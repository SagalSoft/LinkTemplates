package views.templates
import com.google.appengine.api.users.User
import com.google.appengine.api.users.UserService
import com.google.appengine.api.users.UserServiceFactory 
//import java.utils.*

import model.Template

UserService userService = UserServiceFactory.getUserService();
User currentUser = userService.getCurrentUser();

html.html 
{
    head 
    {
        title "My templates"
    }

    body() 
    {
        //d
        script() 
        {
            mkp.yieldUnescaped "function DeleteTemplateXHR(templateId){"
            mkp.yieldUnescaped "     var objHTTP = new XMLHttpRequest();"
            mkp.yieldUnescaped "     objHTTP.open('DELETE', '/templates/' + templateId);"
            mkp.yieldUnescaped "     objHTTP.setRequestHeader('Content-Type', 'application/json; charset=utf-8');"
            mkp.yieldUnescaped "     objHTTP.send();"
            mkp.yieldUnescaped "     location.reload();"
            mkp.yieldUnescaped "}"
        }

        div("class": "container") 
        {
            div("class": "row") 
            {

                h1("class": "span12 page-header")
                {
                    mkp.yield "My Templates"
                } 

                def templates = Template.findAll({ select all from templates sort desc by creationDate }).each 
                { template ->
                    //d
                    if(template.user == currentUser)
                    {
                        div("class": "row") 
                        {
                            h3 "Title: " + template.name
                            h4 "ID: " + template.id 
                            h4 "Description: " + template.description
                            a(href:"/templates/view/${template.id}", class: "glyphicon glyphicon-eye-open")
                            span(class: "glyphicon glyphicon-minus", id: "delete-template-${template.id}")        
                            script()
                            {
                                mkp.yieldUnescaped "document.getElementById('delete-template-${template.id}').addEventListener('click', function(){ DeleteTemplateXHR(${template.id}) });"                        
                            }
                        }
                    }
                }

                if(Template.count() == 0)
                {

                    div("class": "row")
                    {
                        h2 "No hay templates"
                    }
                }

                a(href:"/templates/add", class: "btn btn-primary btn-fab"){
                    i (class:"material-icons") { mkp.yield "add" }
                }
            } 
        }
    }
}