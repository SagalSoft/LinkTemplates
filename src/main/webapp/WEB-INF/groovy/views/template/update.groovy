package views.templates

import model.Template
import services.TemplateService

def templateId = params.id as long
def template = Template.get(templateId)

template.name = params.name
template.lastModifiedDate =  new Date()
template.description =  params.description
template.urlHeader = params.urlHeader
template.urlFooter = params.urlFooter

template = TemplateService.getTemplateService().modifyTemplate template

template.save()

redirect "/templates"