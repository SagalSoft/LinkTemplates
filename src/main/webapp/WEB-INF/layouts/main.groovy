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
    link (href:"https://fonts.googleapis.com/icon?family=Material+Icons", rel:"stylesheet")
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
      div (class:"navbar navbar-inverse")
      {
        div (class:"container-fluid")
        {
          div (class:"navbar-header")
          {
            //h1 "Link Templates"

            UserService userService = UserServiceFactory.getUserService()
            User user = userService.getCurrentUser()

            ul(class:"nav navbar-nav")
            {
              li(){
                a(href:"/", class:"active")
                {
                  mkp.yield "Link Templates"
                }
              }
              if(user)
              {
                li()
                {
                  //
                  a(href:"/templates") 
                  {
                    mkp.yield "Templates"
                  }
                }

                li()
                {
                  def url = userService.createLogoutURL "/"
                  //
                  a(href:url) 
                  {
                    mkp.yield "Log out"
                  }
                }
              }
            }
          }
        }
      }
    }
    mkp.yieldUnescaped "<sitemesh:write property='body'/>"
  }
}
