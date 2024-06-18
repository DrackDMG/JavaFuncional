import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass {
    public static void main(String[] args) {
        //Consumer
        System.out.println("Consumer");
        Consumer<String> print = (value) -> System.out.println(value.toUpperCase());
        print.accept("Hola Mundo");
        System.out.println("============================================================");
        Consumer<Persona> printPersona = (persona) -> System.out.println(persona);
        Persona persona = new Persona("Daniel", 25);
        printPersona.accept(persona);
        System.out.println("============================================================");
        List<Persona> personas = List.of(
                new Persona("Daniel", 25),
                new Persona("Juan", 15),
                new Persona("Maria", 30),
                new Persona("Pedro", 10)
        );
        Consumer<List<Persona>> printListPersona = (listPersona) -> listPersona.forEach(System.out::println);
        printListPersona.accept(personas);
        System.out.println("============================================================");
        Consumer<Persona> printListPersonas = (listPerson) -> System.out.println(listPerson);
        personas.forEach(printListPersonas);
        System.out.println("============================================================");
        Consumer<Persona> filtrarMayor = person -> {
            if (person.getEdad() >= 18) {
                System.out.println("Mayor de 18 " + person);
            }
        };
        personas.forEach(filtrarMayor);
        System.out.println("============================================================");
        Consumer<Persona> mayusculaName = person -> {
            System.out.println(person.getNombre().toUpperCase());
        };
        personas.forEach(mayusculaName);
        System.out.println("============================================================");
        //andThen
        Consumer<Persona> printAndMayuscula = printListPersonas.andThen(mayusculaName);
        personas.forEach(printAndMayuscula);
        System.out.println("============================================================");
        //andThen
        Consumer<Persona> printAndMayusculaAndFiltrar = mayusculaName.andThen(filtrarMayor);
        personas.forEach(printAndMayusculaAndFiltrar);
        System.out.println("============================================================");
        Consumer<String> print2 = (value) -> System.out.println(value.toUpperCase());
        print2.accept("Hola Mundo");
        Consumer<String> print3 = (value) -> System.out.println(value.toLowerCase());
        print3.accept("Hola Mundo");
        System.out.println("============================================================");
        System.out.println("Combinar Consumer andThen");
        Consumer<String> combinarConsumer = print2.andThen(print3);
        combinarConsumer.accept("Hola Mundo");
        System.out.println("============================================================");
        List<String> frutas = List.of("Manzana", "Pera", "Banano", "Uva", "Limon");
        Consumer<String> frutasLetraA = (fruta) -> {
            if (fruta.contains("a")) {
                System.out.println(fruta);
            }
        };
        Consumer<String> combinar = print2.andThen(frutasLetraA);
        frutas.forEach(combinar);
    }
}
