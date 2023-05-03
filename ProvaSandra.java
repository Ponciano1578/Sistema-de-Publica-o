import java.util.Locale;
import java.util.Scanner;

public class ProvaSandra {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        String Paciente[] = { "Ana", "Luis", "Bia", "Ivo", "Ana", "Luis", "Ian", "Bia" };
        int codigo_convenio[] = { 1, 2, 3, 3, 2, 1, 1, 2 };
        double Valor[] = { 300.0, 400.0, 500.0, 350.0, 250.0, 150.0, 200.0, 450.0 };

        
        ArmazenamentoSandra[] armazenamentos = new ArmazenamentoSandra[Paciente.length];
        for (int i = 0; i < Paciente.length; i++) {
            armazenamentos[i] = new ArmazenamentoSandra(Paciente[i], codigo_convenio[i], Valor[i]);
        }

        
        for (int i = 0; i < armazenamentos.length; i++) {
            System.out.println("Paciente: " + armazenamentos[i].getPaciente());
            System.out.println("Código do convênio: " + armazenamentos[i].getCodigo_convenio());
            System.out.println("Valor: " + armazenamentos[i].getValor());
            System.out.println();
            
        }
            double soma = 0.0;
            int contador = 0;
            for (int ii = 0; ii < armazenamentos.length; ii++) {
                if (armazenamentos[ii].getCodigo_convenio() == 1) {
                    soma += armazenamentos[ii].getValor();
                    contador++;
                }
            }

            double media = soma / contador;
            System.out.println("Valor base médio das consultas sem convênio: " + media);


            int indiceMenorValor = 0;
            double menorValor = armazenamentos[0].getValor();
            for (int i = 1; i < armazenamentos.length; i++) {
                if (armazenamentos[i].getValor() < menorValor) {
                    menorValor = armazenamentos[i].getValor();
                    indiceMenorValor = i;
                }
            }
            
            System.out.println("");
            System.out.println("Ficha do paciente da consulta mais barata:");
            System.out.println("Nome: " + armazenamentos[indiceMenorValor].getPaciente());
            System.out.println("Convênio: " + armazenamentos[indiceMenorValor].getCodigo_convenio());
            System.out.println("Valor da consulta: " + armazenamentos[indiceMenorValor].getValor());
            
           
            System.out.print(" \n");
            System.out.print(" \n");
            System.out.print("Digite o nome do paciente: ");
            String nomePaciente = input.nextLine();
            
            double valorBase = 0.0;
            int codigoConvenio = 0;
            for (int i = 0; i < armazenamentos.length; i++) {
                if (armazenamentos[i].getPaciente().equalsIgnoreCase(nomePaciente)) {
                    valorBase = armazenamentos[i].getValor();
                    codigoConvenio = armazenamentos[i].getCodigo_convenio();
                    break;
                }
            }
            
            double valorFinal = 0.0;
            switch (codigoConvenio) {
                case 1:
                    valorFinal = valorBase;
                    break;
                case 2:
                    valorFinal = valorBase * 0.2;
                    break;
                case 3:
                    valorFinal = valorBase * 0.3;
                    break;
                default:
                    System.out.println("Código de convênio inválido!");
                    return;
            }
            
            System.out.printf("Valor Total: %s R$%.2f\n", nomePaciente, valorFinal);
        }
    }
        
    

