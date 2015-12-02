html.html
{
    body()
    {
        div(class:"container")
        {

            form(method: "post", class: "form-horizontal", action: "/templates") 
            {
                legend "Add Template"
                div(class:"form-group label-floating is-empty")
                {
                    label(class:"control-label", for: "focusedInput1") { mkp.yield "Name" }
                    input(type: "text", class:"form-control", id:"focusedInput1", name: "name", value: "")
                }
                div(class:"form-group label-floating is-empty")
                {
                    label(class:"control-label", for: "focusedInput2") { mkp.yield "Description" }
                    textarea(type: "text", class:"form-control", id:"focusedInput2", rows: 4, name: "description", value: "")
                }
                div(class:"form-group label-floating is-empty")
                {
                    label(class:"control-label", for: "focusedInput3") { mkp.yield "Url Header" }
                    textarea(type:"text", class:"form-control", id:"focusedInput3",rows: 10, name:"urlHeader", value:"")
                }
                div(class:"form-group label-floating is-empty")
                {
                    label(class:"control-label", for: "focusedInput4") { mkp.yield "Url Footer" }
                    textarea(type:"text", class:"form-control", id:"focusedInput4",rows: 10, name:"urlFooter", value:"")
                }

                a(class: "btn btn-default", href: "/templates") 
                {
                    mkp.yield "Cancel"
                }
                button(type: "submit", class: "btn btn-primary") 
                {
                    mkp.yield "Accept"
                }
            }
        }
    }
}