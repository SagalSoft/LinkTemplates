package views.Template

import model.Template
import groovyx.gaelyk.logging.GroovyLogger

def log = new GroovyLogger("myLogger")
log.info "This is a logging message with level INFO"

def templateId = params.id as long
def template = Template.get(templateId)
template.delete()

forward '/templates'
