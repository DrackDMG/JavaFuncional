interface Operacion{
    int operar(int a, int b);
}
class Calculadora{
     static int sumar(int a, int b){
        return a + b;
    }
     static int restar(int a, int b){
        return a - b;
    }
}

public class MetodosEstaticos {
    public static void main(String[] args){
        OperacionI suma = (a, b) -> a + b;
        System.out.println(suma.operar(3, 4));

        OperacionI resta = (a, b) -> a - b;
        System.out.println(resta.operar(3, 4));

        OperacionI suma2 = Calculadora::sumar;
        System.out.println(suma2.operar(3, 4));

        OperacionI resta2 = Calculadora::restar;
        System.out.println(resta2.operar(3, 4));




    }
}
