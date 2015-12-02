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
        out.print(user.toString());
        url = userService.createLogoutURL requestUri
        logged=true;
      }
      else{
        logged=false;

        url = userService.createLoginURL requestUri
      }
      %>
    <%
      if(logged){
        %>
      <label>User: <%=user.toString() %></label>
    <%
      }
    %>
    <a href="<%=url %>">Sign <% if(logged){out.print("Out");}else{out.print("In");} %></a>
  </body>
</html>