package views.templates

import model.Template
import services.TemplateService
import com.google.appengine.api.users.User
import com.google.appengine.api.users.UserService
import com.google.appengine.api.users.UserServiceFactory

def template = new Template(
	 name : params.name,
	 creationDate : new Date(),
	 lastModifiedDate : new Date(),
	 description : params.description,
	 html: params.html,
	 urlHeader: params.urlHeader,
	 urlFooter: params.urlFooter,
	 user: UserServiceFactory.getUserService().getCurrentUser()
	)

template = TemplateService.getTemplateService().addTemplate(template)

mail.send from: "aletocar@gmail.com",
	to: template.user,
	subject: "Se creo el template ${template.name}",
	htmlBody: template.html


redirect "/templates"