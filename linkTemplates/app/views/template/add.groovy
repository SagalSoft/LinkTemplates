package views.Template

import model.Template
new Template(
	 name : params.name,
	 creationDate : new Date(),
	 lastModifiedDate : new Date(),
	 description : params.description,
	 user: users.currentUser
	).save()

redirect "/templates"