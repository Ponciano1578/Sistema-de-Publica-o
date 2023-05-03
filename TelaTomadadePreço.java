import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;






public class TelaTomadadePreço extends JFrame {
private ArrayList<ArmazenamentoTomadaDePreço> informacoes = new ArrayList<ArmazenamentoTomadaDePreço>();
private JLabel labelLinkTP;
private JTextField campoLinkTP;
private JLabel labelNumeroTP;
private JTextField campoNumeroTP;
private JLabel labelNumeroProcesso;
private JTextField campoNumeroProcesso;
private JLabel labelDescricaoTP;
private JTextField campoDescricaoTP;
private JLabel labelDataTP;
private JTextField campoDataTP;
private JLabel labelHoraTP;
private JTextField campoHoraTP;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Processo", "Número", "Link", "Descrição", "Data", "Hora"};
private ArrayList<ArmazenamentoTomadaDePreço> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoTomadaDePreço> dados) {
this.dados = dados;
}
public int getRowCount() {
return dados.size();
}
public int getColumnCount() {
return colunas.length;
}
public String getColumnName(int column) {
return colunas[column];
}
public Object getValueAt(int rowIndex, int columnIndex) {
	ArmazenamentoTomadaDePreço info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getNumeroProcesso();
case 1:
return info.getNumeroTP();
case 2:
return info.getLinkTP();
case 3:
return info.getDescricaoTP();
case 4:
return info.getDataTP();
case 5:
return info.getHoraTP();
default:
return null;
}
}
}
public TelaTomadadePreço() {
// Configurações da janela
setTitle("PUBLICANDO EDITAIS - Tomada de Preço");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));


// Inicializando componentes
labelLinkTP = new JLabel("Link:");
labelLinkTP.setBounds(24, 23, 137, 14);
campoLinkTP = new JTextField(20);
campoLinkTP.setBounds(160, 20, 511, 20);

labelNumeroTP = new JLabel("Número da Tomada de Preço:");
labelNumeroTP.setBounds(24, 48, 184, 14);
campoNumeroTP = new JTextField(20);
campoNumeroTP.setBounds(218, 45, 191, 20);

labelNumeroProcesso = new JLabel("Número do Processo:");
labelNumeroProcesso.setBounds(419, 51, 132, 14);
campoNumeroProcesso = new JTextField(20);
campoNumeroProcesso.setBounds(550, 45, 121, 20);

labelDescricaoTP = new JLabel("Descrição:");
labelDescricaoTP.setBounds(24, 76, 137, 14);
campoDescricaoTP = new JTextField(20);
campoDescricaoTP.setBounds(160, 73, 511, 20);

labelDataTP = new JLabel("Data:");
labelDataTP.setBounds(24, 105, 137, 14);
campoDataTP = new JTextField(20);
campoDataTP.setBounds(160, 101, 191, 20);

labelHoraTP = new JLabel("Horário:");
labelHoraTP.setBounds(357, 105, 66, 14);
campoHoraTP = new JTextField(20);
campoHoraTP.setBounds(422, 104, 249, 20);

botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 144, 149, 23);

botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,174,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,204,149,23);

tabelaInformacoes = new JTable();
scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 147, 452, 359);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);





// Adicionando componentes à janela
getContentPane().add(labelLinkTP);
getContentPane().add(campoLinkTP);

getContentPane().add(labelNumeroTP);
getContentPane().add(campoNumeroTP);

getContentPane().add(labelNumeroProcesso);
getContentPane().add(campoNumeroProcesso);

getContentPane().add(labelDescricaoTP);
getContentPane().add(campoDescricaoTP);

getContentPane().add(labelDataTP);
getContentPane().add(campoDataTP);

getContentPane().add(labelHoraTP);
getContentPane().add(campoHoraTP);

getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);

getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);

getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);




// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

	String LinkTP = campoLinkTP.getText();
	String NumeroTP = campoNumeroTP.getText();
	String NumeroProcesso = campoNumeroProcesso.getText();
	String DescricaoTP = campoDescricaoTP.getText();
	String DataTP = campoDataTP.getText();
	String HoraTP = campoHoraTP.getText();



ArmazenamentoTomadaDePreço info = new ArmazenamentoTomadaDePreço(LinkTP, NumeroTP, NumeroProcesso, DescricaoTP, DataTP, HoraTP);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campoLinkTP.setText("");
campoNumeroTP.setText("");
campoNumeroProcesso.setText("");
campoDescricaoTP.setText("");
campoDataTP.setText("");
campoHoraTP.setText("");
}
});


	botaoExcluir.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	      int selectedRow = tabelaInformacoes.getSelectedRow();
	      if (selectedRow != -1) {
	          informacoes.remove(selectedRow);
	          tabelaInformacoes.updateUI();
	          ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();
	      }
	  }
	});
//Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoTomadaDePreço info = informacoes.get(selectedRow);
			campoNumeroProcesso.setText(info.getNumeroProcesso());
			campoNumeroTP.setText(info.getNumeroTP());
			campoLinkTP.setText(info.getLinkTP());
			campoDescricaoTP.setText(info.getDescricaoTP());
			campoDataTP.setText(info.getDataTP());
			campoHoraTP.setText(info.getHoraTP());
		
		// Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,234,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoTomadadePreço correspondente à linha selecionada
			           ArmazenamentoTomadaDePreço info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoTomadadePreço
			           info.setNumeroProcesso(campoNumeroProcesso.getText());
			           info.setNumeroTP(campoNumeroTP.getText());
			           info.setLinkTP(campoLinkTP.getText());
						info.setDescricaoTP(campoDescricaoTP.getText());
						info.setDataTP(campoDataTP.getText());
						info.setHoraTP(campoHoraTP.getText());
					}
			        // Atualizando a tabela
			        tabelaInformacoes.updateUI();
			        ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();

			     }
			  });
 }
}
});
		// Adicionando ação para o botão de exclusão
        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaInformacoes.getSelectedRow();
                if (selectedRow != -1) {
                    informacoes.remove(selectedRow);
                    tabelaInformacoes.updateUI();
                    ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();
                }
            }
        });
		
		
