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
            h2 "Your templates"
            def templates = Template.findAll({ sort desc by creationDate })
             // Closure query = { it.user == currentUser }

             templates = templates.findAll { it.user == currentUser }

             templates.each 
             {
                template ->
                div(class: "panel panel-default") 
                {

                    a(href:"/templates/view/${template.id}", class:"btn btn-default btn-lg btn-block")
                    {
                        div(class:"panel-heading", style:"float:left")
                        {
                            b() { mkp.yield template.name }
                        }
                    }
                    div(class:"panel-body")
                    {
                            p(style: "float:left") {mkp.yield template.description}
                    }
                    div(class:"panel-footer", style:"height:45px !important")
                    {
                        a(href:"/templates/edit/${template.id}", style:"float:right", class:"material-icons") { mkp.yield "edit"
                            // i(class:"material-icons") {mkp.yield "more_edit" }
                        }
                        a(class: "material-icons", style:"float:left", id: "delete-template-${template.id}") { mkp.yield "delete"}        
                        script()
                        {
                            mkp.yieldUnescaped "document.getElementById('delete-template-${template.id}').addEventListener('click', function(){ DeleteTemplateXHR(${template.id}) });"                        
                        }
                    }
                }
            }

            if(templates.size() == 0)
            {
                div("class": "row")
                {
                    h2 "No hay templates"
                }
            }

            a(href:"/templates/add", class: "btn btn-danger btn-fab", style:"bottom:20; right:20; position:absolute;")
            {
                i (class:"material-icons") { mkp.yield "add" }
            }
        }
    }
}