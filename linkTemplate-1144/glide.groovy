
app {
    name="linktemplate-1144"
    version="1"
}
web {
    security = [
            'admin': ["/views/user/*"]
    ]
}

layout {
    mappings = [
            "/*": "/views/_Layout.html"
    ]
}
