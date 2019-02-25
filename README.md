# Masivian

Prueba de binary Tree

Para Ejecutar la prueba siga los siguentes pasos:

Descargar El projecto e Importarlo en SpringBooot Tool Suite

CLick derecho en Run AS Spring Boot APP

Asegurese que  el puerto 8080 este libre

Desde un Cliente que consume web services por ejemplo SoapUI colocar method POST y cosumir las siguentes urls agregando el body 
 link1
http://localhost:8080/createBinaryTree

Body:
{ "1":[70,84,85],  "2":[70,84,78,80 ] ,
"3":[70,84,78,76], "4":[70,49,54,51], "5":[70,49,37,40],
"6":[70,49,37,22]
}

La primera url retrona el binary tree creado

la siguente url returna el ancesto comun entre dos nodos, no olvidar colocar el Body

link 2
http://localhost:8080/ancestor?number=76,85
