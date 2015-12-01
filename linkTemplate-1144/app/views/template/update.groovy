package views.templates

import model.Template

def templateId = params.id as long
def template = Template.get(templateId)

template.name = params.name
template.lastModifiedDate =  new Date()
template.description =  params.description
template.html = params.html

template.save()

redirect "/templates"