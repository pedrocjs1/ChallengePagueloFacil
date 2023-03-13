Challenge PagueloFácil

Este es un proyecto de muestra para el challenge PagueloFácil.
Descarga y configuración

Para descargar este repositorio, siga estos pasos:

    Abra una terminal y navegue hasta el directorio donde desea descargar el repositorio.
    Ejecute el siguiente comando:

git clone https://github.com/pedrocjs1/ChallengePagueloFacil.git

Esto descargará el repositorio en su sistema.

    A continuación, desde la raíz del repositorio, ejecute la aplicación con el siguiente comando:

./gradlew bootRun

Nota: Asegúrese de tener instalado Gradle en su sistema.
Uso


Si desea probar la aplicación utilizando Postman, puede hacer lo siguiente:

Crear un usuario

    Método: POST
    URL: http://localhost:8080/api/createClient?firstName=Pepe&lastName=argento&email=pepe@gmail.com&password=123456
    Cuerpo de la solicitud (JSON):


Obtener un usuario

    Método: GET
    URL: http://localhost:8080/api/usuarios/{id}

Sustituya {id} con el ID del usuario que desea obtener.

Loguarse

    Método: GET
    URL: http://localhost:8080/api/login?email=pepe@gmail.com&password=123456

Sustituya el valor de los params con el valor correspondiente a su usuario

Obtenga todos los usuarios para luego hacer una transaccion a otro cliente

    Método: GET
    URL: http://localhost:8080/api/clients

Hacer una transferencia a otra cuenta existente. 

    Método: POST
    URL: http://localhost:8080/api/transactions
    Params: 
    description 
    amount
    originAccountNumber
    targetAccountNumber
    values: 
    "Description"
    100
    {originAccountNumber}
    {targetAccountNumber}
    
