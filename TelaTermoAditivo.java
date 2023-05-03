import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;




public class TelaTermoAditivo extends JFrame {
private ArrayList<ArmazenamentoTermoAditivo> informacoes = new ArrayList<ArmazenamentoTermoAditivo>();
private JLabel labelLinkTermo;
private JTextField campoLinkTermo;
private JLabel labelNumeroTermo;
private JTextField campoNumeroTermo;
private JLabel labelDescricaoTermo;
private JTextField campoDescricaoTermo;
private JLabel labelEmpresaContratada;
private JTextField campoEmpresaContratada;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Descrição", "Número", "Link", "Empresa Contratada"};
private ArrayList<ArmazenamentoTermoAditivo> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoTermoAditivo> dados) {
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
	ArmazenamentoTermoAditivo info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getDescricaoTermo();
case 1:
return info.getNumeroTermo();
case 2:
return info.getLinkTermo();
case 3:
return info.getEmpresaContratada();

default:
return null;
}
}
}
public TelaTermoAditivo() {
// Configurações da janela
setTitle("PUBLICANDO TERMOS ADITIVOS");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));


// Inicializando componentes
labelLinkTermo = new JLabel("Link do Termo:");
labelLinkTermo.setBounds(24, 23, 137, 14);
campoLinkTermo = new JTextField(20);
campoLinkTermo.setBounds(160, 20, 511, 20);

labelNumeroTermo = new JLabel("Numero do Termo:");
labelNumeroTermo.setBounds(24, 48, 137, 14);
campoNumeroTermo = new JTextField(20);
campoNumeroTermo.setBounds(160, 45, 70, 20);

labelDescricaoTermo = new JLabel("Descrição do Termo:");
labelDescricaoTermo.setBounds(24, 76, 132, 14);
campoDescricaoTermo = new JTextField(20);
campoDescricaoTermo.setBounds(160, 73, 511, 20);

labelEmpresaContratada = new JLabel("Empresa Contratada em MAIUSCULAS:");
labelEmpresaContratada.setBounds(240, 48, 229, 14);
campoEmpresaContratada = new JTextField(20);
campoEmpresaContratada.setBounds(467, 45, 204, 20);


botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 104, 149, 23);

botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,134,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,164,149,23);

tabelaInformacoes = new JTable();
scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 104, 452, 402);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);





// Adicionando componentes à janela
getContentPane().add(labelLinkTermo);
getContentPane().add(campoLinkTermo);

getContentPane().add(labelNumeroTermo);
getContentPane().add(campoNumeroTermo);

getContentPane().add(labelDescricaoTermo);
getContentPane().add(campoDescricaoTermo);

getContentPane().add(labelEmpresaContratada);
getContentPane().add(campoEmpresaContratada);

getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);

getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);

getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);




// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

	String LinkTermo = campoLinkTermo.getText();
	String NumeroTermo = campoNumeroTermo.getText();
	String DescricaoTermo = campoDescricaoTermo.getText();
	String EmpresaContratada = campoEmpresaContratada.getText();




ArmazenamentoTermoAditivo info = new ArmazenamentoTermoAditivo(LinkTermo, NumeroTermo, DescricaoTermo, EmpresaContratada);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campoLinkTermo.setText("");
campoNumeroTermo.setText("");
campoDescricaoTermo.setText("");
campoEmpresaContratada.setText("");
}
});

//Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoTermoAditivo info = informacoes.get(selectedRow);
			campoDescricaoTermo.setText(info.getDescricaoTermo());
			campoNumeroTermo.setText(info.getNumeroTermo());
			campoLinkTermo.setText(info.getLinkTermo());
			campoEmpresaContratada.setText(info.getEmpresaContratada());
		
		
		// Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,194,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoTermoAditivo correspondente à linha selecionada
			           ArmazenamentoTermoAditivo info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoTermoAditivo
			           info.setDescricaoTermo(campoDescricaoTermo.getText());
			           info.setNumeroTermo(campoNumeroTermo.getText());
			           info.setLinkTermo(campoLinkTermo.getText());
						info.setEmpresaContratada(campoEmpresaContratada.getText());
	
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
	    for (ArmazenamentoTermoAditivo info : informacoes ) {
	    	areaTexto.append("<tr style=\"cursor: default;\">");
	    	areaTexto.append("<td>"+info.getNumeroTermo()+"/2023</td>\n");
	    	areaTexto.append("<td>"+info.getDescricaoTermo()+".</td>\n");
	    	areaTexto.append("<td>"+info.getEmpresaContratada()+"</td>\n");
	    	areaTexto.append("<td><div align=\"center\"><a href=\"../../Termos_Aditivos/2023/"+info.getLinkTermo()+".pdf\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n"); 
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
	for (ArmazenamentoTermoAditivo info : informacoes ) {
		  System.out.println("<tr style=\"cursor: default;\">");
		  System.out.println("<td>"+info.getNumeroTermo()+"/2023</td>\n");
		  System.out.println("<td>"+info.getDescricaoTermo()+".</td>\n");
		  System.out.println("<td>"+info.getEmpresaContratada()+"</td>\n");
		  System.out.println("<td><div align=\"center\"><a href=\"../../Termos_Aditivos/2023/"+info.getLinkTermo()+".pdf\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n"); 
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
for (ArmazenamentoTermoAditivo info : informacoes ) {
escritor.write("<tr style=\"cursor: default;\">");
escritor.write("<td>"+info.getNumeroTermo()+"/2023</td>\n");
escritor.write("<td>"+info.getDescricaoTermo()+".</td>\n");
escritor.write("<td>"+info.getEmpresaContratada()+"</td>\n");
escritor.write("<td><div align=\"center\"><a href=\"../../Termos_Aditivos/2023/"+info.getLinkTermo()+".pdf\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n"); 
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
new TelaTermoAditivo();
}
}

