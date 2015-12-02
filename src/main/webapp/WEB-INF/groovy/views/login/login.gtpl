<% import com.google.appengine.api.users.User %>
<% import com.google.appengine.api.users.UserService %>
<% import com.google.appengine.api.users.UserServiceFactory %>
<% import java.util.List %>
<html>
  <head>
    <title>LOGIN</title>
  </head>
  <body>
  <%
      UserService userService = UserServiceFactory.getUserService();
      User user = userService.getCurrentUser();
      def requestUri = "/templates"
      String url;
      boolean logged;
      def requestURI = "/login"
      if (user != null) {
        // pageContext.setAttribute("user", user);
        url = userService.createLogoutURL requestUri
        logged=true;
      }
      else{
        logged=false;

        url = userService.createLoginURL requestUri
      }
      %>
      <div class="jumbotron">
  <h1>Welcome to LinkTemplates</h1>

  <p>We are commited to making your life easier, creating templates for your e commerce publications.</p>

  <p>
<% if(user == null){ %>
  <a href="<%=url %>" class="btn btn-raised btn-inverse btn-lg">Log in with Google</a></p>
<%
}
else
{
  %>
  <a href="/templates" class="btn btn-raised btn-inverse btn-lg">Go see your templates!</a></p>
  <%
}
%>
</div>
   
  </body>
</html>