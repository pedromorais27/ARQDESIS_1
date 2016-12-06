package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.usjt.controller.AcessarContaCTRL;
import br.com.usjt.model.Acesso;

public class TelaGerarCodigo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoGerado;
	private JButton btnSeguir, btnCancelar, btnGerar;
	private ResourceBundle resourseBundle;;
	private JLabel lblPrimeiroAcessoEm;
	private int numConta, agencia;
	private ResourceBundle idioma;

	public TelaGerarCodigo() {
		setBounds(100, 100, 517, 314);

		setResizable(false);

		setTitle("Gerar codigo de acesso");

		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		txtCodigoGerado = new JTextField();
		txtCodigoGerado.setColumns(10);
		txtCodigoGerado.setEditable(false);

		lblPrimeiroAcessoEm = new JLabel(
				"Primeiro acesso em sua conta, segue seu codigo de acesso para os proximos acessos");

		btnCancelar = new JButton("Cancelar");

		btnSeguir = new JButton("Seguir");

		btnGerar = new JButton("Gerar");

		grid.weightx = 1;//separa as colunas
		grid.weighty = 1;//separa as linhas 

		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 0;
		layout.add(lblPrimeiroAcessoEm, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 2;
		layout.add(txtCodigoGerado, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 2;//clouna
		grid.gridy = 5;//linha
		layout.add(btnSeguir, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 3;//clouna
		grid.gridy = 5;//linha
		layout.add(btnCancelar, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 5;//linha
		layout.add(btnGerar, grid);//aciciona a botao em forma de grid na Container

		btnSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCodigoGerado.getText().trim().equals("")  ){
					JOptionPane.showMessageDialog(null, "Por favor, clique no botão gerar!");
				}else{
					TelaEntrarComCodigo cod = new TelaEntrarComCodigo();
					cod.setNumConta(getNumConta());
					cod.setAgencia(getAgencia());
					cod.setIdioma(getIdioma());
					dispose();
				}
			}
		});

		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigoGerado = "";
				for(int x = 0; x<3; x++){
					int i = (int)(0+ (Math.random()*9));
					codigoGerado += i;
				}

				txtCodigoGerado.setText(codigoGerado);
				Acesso acesso = new Acesso();

				FileWriter output;
				try {
					output = new FileWriter(new File("" + getNumConta()), true);
					PrintWriter gravarArq = new PrintWriter(output, true);//coloca o arquivo na variavel para preenchelo (o true permite que escreve em um arquivo de texto ja preenchido)

					String codigoGeradoHex = Integer.toHexString(Integer.parseInt(codigoGerado));
					gravarArq.format("\n" + codigoGeradoHex);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDeAcesso login = new AcessarContaCTRL(new Acesso());
				login.setVisible(true);
				dispose();
			}
		});
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public void internacionalizar(ResourceBundle idiomaEscolhido) {

		resourseBundle = idiomaEscolhido;
		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui

		lblPrimeiroAcessoEm.setText(resourseBundle.getString("telaGerarCodigo.JLabel.PrimeiroAcessoEmSuaConta"));
		btnCancelar.setText(resourseBundle.getString("telaGerarCodigo.JButton.Cancelar"));
		btnSeguir.setText(resourseBundle.getString("telaGerarCodigo.JButton.Seguir"));
		btnGerar.setText(resourseBundle.getString("telaGerarCodigo.JButton.Gerar"));
		setIdioma(idiomaEscolhido);
	}
}