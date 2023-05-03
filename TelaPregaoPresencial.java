import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;




public class TelaPregaoPresencial extends JFrame {
private ArrayList<ArmazenamentoPregaoPresencial> informacoes = new ArrayList<ArmazenamentoPregaoPresencial>();
private JLabel labelLinkPregao;
private JTextField campoLinkPregao;
private JLabel labelNumeroPregao;
private JTextField campoNumeroPregao;
private JLabel labelNumeroProcesso;
private JTextField campoNumeroProcesso;
private JLabel labelDescricaoPregao;
private JTextField campoDescricaoPregao;
private JLabel labelDataPregao;
private JTextField campoDataPregao;
private JLabel labelHoraPregao;
private JTextField campoHoraPregao;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Pregão", "Processo", "Link", "Descrição", "Data", "Hora"};
private ArrayList<ArmazenamentoPregaoPresencial> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoPregaoPresencial> dados) {
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
	ArmazenamentoPregaoPresencial info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getNumeroProcesso();
case 1:
return info.getNumeroPregao();
case 2:
return info.getLinkPregao();
case 3:
return info.getDescricaoPregao();
case 4:
return info.getDataPregao();
case 5:
return info.getHoraPregao();
default:
return null;
}
}
}
public TelaPregaoPresencial() {
// Configurações da janela
setTitle("PUBLICANDO EDITAIS - Pregão Presencial");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));


// Inicializando componentes
labelLinkPregao = new JLabel("Link do Pregão:");
labelLinkPregao.setBounds(24, 23, 137, 14);
campoLinkPregao = new JTextField(20);
campoLinkPregao.setBounds(160, 20, 511, 20);

labelNumeroPregao = new JLabel("Numero do Pregão:");
labelNumeroPregao.setBounds(24, 48, 137, 14);
campoNumeroPregao = new JTextField(20);
campoNumeroPregao.setBounds(160, 45, 191, 20);

labelNumeroProcesso = new JLabel("Numero do Processo:");
labelNumeroProcesso.setBounds(357, 48, 132, 14);
campoNumeroProcesso = new JTextField(20);
campoNumeroProcesso.setBounds(487, 45, 184, 20);

labelDescricaoPregao = new JLabel("Descrição:");
labelDescricaoPregao.setBounds(24, 76, 137, 14);
campoDescricaoPregao = new JTextField(20);
campoDescricaoPregao.setBounds(160, 73, 511, 20);

labelDataPregao = new JLabel("Data:");
labelDataPregao.setBounds(24, 105, 137, 14);
campoDataPregao = new JTextField(20);
campoDataPregao.setBounds(160, 101, 191, 20);

labelHoraPregao = new JLabel("Horário:");
labelHoraPregao.setBounds(357, 105, 66, 14);
campoHoraPregao = new JTextField(20);
campoHoraPregao.setBounds(422, 104, 249, 20);

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
getContentPane().add(labelLinkPregao);
getContentPane().add(campoLinkPregao);

getContentPane().add(labelNumeroPregao);
getContentPane().add(campoNumeroPregao);

getContentPane().add(labelNumeroProcesso);
getContentPane().add(campoNumeroProcesso);

getContentPane().add(labelDescricaoPregao);
getContentPane().add(campoDescricaoPregao);

getContentPane().add(labelDataPregao);
getContentPane().add(campoDataPregao);

getContentPane().add(labelHoraPregao);
getContentPane().add(campoHoraPregao);

getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);

getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);

getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);




// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

	String LinkPregao = campoLinkPregao.getText();
	String NumeroPregao = campoNumeroPregao.getText();
	String NumeroProcesso = campoNumeroProcesso.getText();
	String DescricaoPregao = campoDescricaoPregao.getText();
	String DataPregao = campoDataPregao.getText();
	String HoraPregao = campoHoraPregao.getText();



ArmazenamentoPregaoPresencial info = new ArmazenamentoPregaoPresencial(LinkPregao, NumeroPregao, NumeroProcesso, DescricaoPregao, DataPregao, HoraPregao);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campoLinkPregao.setText("");
campoNumeroPregao.setText("");
campoNumeroProcesso.setText("");
campoDescricaoPregao.setText("");
campoDataPregao.setText("");
campoHoraPregao.setText("");
}
});

//Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoPregaoPresencial info = informacoes.get(selectedRow);
			campoNumeroProcesso.setText(info.getNumeroProcesso());
			campoNumeroPregao.setText(info.getNumeroPregao());
			campoLinkPregao.setText(info.getLinkPregao());
			campoDescricaoPregao.setText(info.getDescricaoPregao());
			campoDataPregao.setText(info.getDataPregao());
			campoHoraPregao.setText(info.getHoraPregao());
		
		// Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,234,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoPregaoPresencial correspondente à linha selecionada
			           ArmazenamentoPregaoPresencial info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoPregaoPresencial
			           info.setNumeroProcesso(campoNumeroProcesso.getText());
			           info.setNumeroPregao(campoNumeroPregao.getText());
			           info.setLinkPregao(campoLinkPregao.getText());
						info.setDescricaoPregao(campoDescricaoPregao.getText());
						info.setDataPregao(campoDataPregao.getText());
						info.setHoraPregao(campoHoraPregao.getText());
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
	    for (ArmazenamentoPregaoPresencial info : informacoes ) {
	    	areaTexto.append("<tr style=\"cursor: default;\">");
	    	areaTexto.append("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
	    	areaTexto.append("<td style=\"width: 145px;\"><div align=\"center\">Pregão Presencial Nº"+ info.getNumeroPregao()+"</div></td>\n");
	    	areaTexto.append("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoPregao()+".</div></td>\n");
	    	areaTexto.append("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataPregao()+"</div></td>\n");
	    	areaTexto.append("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraPregao()+"</div></td>\n"); 
	    	areaTexto.append("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkPregao()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
for (ArmazenamentoPregaoPresencial info : informacoes ) {
	System.out.println("<tr style=\"cursor: default;\">");
	  System.out.println("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
	  System.out.println("<td style=\"width: 145px;\"><div align=\"center\">Pregão Presencial Nº"+ info.getNumeroPregao()+"</div></td>\n");
	  System.out.println("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoPregao()+".</div></td>\n");
	  System.out.println("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataPregao()+"</div></td>\n");
	  System.out.println("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraPregao()+"</div></td>\n"); 
	  System.out.println("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkPregao()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
for (ArmazenamentoPregaoPresencial info : informacoes ) {
escritor.write("<tr style=\"cursor: default;\">");
escritor.write("<td style=\"width: 148px;\"><div align=\"center\">Processo Nº"+ info.getNumeroProcesso()+"/2023</div></td>\n");
escritor.write("<td style=\"width: 145px;\"><div align=\"center\">Pregão Presencial Nº"+ info.getNumeroPregao()+"</div></td>\n");
escritor.write("<td style=\"width: 646px;\"><div align=\"justify\">"+ info.getDescricaoPregao()+".</div></td>\n");
escritor.write("<td style=\"width: 111px;\"><div align=\"center\">"+info.getDataPregao()+"</div></td>\n");
escritor.write("<td style=\"width: 95px;\"><div align=\"center\">"+info.getHoraPregao()+"</div></td>\n"); 
escritor.write("<td style=\"width: 88.9px;\"><div align=\"center\"><a href=\"../../editais/2023/"+ info.getLinkPregao()+".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
new TelaPregaoPresencial();
}
}

