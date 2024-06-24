# API_Libros
## Consumo de API de libros con SpringBoot - Challenge Alura

Este proyecto es una aplicación de consola en Java, utilizando el framework Spring Boot y la base de datos PostgreSQL, para el Challenge de Alura de la ruta Backend. Permite realizar una consulta a una API que genera información de libros existentes, para extraer información en una búsqueda por libros y guardar en la base de datos información de libros y autores.

## Estructura del Proyecto

El proyecto está compuesto por dos clases principales: **Libros** y **Autores**, siendo estas dos clases de Java y entidades en la base de datos.

El propósito de este proyecto es, a través de un menú para el usuario, poder buscar un libro escribiendo el título a través de la API, devolviendo el resultado en un objeto de tipo **Libro**, para después guardar estas consultas en una base de datos donde guardaremos:

Para **Libro**:
- Título
- Idiomas
- Número de descargas
- Autor

Para **Autor**:
- Nombre
- Fecha de nacimiento
- Fecha de fallecimiento
- Libros del autor

## Funcionamiento del Programa


    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:

Nos pedirá ingresar una de las opciones en pantalla, de las cuales cada una de ellas realiza lo siguiente:

1. **Buscar libro por título**
Ejecuta una función que, primeramente, solicita al usuario escribir el nombre del libro que quiere buscar. Posteriormente, consulta la API con el libro a buscar y, siendo positivo el resultado, convierte los datos obtenidos en un tipo de dato compatible con la clase Libros. Para finalizar, imprime la información obtenida e internamente los datos obtenidos los guarda en la base de datos, guardando los libros en una entidad y la información de los autores en otra entidad.

2. **Listar Libros Registrados**
Es una simple consulta SQL en la base de datos que retorna una lista de los libros que están registrados, y los imprime.

3. **Listar autores registrados**
Como se mencionó anteriormente, al buscar un libro y encontrar coincidencia en la API, también se guarda información de los autores en una entidad diferente. Esta opción ejecuta una función que realiza una consulta a la tabla de autores y retorna una lista de autores.

4. **Listar autores vivos en determinado año**
Uno de los atributos de autores es su fecha de nacimiento y su fecha de fallecimiento, permitiendo así la consulta de autores vivos en un año predeterminado.

5. **Listar libros por idioma**
Se muestra un menú como el siguiente:
    
     
		en - Inglés
        es - Español
        fr - Frances
        zh - Chino
        de - Aleman
        ja - Japones
		
Y se pide al usuario ingresar uno de los siguientes códigos de idioma en los que quiera filtrar los registros de la base de datos.

*0- Salir*
Finalizar el programa


 
## Demostración del programa
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    1
    1. Buscar libro por titulo
    
    
    Ingrese el nombre del libro a buscar:
    invisible
    Libro encontrado
    
    ---------   Libro    ---------
    	Titulo: The Invisible Man: A Grotesque Romance
    	Autor: Wells, H. G. (Herbert George)
    	Idiomas: en
    	Descargas: 2627.0
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    2
    
    ---------   Libro    ---------
    	Titulo: Don Quijote
    	Autor: Cervantes Saavedra, Miguel de
    	Idiomas: es
    	Descargas: 14926.0
    
    ---------   Libro    ---------
    	Titulo: The Invisible Man: A Grotesque Romance
    	Autor: Wells, H. G. (Herbert George)
    	Idiomas: en
    	Descargas: 2627.0
    
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    3
    
    Autor: Cervantes Saavedra, Miguel de
    	Fecha de Nacimiento: 1547
    	Fecha de fallecimiento: 1616
    	Libros: [Don Quijote]
    
    Autor: Wells, H. G. (Herbert George)
    	Fecha de Nacimiento: 1866
    	Fecha de fallecimiento: 1946
    	Libros: [The Invisible Man: A Grotesque Romance]
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    4
    4. Listar autores vivos en determinado año
    Ingresa el año por filtrar autores vivos:
    1934
    
    Autor: Wells, H. G. (Herbert George)
    	Fecha de Nacimiento: 1866
    	Fecha de fallecimiento: 1946
    	Libros: [The Invisible Man: A Grotesque Romance]
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    5
    5. Listar libros por idioma
    en - Inglés
    es - Español
    fr - Frances
    zh - Chino
    de - Aleman
    ja - Japones
    
    Ingresa el idioma del libro:
    es
    
    ---------   Libro    ---------
    	Titulo: Don Quijote
    	Autor: Cervantes Saavedra, Miguel de
    	Idiomas: es
    	Descargas: 14926.0
    
    ------   MENU  PRINCIPAL   ------
    1. Buscar libro por titulo
    2. Listar Libros Registrados
    3. Listar autores registrados
    4. Listar autores vivos en determinado año
    5. Listar libros por idioma
    
    0- Salir
    
    Ingrese una opcion:
    
    0
    Finalizando aplicación ...
