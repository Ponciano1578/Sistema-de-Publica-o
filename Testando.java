import java.util.Scanner;

public class Testando {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Double n1;
        Double n2;
        Double resultado;

        

        System.out.println("Digite o valor do primeiro numero ?");
        n1 = input.nextDouble();
        System.out.println("Digite o valor do Segundo Numero ?");
        n2 = input.nextDouble();
        resultado = n1 + n2;
        System.out.println("A soma dos valores é : " + resultado);

    }
}
