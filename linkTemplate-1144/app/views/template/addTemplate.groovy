
html.html{
    head {
        title "Add template"
    }
    body(){
        div("class": "container"){
            div(class: "row"){
                h1(class: "span12 page-header"){
                    mkp.yield "Add templates"
                }
            }
            div("class":"row"){
                form(method: "post", action: "/templates") {
                    div {
                        input(type: "text", name: "name", value: "", placeholder:"Name")
                    }
                    div {
                        textarea(type: "text", rows: 4, name: "description", value: "", placeholder:"Description", class:"form-control")
                    }
                    div{
                        textarea(type:"text", rows: 10, name:"html", value:"", placeholder:"html", class:"form-control")
                    }
                    div {
                        button(type: "submit", class: "glyphicon glyphicon-plus")
                    }
                }
            }
        }
    }
}