botaoMostrarDados.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    // Create a new JFrame for displaying the information
	    JFrame mostrarDadosFrame = new JFrame("Mostrar Dados");
	    mostrarDadosFrame.setSize(700, 600);
	    mostrarDadosFrame.setLocationRelativeTo(null);
	    mostrarDadosFrame.setExtendedState(MAXIMIZED_BOTH);
	    mostrarDadosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    // Create a JTextArea for displaying the information
	    JTextArea areaTexto = new JTextArea();
	    areaTexto.setEditable(true);
	    areaTexto.setBounds(24, 136, 452, 370);

	    // Append the information from the "ArmazenamentoAta" objects to the JTextArea
	    for (ArmazenamentoTomadaDePreço info : informacoes ) {
	    	areaTexto.append("<tr style=\"cursor: default;\">/n");
	    	areaTexto.append("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
	    	areaTexto.append("<td style=\"width: 145px;\"><div align=\"center\">Tomada de Preço Nº"+ info.getNumeroTP()+"</div></td>\n");
	    	areaTexto.append("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoTP()+".</div></td>\n");
	    	areaTexto.append("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataTP()+"</div></td>\n");
	    	areaTexto.append("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraTP()+"</div></td>\n"); 
	    	areaTexto.append("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkTP()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
	    	areaTexto.append("<td style=\"width: 88.9px;\"><div align=\"center\">-</div></td>\n");
	    	areaTexto.append("<td style=\"width: 88.9px; text-align: center;\">-</td>\n");
	    	areaTexto.append("</tr>\n");
            areaTexto.append("\n");
	    }

	    JScrollPane scrollPane = new JScrollPane(areaTexto);
	    scrollPane.setBounds(24, 136, 452, 370);

	    // Add the JScrollPane to the JFrame and set it visible
	    mostrarDadosFrame.add(scrollPane);
	    mostrarDadosFrame.setVisible(true);
	  }
	});
//Adicionando ação para o botão de exclusão

botaoSalvarDados.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
salvarDados();
}
});
// Configurando a tabela
MeuModeloTabela modelo = new MeuModeloTabela(informacoes);
tabelaInformacoes.setModel(modelo);
btnMenuPrincipal = new JButton("Menu Principal");
btnMenuPrincipal.setBounds(505, 483, 149, 23);
getContentPane().add(btnMenuPrincipal);

btnMenuPrincipal.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	setExtendedState(JFrame.ICONIFIED);
	MenuPrincipal menuPrincipal = new MenuPrincipal();
	menuPrincipal.setVisible(true);
	dispose();
	}
	});

txtSistemaDePublicaes = new JTextField();
txtSistemaDePublicaes.setHorizontalAlignment(SwingConstants.CENTER);
txtSistemaDePublicaes.setText("Sistema de Publicações - Prefeitura Municipal De Guaranésia - CPD 2023");
txtSistemaDePublicaes.setEditable(false);
txtSistemaDePublicaes.setBounds(0, 541, 684, 20);
getContentPane().add(txtSistemaDePublicaes);
txtSistemaDePublicaes.setColumns(10);
// Exibindo a janela
setVisible(true);
}
public void mostrarDados() {
for (ArmazenamentoTomadaDePreço info : informacoes ) {
	System.out.println("<tr style=\"cursor: default;\">");
	  System.out.println("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
	  System.out.println("<td style=\"width: 145px;\"><div align=\"center\">Tomada de Preço Nº"+ info.getNumeroTP()+"</div></td>\n");
	  System.out.println("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoTP()+".</div></td>\n");
	  System.out.println("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataTP()+"</div></td>\n");
	  System.out.println("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraTP()+"</div></td>\n"); 
	  System.out.println("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkTP()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
	  System.out.println("<td style=\"width: 88.9px;\"><div align=\"center\">-</div></td>\n");
	  System.out.println("<td style=\"width: 88.9px; text-align: center;\">-</td>\n");
	  System.out.println("</tr>\n");
}
}
public void salvarDados() {
JFileChooser seletorArquivo = new JFileChooser();
seletorArquivo.setDialogTitle("Salvar arquivo");
seletorArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
int escolha = seletorArquivo.showSaveDialog(this);
if (escolha == JFileChooser.APPROVE_OPTION) {
File arquivo = seletorArquivo.getSelectedFile();
try {
FileWriter escritor = new FileWriter(arquivo + ".txt");
for (ArmazenamentoTomadaDePreço info : informacoes ) {
escritor.write("<tr style=\"cursor: default;\">\n");
escritor.write("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
escritor.write("<td style=\"width: 145px;\"><div align=\"center\">Tomada de Preço Nº"+ info.getNumeroTP()+"</div></td>\n");
escritor.write("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoTP()+".</div></td>\n");
escritor.write("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataTP()+"</div></td>\n");
escritor.write("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraTP()+"</div></td>\n"); 
escritor.write("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkTP()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
escritor.write("<td style=\"width: 88.9px;\"><div align=\"center\">-</div></td>\n");
escritor.write("<td style=\"width: 88.9px; text-align: center;\">-</td>\n");
escritor.write("</tr>\n");
escritor.write("\n");
}
escritor.close();
JOptionPane.showMessageDialog(this,"Dados salvos com sucesso!");
} catch (IOException ex) {
ex.printStackTrace();
}
}
}
public static void main(String[] args) {
new TelaTomadadePreço();
}
}

