import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class TelaAtas extends JFrame {
private ArrayList<ArmazenamentoAta> informacoes = new ArrayList<ArmazenamentoAta>();
private JLabel labelLinkAta;
private JTextField campoLinkAta;
private JLabel labelNumeroAta;
private JTextField campoNumeroAta;
private JLabel labelObjetoAta;
private JTextField campoObjetoAta;
private JLabel labelFornecedoAta;
private JTextField campoFornecedorAta;
private JButton botaoAdicionar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Objeto", "Numero", "Link", "Fornecedor"};
private ArrayList<ArmazenamentoAta> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoAta> dados) {
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
ArmazenamentoAta info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getobjetoAta();
case 1:
return info.getnumeroAta();
case 2:
return info.getlinkAta();
case 3:
return info.getfornecedorAta();
default:
return null;
}
}
}
public TelaAtas() {
	
// Configurações da janela
setTitle("PUBLICANDO ATAS");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));
// Inicializando componentes
labelLinkAta = new JLabel("Link da Ata:");
labelLinkAta.setBounds(24, 23, 137, 14);
campoLinkAta = new JTextField(20);
campoLinkAta.setBounds(160, 20, 511, 20);
labelNumeroAta = new JLabel("Numero da Ata:");
labelNumeroAta.setBounds(24, 48, 137, 14);
campoNumeroAta = new JTextField(20);
campoNumeroAta.setBounds(160, 45, 511, 20);
labelObjetoAta = new JLabel("Objeto da Ata:");
labelObjetoAta.setBounds(24, 98, 137, 14);
campoObjetoAta = new JTextField(20);
campoObjetoAta.setBounds(160, 95, 511, 20);
labelFornecedoAta = new JLabel("Fornecedor:");
labelFornecedoAta.setBounds(24, 73, 137, 14);
campoFornecedorAta = new JTextField(20);
campoFornecedorAta.setBounds(160, 70, 511, 20);
botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 133, 149, 23);
botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,163,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,193,149,23);
tabelaInformacoes = new JTable();
scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 136, 452, 370);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);
// Adicionando componentes à janela
getContentPane().add(labelLinkAta);
getContentPane().add(campoLinkAta);
getContentPane().add(labelNumeroAta);
getContentPane().add(campoNumeroAta);
getContentPane().add(labelObjetoAta);
getContentPane().add(campoObjetoAta);
getContentPane().add(labelFornecedoAta);
getContentPane().add(campoFornecedorAta);
getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);
getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);
getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);
// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String linkAta = campoLinkAta.getText();
String numeroAta = campoNumeroAta.getText();
String objetoAta = campoObjetoAta.getText();
String fornecedorAta = campoFornecedorAta.getText();
ArmazenamentoAta info = new ArmazenamentoAta(linkAta, numeroAta, objetoAta, fornecedorAta);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campoLinkAta.setText("");
campoNumeroAta.setText("");
campoObjetoAta.setText("");
campoFornecedorAta.setText("");
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
	    for (ArmazenamentoAta info : informacoes) {
	      areaTexto.append("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">\n");
	      areaTexto.append("<td style=\"text-align: justify;\">"+ info.getnumeroAta() +"/2023</td>\n");
	      areaTexto.append("<td style=\"text-align: justify;\">"+ info.getobjetoAta()+".</td>\n");
	      areaTexto.append("<td style=\"text-align: justify;\">"+ info.getfornecedorAta()+"</td>\n");
	      areaTexto.append("<td><div align=\"center\"><a href=\"../../Atas/2023/"+ info.getlinkAta()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>\n"); 
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

// Adicionando ação para o botão de edição
botaoEditar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	int selectedRow = tabelaInformacoes.getSelectedRow();
	if (selectedRow != -1) {
	ArmazenamentoAta info = informacoes.get(selectedRow);
	campoLinkAta.setText(info.getlinkAta());
	campoNumeroAta.setText(info.getnumeroAta());
	campoObjetoAta.setText(info.getobjetoAta());
	campoFornecedorAta.setText(info.getfornecedorAta());



// Adicionando ação para o botão salvar alterações
	JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
	botaoSalvarAlteracoes.setBounds(505,223,149,23);
	add(botaoSalvarAlteracoes);
	botaoSalvarAlteracoes.addActionListener(new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
	        // Coletando as linhas selecionadas na tabela
	        int[] selectedRows = tabelaInformacoes.getSelectedRows();
	        for (int i = 0; i < selectedRows.length; i++) {
	           // Recuperando o objeto ArmazenamentoDecreto correspondente à linha selecionada
	           ArmazenamentoAta info = informacoes.get(selectedRows[i]);
	           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoDecreto
	           info.setlinkAta(campoLinkAta.getText());
	           info.setnumeroAta(campoNumeroAta.getText());
	           info.setobjetoAta(campoObjetoAta.getText());
	           info.setfornecedorAta(campoFornecedorAta.getText());
	        }
	        // Atualizando a tabela
	        tabelaInformacoes.updateUI();
	        ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();
	     }
	  });
}
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
private void setSize(Object setExtendedState) {
	// TODO Auto-generated method stub
	
}
private void setMinimumSize(int i, int j) {
	// TODO Auto-generated method stub
	
}
public void mostrarDados() {
for (ArmazenamentoAta info : informacoes ) {
System.out.println("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
System.out.println("<td style=\"text-align: justify;\">"+ info.getnumeroAta() +"/2023</td>");
System.out.println("<td style=\"text-align: justify;\">"+ info.getobjetoAta()+".</td>");
System.out.println("<td style=\"text-align: justify;\">"+ info.getfornecedorAta()+"</td>");
System.out.println("<td><div align=\"center\"><a href=\"../../Atas/2023/"+ info.getlinkAta()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>"); 
System.out.println("</tr>");
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
for (ArmazenamentoAta info : informacoes ) {
escritor.write("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getnumeroAta() +"/2023</td>\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getobjetoAta()+".</td>");
escritor.write("<td style=\"text-align: justify;\">"+ info.getfornecedorAta()+"</td>\n");
escritor.write("<td><div align=\"center\"><a href=\"../../Atas/2023/"+ info.getlinkAta()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>\n"); 
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
new TelaAtas();
}
}

