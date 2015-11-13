
app {
    name="linkTemplates"
    version="1"
}
web {
    security = [
            'admin': ["/views/user/*"]
    ]
}

layout {
    mappings = [
            "/*": "/views/_layout.html"
    ]
}
