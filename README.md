# QE
Prueba Técnica 

Automatización 

Se realizó automatización del website “https://demoqa.com/webtables” usando el patrón de diseño Page Object Model. De las funcionalidades Agregar, Editar y Elminar. 

1. Prueba agregar usuario: Se agregan datos válidos al formulario de registro y se realiza validación de que el registro se haya creado y cargado de forma correcta. 

2. Prueba editar registro : Se toma un registro, de un usuario ya existente, se borra la información se sus campos y se agregan nuevos. Se realiza validación de que se haya modificado el registro con los datos nuevos. 

3. Prueba eliminar registro: Se toma un registro existente, se elimina y se valida que no se encuentre en la tabla. 

Las tecnologías usadas fueron, Selenium, Java 11, TestNG, Maven, IDE IntelliJ Idea. 

Para ejecutar, descargar proyecto de Github
Abrir terminal, con la ruta al proyecto descargado ya descomprimido 
Ejecutar con “mvn test”

Ejemplo: 

C:\Users\conta\IdeaProjects\DemoQA> mvn test 

 ———————— 

Otra forma,  Abrir proyecto en un IDE puede ser IntelliJ Idea o Eclipse 
Y en terminal ejecutar “mvn test”

Nota: Ya se debe tener instado y configurado variables de entorno de Java y Maven. 

