package com.challengespring.ChallengeLibros.principal;
import com.challengespring.ChallengeLibros.model.*;
import com.challengespring.ChallengeLibros.repository.AutorRepository;
import com.challengespring.ChallengeLibros.repository.LibrosRepository;
import com.challengespring.ChallengeLibros.services.ConsumoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service

public class    Principal {
    private static final String URL_BASE = "https://gutendex.com/books/" ;
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    List<Libros> libros;
    List<Autor> autores;
    Scanner teclado = new Scanner(System.in);
    @Autowired
    private LibrosRepository repository;
    @Autowired
    private AutorRepository autorRepository;
    private String idiomas[] = {"en", "es", "fr", "zh", "de", "ja"};

    public Principal(LibrosRepository repository, AutorRepository autorRepository) {
        this.repository=repository;
        this.autorRepository=autorRepository;
    }

    public void muestraElMenu() {
        int opcion = 1;

        while(opcion != 0) {

            try {
                System.out.println("""
                    \n------   MENU  PRINCIPAL   ------
                    1. Buscar libro por titulo
                    2. Listar Libros Registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en determinado año
                    5. Listar libros por idioma
                                    
                    0- Salir
                                    
                    Ingrese una opcion:
                    """);

                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion){
                    case 0:
                        break;
                    case 1:
                        System.out.println("1. Buscar libro por titulo");
                        buscarSerieWeb();
                        break;
                    case 2:
                        System.out.println("2. Listar Libros Registrados");
                        mostrarLibrosBuscadas();
                        break;
                    case 3:
                        System.out.println("3. Listar autores registrados");
                        mostrarAutoresBuscadas();
                        break;
                    case 4:
                        System.out.println("4. Listar autores vivos en determinado año");
                        autoresVivos();
                        break;
                    case 5:
                        System.out.println("5. Listar libros por idioma");
                        buscarIdioma();
                        break;
                    default:
                        System.out.println("[!]ERROR:  Ingresa una opcion valida\n");
                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("[!]ERROR: Ingrese un DIGITO valido\n");
                teclado.next();
            }


        }
        System.out.println("Finalizando aplicación ...");
    }

    private Optional<DatosLibros> getDatosSerie() {
        System.out.println("\n\nIngrese el nombre del libro a buscar:");
        var tituloLibro=teclado.nextLine();
        try {
            var json = consumoAPI.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ", "+").toLowerCase());
            Datos datos = conversor.obtenerDatos(json, Datos.class);
            Optional<DatosLibros> libroBuscado = datos.libros().stream()
                    .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                    .findFirst();
            if(libroBuscado.isPresent()){
                System.out.println("Libro encontrado");
                return libroBuscado;
            }else{
                System.out.println("Libro no encontrado");
                return Optional.empty();
            }
        }catch (NullPointerException e){
            System.out.println("[!]ERROR: No se encontro la serie\n"+e);
            return Optional.empty();
        }
    }

    private void buscarSerieWeb() {
        Optional<DatosLibros> datos = getDatosSerie();
        if(!datos.isEmpty()){
            Libros libro = new Libros(datos);
            Autor autor = new Autor(datos.get().autor().getFirst());
            libro.setAutor(autor);
            if(repository.findByTitulo(libro.getTitulo()).isEmpty()){
                System.out.println(libro);
                autorRepository.save(autor);
                repository.save(libro);
            }else{
                System.out.println("\n[!] Libro ya registrado: \n\tTitulo: "+libro.getTitulo());
            }

        }
    }

    private void mostrarLibrosBuscadas() {
        libros = repository.findAll();
        libros.stream()
                .forEach(System.out::println);
    }

    private void mostrarAutoresBuscadas() {
        autores = autorRepository.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    private void buscarIdioma() {
        System.out.println("""
                en - Inglés
                es - Español
                fr - Frances
                zh - Chino
                de - Aleman
                ja - Japones
                """);
        System.out.println("Ingresa el idioma del libro:");
        var idiomaLibro = teclado.nextLine();
        for (int i = 0; i < idiomas.length; i++) {
            if (idiomaLibro.equals(idiomas[i])) {
                List<Libros> librosEncontrados = repository.findByIdiomas(idiomaLibro);
                if(!librosEncontrados.isEmpty())
                    librosEncontrados.forEach(System.out::println);
                else
                    System.out.println("\n[!] No se encontraron libros registrados en este idioma ( "+idiomaLibro+" )\n");
            }
        }
    }


    private void autoresVivos(){
        System.out.println("Ingresa el año por filtrar autores vivos:");
        String anio = Integer.toString(teclado.nextInt());
        List<Autor> autoresVivos;
        autoresVivos=autorRepository.autoresVivosPorAnio(anio);
        if(autoresVivos.isEmpty()){
            System.out.println("Autores no encontrados");
        }else {
            autoresVivos.stream().forEach(System.out::println);
        }
    }

    private void librosAutor(){

    }
}