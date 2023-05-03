import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Principal {
  
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
	
		
		int MenuPrincipal = 0;
		int SubMenu = 0;
		int SubMenuDoSubMenu = 0;
		
		while (MenuPrincipal != 4) {
			
		System.out.println("Menu:");
		System.out.println("1 - Licitação ");
		System.out.println("2 - Legislação");
		System.out.println("3 - Transparencia");
		System.out.println("4 - Sair");
		System.out.println("Digite uma opção");
		MenuPrincipal = input.nextInt();
			
		switch (MenuPrincipal) {
		  case 1:
			while (SubMenu != 5) {
				System.out.println("Licitação: ");
				System.out.println("1 - Atas");
				System.out.println("2 - Contratos");
				System.out.println("3 - Editais");
				System.out.println("4 - Termos Aditivos");
				System.out.println("5 - Voltar");
				SubMenu = input.nextInt();
				
				switch (SubMenu) {
				  case 1:
					  System.out.println(" Ata");
					  System.out.println(" ");
					  ArrayList<ArmazenamentoAta> informacoes = new ArrayList<ArmazenamentoAta>();
					  boolean ContinuarInserindo = true;
					  while (ContinuarInserindo) {
					  String linkAta;
					  String numeroAta;
					  String objetoAta;
					  String fornecedorAta;
					  linkAta = input.nextLine();
					  System.out.println("Digite o link: ");
					  linkAta = input.nextLine();
					  System.out.println("Digite o Numero da Ata:");
					  numeroAta = input.nextLine();
					  System.out.println("Digite o objeto da Ata:");
					  objetoAta = input.nextLine();
					  System.out.println("Digite o Nome do fornecedor em MAIUSCULO:");
					  fornecedorAta = input.nextLine();

					  ArmazenamentoAta info = new ArmazenamentoAta(linkAta, numeroAta, objetoAta, fornecedorAta);
					  informacoes.add(info);
					  System.out.println("Deseja continuar inserindo informações? (s/n)");
					  String resposta = input.next();
					  if (resposta.equals("n")) {
					  ContinuarInserindo = false;
					  }
					  } 
					  for (ArmazenamentoAta info : informacoes ) {
					  System.out.println("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
					  System.out.println("<td style=\"text-align: justify;\"> "+ info.getnumeroAta() +" </td>");
					  System.out.println("<td style=\"text-align: justify;\">"+ info.getobjetoAta()+".</td>");
					  System.out.println("<td style=\"text-align: justify;\">"+ info.getfornecedorAta()+"</td>");
					  System.out.println("<td><div align=\"center\"><a href=\"../../Atas/2023/"+ info.getlinkAta()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>"); 
					  System.out.println("</tr>");
					  }
					  break;
				

				  case 2:
					  System.out.println("Contratos");
					  System.out.println(" ");
					  
					  
					  ArrayList<ArmazenamentoContrato> informacoes1 = new ArrayList<ArmazenamentoContrato>();
					  
					  boolean ContinuarInserindo1 = true;
					  
					  
					  while (ContinuarInserindo1) {
					  String linkContrato;
					  String numeroContrato;
					  String objetoContrato;
					  String fornecedorContrato;
					  String valorContrato;
					  
					  linkContrato = input.nextLine();
					  
					  System.out.println("Digite o link: ");
					  linkContrato = input.nextLine();
					  
					  System.out.println("Digite o Numero do Contrato:");
					  numeroContrato = input.nextLine();
					  
					  System.out.println("Digite o objeto do Contrato:");
					  objetoContrato = input.nextLine();
					  
					  System.out.println("Digite o Nome do fornecedor em MAIUSCULO:");
					  fornecedorContrato = input.nextLine();
					  
					  System.out.println("Digite o valor do Contrato:");
					  valorContrato = input.nextLine();
					 
					  ArmazenamentoContrato info = new ArmazenamentoContrato(linkContrato, numeroContrato, objetoContrato, fornecedorContrato, valorContrato);
					  informacoes1.add(info);
					  System.out.println("Deseja continuar inserindo informações? (s/n)");
					  String resposta = input.next();
					  
					  if (resposta.equals("n")) {
						  ContinuarInserindo1 = false;
					  }
					  } 
					  for (ArmazenamentoContrato info : informacoes1 ) {
						  System.out.println("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
						  System.out.println("<td style=\"text-align: justify;\">"+ info.getnumeroContrato() +"/2023</td>");
						  System.out.println("<td style=\"text-align: justify;\">"+ info.getobjetoContrato()+".</td>");
						  System.out.println("<td style=\"text-align: justify;\">"+ info.getfornecedorContrato()+"</td>");
						  System.out.println("<td style=\"text-align: justify;\">"+ info.getvalorContrato()+"</td>");
						  System.out.println("<td><div align=\"center\"><a href=\"../../Contratos/2023/"+ info.getlinkContrato()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>"); 
						  System.out.println("</tr>");
					  }
					  break;
					  
				  case 3:
					  while (SubMenuDoSubMenu != 4) {
							System.out.println("Editais: ");
							System.out.println("1 - Pregão Presencial");
							System.out.println("2 - Credenciamentos");
							System.out.println("3 - Tomada de Preço");
							System.out.println("4 - Voltar");
							SubMenuDoSubMenu = input.nextInt();
							
							switch (SubMenuDoSubMenu) {
							  case 1:
								  System.out.println(" Pregão Presencial");
								  System.out.println(" ");
								  
								  
								  ArrayList<ArmazenamentoPregaoPresencial> informacoes2 = new ArrayList<ArmazenamentoPregaoPresencial>();
								  
								  boolean ContinuarInserindo2 = true;
								  
								  
								  while (ContinuarInserindo2) {
									  String LinkPregao;
									  String NumeroPregao;
									  String NumeroProcesso;
									  String DescricaoPregao;
									  String DataPregao;
									  String HoraPregao;
								  
									  LinkPregao = input.nextLine();
								  
								  System.out.println("Digite o link: ");
								  LinkPregao = input.nextLine();
								  
								  System.out.println("Digite o Numero do Pregão:");
								  NumeroPregao = input.nextLine();
								  
								  System.out.println("Digite o Numero do Processo:");
								  NumeroProcesso = input.nextLine();
								  
								  System.out.println("Digite a Descrição do Pregão:");
								  DescricaoPregao = input.nextLine();
								  
								  System.out.println("Digite a Data do Pregão:");
								  DataPregao = input.nextLine();
								  
								  System.out.println("Digite a Hora do Pregão:");
								  HoraPregao = input.nextLine();
								 
								  ArmazenamentoPregaoPresencial info = new ArmazenamentoPregaoPresencial(LinkPregao, NumeroPregao, NumeroProcesso, DescricaoPregao, DataPregao, HoraPregao);
								  informacoes2.add(info);
								  System.out.println("Deseja continuar inserindo informações? (s/n)");
								  String resposta = input.next();
								  
								  if (resposta.equals("n")) {
									  ContinuarInserindo2 = false;
								  }
								  } 
								  for (ArmazenamentoPregaoPresencial info : informacoes2 ) {
									  System.out.println("<tr style=\"cursor: default;\">");
									  System.out.println("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>");
									  System.out.println("<td style=\"width: 145px;\"><div align=\"center\">Pregão Presencial Nº"+ info.getNumeroPregao()+"</div></td>");
									  System.out.println("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoPregao()+".</div></td>");
									  System.out.println("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataPregao()+"</div></td>");
									  System.out.println("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraPregao()+"</div></td>"); 
									  System.out.println("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkPregao()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>");
									  System.out.println("<td style=\"width: 88.9px;\"><div align=\"center\">-</div></td>");
									  System.out.println("<td style=\"width: 88.9px; text-align: center;\">-</td>");
									  System.out.println("</tr>");
								  }
								  break;
								  
							  case 2:
								  System.out.println("Credenciamento"); 
								  
								  break;
							  case 3:
								  System.out.println("Tomada de Preço");
								  
								  break;
							  case 4:
								  System.out.println(" Voltando Para SubMenu");
								  
								  break;
							}
						}
				  case 4:
					  System.out.println("Termo Aditivo");
					  System.out.println(" ");
					  ArrayList<ArmazenamentoTermoAditivo> informacoes6 = new ArrayList<ArmazenamentoTermoAditivo>();
					  	
					  boolean ContinuarInserindo6 = true;
					  	
					  	while (ContinuarInserindo6) {
					  		String LinkTermo;
					  	    String NumeroTermo;
					  	    String DescricaoTermo;
					  	    String EmpresaContratada;
					  
					  LinkTermo = input.nextLine();
					  		
					  System.out.println("Digite o link: ");
					  LinkTermo = input.nextLine();
					  
					 
					  
					  System.out.println("Digite o Numero do Termo Aditivo:");
					  NumeroTermo = input.nextLine();
					  
					
					  
					  System.out.println("Digite a Descrição do Termo Aditivo:");
					  DescricaoTermo = input.nextLine();
					  
				
					  
					  System.out.println("Digite o Nome da empresa em MAIUSCULO:");
					  EmpresaContratada = input.nextLine();

					
					  
					  ArmazenamentoTermoAditivo info = new ArmazenamentoTermoAditivo(LinkTermo, NumeroTermo, DescricaoTermo, EmpresaContratada);
					  informacoes6.add(info);
					  
					 
					  
					  System.out.println("Deseja continuar inserindo informações? (s/n)");
					  String resposta = input.next();
					  
					  
					  if (resposta.equals("n")) {
					  ContinuarInserindo6 = false;
					  }
					  } 
					  	
					  	
					  for (ArmazenamentoTermoAditivo info : informacoes6 ) {
					  System.out.println("<tr style=\"cursor: default;\">");
					  System.out.println("<td>"+info.getNumeroTermo()+"/2022</td>");
					  System.out.println("<td>"+info.getDescricaoTermo()+".</td>");
					  System.out.println("<td>"+info.getEmpresaContratada()+"</td>");
					  System.out.println("<td><div align=\"center\"><a href=\"../../Termos_Aditivos/20221/"+info.getLinkTermo()+".pdf\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>"); 
					  System.out.println("</tr>");
					  }
					  
					  
					  break;
				 case 5:
					 System.out.println("Voltando para o menu principal");
					 
					 break;
					 
				default:
					System.out.println("Nao existe este comando");
				
				}
			}
		  SubMenu = 0;
		  break;
		  
		  case 2:
				while (SubMenu != 4) {
					System.out.println("Legislação: ");
					System.out.println("1 - Decreto");
					System.out.println("2 - Leis");
					System.out.println("3 - Portaria");
					System.out.println("4 - Voltar");
					SubMenu = input.nextInt();
				
					switch (SubMenu) {
					  case 1:
						  System.out.println("Decretos");
						  System.out.println("      ");
						  
						  
						 ArrayList<ArmazenamentoDecreto> informacoes = new ArrayList<ArmazenamentoDecreto>();
						   
						 boolean ContinuarInserindo = true;
						  
						while (ContinuarInserindo) {
							String linkDecreto;
							String nomeDecreto;
							String NumeroDecreto;
							
							linkDecreto = input.nextLine();
						    System.out.println("Digite o link: ");
						    linkDecreto = input.nextLine();
							System.out.println("Digite o Nome do Decreto:");
							nomeDecreto = input.nextLine();
							System.out.println("Digite o Numero do Decreto:");
							NumeroDecreto = input.next();

							ArmazenamentoDecreto info = new ArmazenamentoDecreto(linkDecreto, nomeDecreto, NumeroDecreto);
							informacoes.add(info);
							
							System.out.println("Deseja continuar inserindo informações? (s/n)");
							String resposta = input.next();
							
							if (resposta.equals("n")) {
							    ContinuarInserindo = false;

						}
						  
						}	  
						
						for (ArmazenamentoDecreto info : informacoes ) {
								System.out.println("<tr style=\"cursor: default;\">");
								System.out.println("<td class=\"text-left\" style=\"height: 60px;\">");
								System.out.println("<div align=\"center\">" + info.getNumeroDecreto() +"</div></td>");
								System.out.println("<td class=\"text-left\" style=\"height: 60px;\">"+ info.getnomeDecreto() +".</td>");
								System.out.println("<td style=\"width: 60px;\">"); 
								System.out.println("<div align=\"center\"><a href=\"../../Decretos/"+info.getlinkDecreto() +".pdf\" target=\"_blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>");
								System.out.println("</tr>");
								
						}
						break;
								
						 
						
					  case 2:
						while (SubMenuDoSubMenu != 4) {
							System.out.println("Legislação: ");
							System.out.println("1 - Lei Complementar");
							System.out.println("2 - Lei Organica");
							System.out.println("3 - Lei Ordinaria");
							System.out.println("4 - Voltar");
							SubMenuDoSubMenu = input.nextInt();
							
							switch (SubMenuDoSubMenu) {
							  case 1:
								  System.out.println(" Digite a Lei Complementar");
								  
								  break;
								  
							  case 2:
								  System.out.println(" Digite a Lei Organica");
								  
								  break;
							  case 3:
								  System.out.println(" Digite a Lei Ordinaria");
								  
								  break;
							  case 4:
								  System.out.println(" Voltando Para SubMenu");
								  
								  break;
							}
						}
					  case 3:
						  System.out.println(" Digite a Portaria");
						 
						  break;
					  case 4:
						  System.out.println("Voltando para o menu anterior");
						  
						  break;

						 
					default:
						System.out.println("Nao existe este comando");
					
					}
				}
		  case 3:
			
			while (SubMenu != 2) {
			 System.out.println("Transparencia ");
			 System.out.println("1 - Termo de Convocação");
			 System.out.println("2 - Voltar Para o Menu");
			 SubMenu = input.nextInt();
			
			switch (SubMenu) {
			  case 1:
				 
				  
				  
				  System.out.println("Termo de Convocação");
				  System.out.println("      ");
				  
				  
				  ArrayList<ArmazenamentoTermoDeCovocacao> informacoes = new ArrayList<ArmazenamentoTermoDeCovocacao>();
					
					boolean continuarInserindo = true;
					
					while (continuarInserindo) {
					    String link;
						String Data;
						String Nome ;
						String Cargo ;
					  
						link = input.nextLine();
					    System.out.println("Digite o link: ");
					    link = input.nextLine();
						System.out.println("Digite o Nome:");
						Nome = input.nextLine();
						System.out.println("Digite o Nome Do Cargo:");
						Cargo = input.nextLine();
						System.out.println("Digite a Data:");
						Data = input.nextLine();
						
						ArmazenamentoTermoDeCovocacao info = new ArmazenamentoTermoDeCovocacao(link, Nome, Cargo, Data);
						informacoes.add(info);
						
						System.out.println("Deseja continuar inserindo informações? (s/n)");
						String resposta = input.nextLine();
						
						if (resposta.equals("n")) {
						    continuarInserindo = false;
						}
					}
					 for (ArmazenamentoTermoDeCovocacao info : informacoes ) {
					System.out.println("<tr style=\"cursor: default;\">");
					System.out.println( "<td> "+ info.getNome() +"</td>");
					System.out.println( "<td>" +info.getCargo() +"</td>");
					System.out.println( "<td>");
					System.out.println( "<div align=\"center\">" +info.getData() +"</div></td>");
					System.out.println( "<td>");
					System.out.println( "<div align=\"center\"><a href=\"../../termosdeconvocacao/2023/" + info.getLink() +".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>");
					System.out.println("</tr>");
				
					
						
				
					
					
				  

}
			}
			}
		}
		
		
		
		
	}	
 }

}