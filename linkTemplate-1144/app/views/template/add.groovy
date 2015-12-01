package views.templates

import model.Template

new Template(
	 name : params.name,
	 creationDate : new Date(),
	 lastModifiedDate : new Date(),
	 description : params.description,
	 html: params.html,
	 user: users.currentUser
	).save()


mail.send from: "aletocar@gmail.com",
	to: "simonmacadar@gmail.com",
	subject: "Gaelyk no es tan malo como parece",
	htmlBody: params.html


redirect "/templates"