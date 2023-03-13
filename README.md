Challenge PagueloFácil

Este es un proyecto de muestra para el challenge PagueloFácil.
Descarga y configuración

Para descargar este repositorio, siga estos pasos:

    Abra una terminal y navegue hasta el directorio donde desea descargar el repositorio.
    Ejecute el siguiente comando:

bash

git clone https://github.com/pedrocjs1/ChallengePagueloFacil.git

Esto descargará el repositorio en su sistema.

    A continuación, desde la raíz del repositorio, ejecute la aplicación con el siguiente comando:

bash

./gradlew bootRun

Nota: Asegúrese de tener instalado Gradle en su sistema.
Uso

Una vez que la aplicación esté en funcionamiento, puede interactuar con ella a través de su navegador web en http://localhost:8080. Siga las instrucciones en la página para interactuar con la aplicación.

Además, si desea probar la aplicación utilizando Postman, puede hacer lo siguiente:
Crear un usuario

    Método: POST
    URL: http://localhost:8080/api/usuarios
    Cuerpo de la solicitud (JSON):

perl

{
  "nombre": "John",
  "apellido": "Doe",
  "correo": "johndoe@example.com",
  "telefono": "555-1234"
}

Obtener un usuario

    Método: GET
    URL: http://localhost:8080/api/usuarios/{id}

Sustituya {id} con el ID del usuario que desea obtener.
Actualizar un usuario

    Método: PUT
    URL: http://localhost:8080/api/usuarios/{id}
    Cuerpo de la solicitud (JSON):
