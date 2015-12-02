def blobkey = params.key

html.html{
    head {
        title "Edit template"
    }

    body(){
        div("class": "container"){
            img(src:"/blob/success/${blobkey}")
        }
    }
}