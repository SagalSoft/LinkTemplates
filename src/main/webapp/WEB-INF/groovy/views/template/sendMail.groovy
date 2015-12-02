import model.Template

def templates = Template.count()
def email = "Buenos días, hasta el momento se han creado un total de ${templates} plantillas en la plataforma."

mail.sendToAdmins from: "linktemplate-1144@appspot.gserviceaccount.com", subject: "Reporte semanal", htmlBody: email