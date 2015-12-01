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




redirect "/templates"