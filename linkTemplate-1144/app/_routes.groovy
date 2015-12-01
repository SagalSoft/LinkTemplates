get "/", forward: "/views/index.groovy"
post "/login", forward: "/views/user/create.groovy"

get "/templates", forward: "/views/template/index.groovy"
post "/templates", forward: "/views/template/add.groovy"

post "/templates/@id", forward: "/views/template/update.groovy?id=@id"
get "/templates/@id", forward: "/views/template/viewTemplate.groovy?id=@id"


get "/templates/edit/@id", forward: "/views/template/editTemplate.groovy?id=@id"
get "/templates/add", forward: "/views/template/addTemplate.groovy"
get "/blob/upload", forward: "/views/template/uploadblob.gtpl"
delete "/templates/@id", forward: "/views/template/deleteTemplate.groovy?id=@id"

get "/blob/success/@key", forward: "/views/template/afterblob.groovy?key=@key"
get "/blob/image/@key", forward: "/views/template/success.groovy?key=@key"