import java.util.Scanner;


public class Testeaula {
public static void main(String[] args) {
	
	Scanner Scan = new Scanner(System.in);
				double n1,n2,n3,n4;
				String nome,nome1,nome2;
	System.out.println("Hello World");
	System.out.println("Digite seu nome");
    nome = Scan.next();
    System.out.println("Digite um numero");
    n1 = Scan.nextDouble();
    System.out.println("Digite outro numero");
    n2 = Scan.nextDouble();
    
	if (n1!=n2)
	{
		System.out.println("O numero " + n1 + " é diferente do numero " + n2);
	}
		else 
    {	
        System.out.println("Os numeros são iguais");    	
    }	
	
	
	//exercício 2 

	System.out.println("Digite o nome de uma pessoa");
	nome1 = Scan.next();
	System.out.println("Digite a idade dessa pessoa");
	n3 = Scan.nextDouble();
	System.out.println("Digite o nome de outra pessoa");
	nome2 = Scan.next();
	System.out.println("Digite a idade dessa outra pessoa");
	n4 = Scan.nextDouble();
	
	if (n3==n4)
	{
			System.out.println(nome1 + " tem a mesma idade de " + nome2);
	}
	else 
	{
	        System.out.println(nome1 + "è mais velho do que " + nome2);
	}
	
	
	
	
	
	
								
 

}
}
