# SMS-Challenge

![Under Construction Application](http://old.sesame.org.jo/sesame/images/M_images/page_is_under_construction.jpg
)

# Mutantes

  La aplicación consta de una Api Rest que permitirá distinguir entre Adn mutante y Adn mumano,
  basandonos en la siguiente regla:
* Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales,
  de forma oblicua, horizontal o vertical.
  Para una mayor comprensión tomemos en cuenta los siguientes ejemplos:


  A T G C G A 
  
  C A G T G C 
              
  T T A T T T 
              
  A G A C G G 
              
  G C G T C A 
              
  T C A C T G          
   No-Mutante          


  A T G C G A 
  
  C A G T G C 
              
  T T A T G T 
              
  A G A A G G 
              
  C C C C T A 
              
  T C A C T G 
   
   Mutante
    
  
  Ejemplo (Caso mutante):     String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
  
## Requisitos para ejecutar la aplicación

*   Compilar y Ejecutar el proyecto: Java JDK 1.8
*   Gestión de Dependencias: Maven

## Tecnologías involucradas

* Java
* Maven
* Spring Data JPA
* Spring Boot
* Hibernate
* H2 DataBase
* Swagger


## Autor

*     Juan Pereira 
