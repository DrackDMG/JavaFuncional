
interface OperacionI {
    int operar(int a, int b);
}

class CalculadoraI {
    int sumar(int a, int b) {
        return a + b;
    }
}

public class MetodosInstancia {
    public static void main(String[] args) {

        OperacionI suma = (a, b) -> a + b;
        System.out.println(suma.operar(3, 4));

        CalculadoraI calc = new CalculadoraI();
        OperacionI suma2 = calc::sumar;
        System.out.println(suma2.operar(3, 4));

    }

}
