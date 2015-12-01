html.html {
    head {
        title "My templates"
        link href: "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css", rel: "stylesheet"
        link href: "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css", rel: "stylesheet"
    }

    body() {
        div("class": "container") {
            div("class": "row") {
                h1("class": "span12 page-header"){
                    mkp.yield "Add User"
                } 

                div("class":"row"){
                    form(method: "post", action: "/login") {
                        div {
                            input(type: "text", name: "name", value: "", placeholder:"Name")
                        }
                        div {
                            textarea(type: "text", rows: 4, name: "description", value: "", placeholder:"Description", class:"form-control")
                        }
                        div {
                            input(type: "submit", class: "glyphicon glyphicon-plus")
                        }
                    }
                } 
            }
        }
    }
}