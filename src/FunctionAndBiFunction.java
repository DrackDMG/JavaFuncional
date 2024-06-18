import java.util.function.BiFunction;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FunctionAndBiFunction {
    public static void main(String[] args) {
        //Function
        System.out.println("Function");
        Function<Integer, Integer> add = (value) -> value + 1;
        Function<Integer, Integer> multiply = (value) -> value * 2;
        System.out.println("Suma 3 + 1 = " + add.apply(3));
        System.out.println("Multiplicación 3 * 2 = " + multiply.apply(3));

        Function<Integer, Integer> anioNacimiento = (edad) -> 2024 - edad;
        Persona persona = new Persona("Daniel", 25);
        System.out.println("Año de nacimiento de " + persona.getNombre() + " es " + anioNacimiento.apply(persona.getEdad()));

        System.out.println("============================================================");

        System.out.println("BiFunction");

        //BIFunction
        BiFunction<Integer, Integer, Integer> addBi = (value1, value2) -> value1 + value2;
        BiFunction<Integer, Integer, Integer> multiplyBi = (value1, value2) -> value1 * value2;
        System.out.println("Suma 3 + 1 = " + addBi.apply(3, 1));
        System.out.println("Multiplicación 3 * 2 = " + multiplyBi.apply(3, 2));

        BiFunction<Integer, Integer, Integer> anioNacimientoBi = (edad, anioActual) -> anioActual - edad;
        System.out.println("Año de nacimiento de " + persona.getNombre() + " es " + anioNacimientoBi.apply(persona.getEdad(), 2024));

        System.out.println("============================================================");

        System.out.println("Function andThen");
        Function<Integer, Integer> addAndMultiply = add.andThen(multiply);
        System.out.println("Suma 3 + 1 y luego multiplicación por 2 = " + addAndMultiply.apply(3));

        System.out.println("============================================================");

        System.out.println("Function compose");
        Function<Integer, Integer> addComposeMultiply = add.compose(multiply);
        System.out.println("Multiplicación 3 * 2 y luego suma 1 = " + addComposeMultiply.apply(3));


    }
}