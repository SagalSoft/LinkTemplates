package views.user

def client_id = "28003527889-su4h0gonkc4trc87v77mr09s9pui8t4s.apps.googleusercontent.com"
def redirect_uri = "http://tempates.sagalsolutions.com/redirect"
// def url = new URL('https://accounts.google.com/o/oauth2/auth?client_id=1${clientId}&response_type=code&scope=openid%20email&redirect_uri=${redirectURI}&state=ajkfd2&login_hint=nohint')
redirect "https://accounts.google.com/o/oauth2/auth?client_id=1${client_id}&response_type=code&scope=openid%20email&redirect_uri=${redirect_uri}&state=ajkfd2&login_hint=nohint"


