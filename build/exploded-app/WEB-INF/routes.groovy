// 
get "/", forward: "/WEB-INF/groovy/views/login/login.gtpl"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "/", forward: "/WEB-INF/groovy/views/index.groovy"
post "/login", forward: "/WEB-INF/groovy/views/user/create.groovy"

get "/templates", forward: "/WEB-INF/groovy/views/template/index.groovy"
post "/templates", forward: "/WEB-INF/groovy/views/template/add.groovy"

post "/templates/@id", forward: "/WEB-INF/groovy/views/template/update.groovy?id=@id"
get "/templates/view/@id", forward: "/WEB-INF/groovy/views/template/viewTemplate.groovy?id=@id"
get "/templates/edit/@id", forward: "/WEB-INF/groovy/views/template/editTemplate.groovy?id=@id"

get "/templates/add", forward: "/WEB-INF/groovy/views/template/addTemplate.groovy"

get "/blob/upload", forward: "/WEB-INF/groovy/views/template/uploadimage.groovy"
delete "/templates/@id", forward: "/WEB-INF/groovy/views/template/deleteTemplate.groovy?id=@id"

get "/blob/success/@key", forward: "/WEB-INF/groovy/views/template/afterblob.groovy?key=@key"
get "/blob/image/@key", forward: "/views/template/success.groovy?key=@key"

get "/sendmail",  forward: "/WEB-INF/groovy/views/template/sendMail.groovy"

get "/login", forward: "/WEB-INF/groovy/views/login/login.gtpl"