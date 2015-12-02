import com.google.appengine.api.users.User
import com.google.appengine.api.users.UserService
import com.google.appengine.api.users.UserServiceFactory
import java.util.List

html.html {
  head(){
    title { 
      mkp.yield ("Link Templates") 
      mkp.yieldUnescaped "<sitemesh:write property='title'/>"
    }
    link (rel:"stylesheet", type:"text/css", href:"/css/bootstrap.min.css")
    link (rel:"stylesheet", type:"text/css", href:"/css/bootstrap-material-design.min.css")
    link (rel:"stylesheet", type:"text/css", href:"/css/ripples.min.css")
    script (type:"text/javascript", src:"/js/jquery-1.11.0.js")
    script (type:"text/javascript", src:"/js/bootstrap.min.js")
    script (type:"text/javascript", src:"/js/material.min.js")
    script (type:"text/javascript", src:"/js/ripples.min.js")

    mkp.yieldUnescaped "<sitemesh:write property='head'/>"

    script (type:"text/javascript") {
      mkp.yieldUnescaped( "\$.material.init();")
    }
  }
  body(){
    header{
      div (class:"container"){
        h1 "Plantillas Link"
      }
    }
    hr 

    mkp.yieldUnescaped "<sitemesh:write property='body'/>"
  }
}
