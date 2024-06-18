import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiPredicate {

    public static void main(String[] args) {
        //Predicate
        System.out.println("Predicate");
        Predicate<Integer> isEven = (value) -> value % 2 == 0;
        System.out.println("El número 4 es par? " + isEven.test(4));
        System.out.println("El número 5 es par? " + isEven.test(5));
        System.out.println("============================================================");
        Predicate<Integer> mayorEdad = (edad) -> edad >= 18;
        Persona persona = new Persona("Daniel", 25);
        System.out.println("La persona " + persona.getNombre() + " es mayor de edad? " + mayorEdad.test(persona.getEdad()));
        System.out.println("============================================================");
        Predicate<Persona> mayorEdadPersona = (p) -> p.getEdad() >= 18;
        List<Persona> personas = List.of(
                new Persona("Daniel", 25),
                new Persona("David", 25),
                new Persona("Juan", 15),
                new Persona("Maria", 30),
                new Persona("Pedro", 10)
        );
        personas.stream().filter(mayorEdadPersona).forEach(System.out::println);
        System.out.println("============================================================");
        //BiPredicate
        System.out.println("BiPredicate");
        BiPredicate<Integer, Integer> isEquals = (value1, value2) -> value1.equals(value2);
        System.out.println("El número 4 es igual a 4? " + isEquals.test(4, 4));
        System.out.println("El número 4 es igual a 5? " + isEquals.test(4, 5));
        System.out.println("============================================================");
        BiPredicate<Integer, Integer> isMayor = (value1, value2) -> value1 > value2;
        System.out.println("El número 4 es mayor a 3? " + isMayor.test(4, 3));
        System.out.println("El número 4 es mayor a 5? " + isMayor.test(4, 5));
        System.out.println("============================================================");
        //para la persona que sea mayor de edad y que su nombre empiece con D
        BiPredicate<Persona, String> mayorEdadAndStartWithD = (p, letra) -> p.getEdad() >= 18 && p.getNombre().startsWith(letra);
        personas.stream().filter(p -> mayorEdadAndStartWithD.test(p, "D")).forEach(System.out::println);
        System.out.println("============================================================");
        BiPredicate<Persona, Integer> mayorEdadAndEdad = (p, edad) -> p.getEdad() >= edad;
        personas.stream().filter(p -> mayorEdadAndEdad.test(p, 18)).forEach(System.out::println);
        personas.forEach(
                p -> {
                    if (mayorEdadAndEdad.test(p, 18)) {
                        System.out.println("Mayor de 18 " + p);
                    }
                }
        );










    }
}
