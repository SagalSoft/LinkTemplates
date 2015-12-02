package services

import model.Template

class TemplateService
{
	private static templateService 

	private TemplateService()
	{

	}

	def generateTemplate(Template template)
	{

		def generalTemplate = '''
	<div style="width: 900px; color: #444444; font-family: Arial; font-size: 0;">
	<!--IMG HEADER-->
	<div style="width: 100%; margin-bottom:5%;">
		<img id="header-image" src="''' + template.urlHeader  + '''" style="margin: 0; width:100%;" alt="Selecciona la imagen del header"> 
	</div>

	<!--IMG ARTICULO -->
	<div style="width: 100%;">
		<img id="article-image" src="" style="margin: 30px auto 20px auto; max-width: 918px; height: auto;" alt="aqui irá la imagen de tu artículo">
		<p>This is the placeholder for your article image</p>
	</div>

	<!--IMG TITULO CARACTERISTICAS -->
	<div style="width: 100%; ">
		<img id="title-image" src="" style="margin: 0; width: 100%;" alt="Selecciona la imagen de fondo del título">
		<p>This is the placeholder for background image</p>
	</div>

	<!-- TITULO ARTICULO -->
	<div style="width: 100%;">
		<div style="margin-left: 20%;margin-right: 20%;width: 60%;background: #E7E7E7;">
			<p id="title-article-text" style = "color:black; width: 100%;font-size: 30px;font-weight: bold;text-align: center;padding-top: 5%;padding-bottom: 5%;margin: 0;">
			Tu título aquí
			</p>
		</div>
	</div>

	<!-- DESCRIPCION ARTICULO -->
	<div id="article-description-container">
		<div style="width: 100%; height:auto;">
			<p style = "color:black; font-size: 25px;">
			Tu descripción aquí
			</p>
		</div>
	</div>

	<!-- IMG GENERAL -->
	<div style="width: 100%;">
		<img id="general-image" src="''' + template.urlFooter  + '''" style="margin: 0;" alt="Selecciona la imagen general">
	</div>
</div>
'''	
	template.html = generalTemplate	
	template
	}

	def addTemplate(Template template)
	{
		template = generateTemplate template
		template.save()
		template
		//en el html, insertar la imagen en el header
	}

	def modifyTemplate(Template template)
	{
		template = generateTemplate template
		template.save()
		template
	}

	static def getTemplateService() 
	{	
		if (!templateService)
		{
			templateService = new TemplateService()
		}

		return templateService
	}
}