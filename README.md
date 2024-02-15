ENDPOINTS:

#Para crear un usuario ejemplo 

POST: http://localhost:8080/auth
  {
      "email": "prueba@mail.com",
      "nombre": "Prueba",
      "nombreUsuario": "prueba123",
      "password": "12345"
  }

#Para crear un admin ejemplo
POST: http://localhost:8080/auth
  {
      "email": "admin@mail.com",
      "nombre": "SoyAdmin",
      "nombreUsuario": "admin123",
      "password": "12345",
      "roles": ["admin"]
  }

#Para logearse ejemplo, y retornara un token con el cual se debera usar para realizar las siguientes consultas
POST: http://localhost:8080/auth/login
  {
      "nombreUsuario": "admin123",
      "password": "12345"
  }
  #Regresara un token asi por ejemplo
  {
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEyMyIsInJvbGVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwiaWF0IjoxNzA3OTU4NDA4LCJleHAiOjE3MDc5NTg0Mjh9.lmQJ1k9HYc1IBD7P0sOJdqY0cc4Nmkr3dVVJBtPsUcwbxFOlef2iSNIDXZ3UkkTdhVypyRKXWMHsIYNHwfH21g"
  }

#En adelante se debe usar el token sino no se realizaran las peticiones, el mismo expirara pasado un tiempo y se tendra que volver a hacer el login para que funcione

#Buscar clima de una ciudad ejemplo siendo usuario
GET: http://localhost:8080/weather/NOMBRECIUDAD
GET: http://localhost:8080/weather/Mendoza

#Buscar pronostico de 5 dias cada 3 horas de una ciudad ejemplo siendo usuario
GET: http://localhost:8080/weather/forecast/NOMBRECIUDAD
GET: http://localhost:8080/weather/forecast/Mendoza

#Buscar contaminacion de aire de una ciudad ejemplo siendo usuario
GET: http://localhost:8080/weather/air-pollution/NOMBRECIUDAD
GET: http://localhost:8080/weather/air-pollution/Mendoza

#Buscar clima de una ciudad ejemplo siendo admin
GET: http://localhost:8080/admin/NOMBRECIUDAD
GET: http://localhost:8080/admin/Mendoza

#Buscar pronostico de 5 dias cada 3 horas de una ciudad ejemplo siendo admin
GET: http://localhost:8080/admin/forecast/NOMBRECIUDAD
GET: http://localhost:8080/admin/forecast/Mendoza

#Buscar contaminacion de aire de una ciudad ejemplo siendo admin
GET: http://localhost:8080/admin/air-pollution/NOMBRECIUDAD
GET: http://localhost:8080/admin/air-pollution/Mendoza

#Ver las consultas hechas por el usuario o admin que inicio sesion
GET: http://localhost:8080/consulta










  
