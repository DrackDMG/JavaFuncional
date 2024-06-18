import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiFunction {
    public static void main(String[] args) {
        List<Persona2> personas = List.of(
                new Persona2("Daniel", 25, 'M'),
                new Persona2("David", 25, 'M'),
                new Persona2("Juan", 15, 'M'),
                new Persona2("Maria", 30, 'F'),
                new Persona2("Pedro", 10, 'M')
        );
        //predicate y BiFunction
        Predicate<Persona2> mayorEdadPersona = p -> p.getEdad() >= 18;
        Predicate<Persona2> generoPersona = p -> p.getGenero() == 'F';
        BiFunction<Predicate<Persona2>, Predicate<Persona2>, Predicate<Persona2>> andPredicate = (p1, p2) -> p1.and(p2);
        personas.stream().filter(andPredicate.apply(mayorEdadPersona, generoPersona)).forEach(System.out::println);
        personas.forEach(
                p -> {
                    if (mayorEdadPersona.and(generoPersona).test(p)) {
                        System.out.println("Mayor de edad y genero femenino " + p);
                    }
                }
        );
        personas.stream().filter(mayorEdadPersona.and(generoPersona)).forEach(System.out::println);
        personas.stream().filter(andPredicate.apply(mayorEdadPersona, generoPersona)).forEach(
                p -> {
                    System.out.println("Mayor de edad y genero femenino " + p);
                }
        );






    }
}

