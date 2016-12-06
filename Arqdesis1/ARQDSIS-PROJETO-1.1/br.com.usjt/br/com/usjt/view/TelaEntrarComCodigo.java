package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.controller.AcessarContaCTRL;
import br.com.usjt.model.Acesso;


public class TelaEntrarComCodigo{
	private JButton btnLimpar, btnCancelar, btnOk, btnZero, btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis,
						btnSete, btnOito, btnNove;
	private JLabel lblEntreComO;
	private JPasswordField passwordField;
	private ResourceBundle resourseBundle;
	private ResourceBundle idioma;
	private int numConta, agencia;
	private String nome;
	private JFrame frame;

	public TelaEntrarComCodigo() {
		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLayout(new BorderLayout());	
		frame.setResizable(false);
		JPanel panelBotoes = new JPanel();
		
		JPanel layout = new JPanel();//cria um pane para serem inseridos os componentes


		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		lblEntreComO = new JLabel("Entre com o C\u00F3digo de Acesso");
		lblEntreComO.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnLimpar = new JButton("Limpar");
		btnCancelar = new JButton("Cancelar");
		btnOk = new JButton("OK");

		btnZero = new JButton("0");
		btnUm = new JButton("1");
		btnDois = new JButton("2");
		btnTres = new JButton("3");
		btnQuatro = new JButton("4");
		btnCinco = new JButton("5");
		btnSeis = new JButton("6");
		btnSete = new JButton("7");
		btnOito = new JButton("8");
		btnNove = new JButton("9");
	
		passwordField = new JPasswordField(3);

		grid.weightx = 2;//separa as linhas  

		grid.ipadx = 0; //define o tamanho das celulas
		grid.ipady = 5; //define o tamanho das coluna

		//adiciona a label no GridBagLayout
		grid.gridx = 3;
		grid.gridy = 2;
		layout.add(lblEntreComO, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 3;//clouna
		grid.gridy = 3;//linha
		layout.add(passwordField, grid);//aciciona a botao em forma de grid na Container

		grid.gridx = 5;//clouna
		grid.gridy = 6;//linha
		layout.add(btnZero, grid);//aciciona a botao em forma de grid na Container
		
		
		grid.gridx = 4;//clouna
		grid.gridy = 3;//linha
		layout.add(btnUm, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 3;//linha
		layout.add(btnDois, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 6;//clouna
		grid.gridy = 3;//linha
		layout.add(btnTres, grid);//aciciona a botao em forma de grid na Container

		grid.gridx = 4;//clouna
		grid.gridy = 4;//linha
		layout.add(btnQuatro, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 4;//linha
		layout.add(btnCinco, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 6;//clouna
		grid.gridy = 4;//linha
		layout.add(btnSeis, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 4;//clouna
		grid.gridy = 5;//linha
		layout.add(btnSete, grid);//aciciona a botao em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 5;//linha
		layout.add(btnOito, grid);//aciciona a botao em forma de grid na Container

		grid.gridx = 6;//clouna
		grid.gridy = 5;//linha
		layout.add(btnNove, grid);//aciciona a botao em forma de grid na Container

		passwordField.setEditable(false);
		
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "0";
				passwordField.setText(digitando);
			}
		});
		
		btnUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "1";
				passwordField.setText(digitando);
			}
		});
		
		btnDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "2";
				passwordField.setText(digitando);
			}
		});
		
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "3";
				passwordField.setText(digitando);
			}
		});
		
		btnQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "4";
				passwordField.setText(digitando);
			}
		});
		
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "5";
				passwordField.setText(digitando);
			}
		});
		
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "6";
				passwordField.setText(digitando);
			}
		});
		
		btnSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "7";
				passwordField.setText(digitando);
			}
		});
		
		btnOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "8";
				passwordField.setText(digitando);
			}
		});
		
		btnNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jaDigitado = String.valueOf(passwordField.getPassword());
				String digitando = jaDigitado + "9";
				passwordField.setText(digitando);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeAcesso login = new AcessarContaCTRL(new Acesso());
				login.setVisible(true);
				frame.dispose();
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			}
		});


		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileReader txtConta;
				try {
					txtConta = new FileReader (""+ getNumConta());
					BufferedReader entrada = null;
					entrada = new BufferedReader(txtConta);

					ArrayList<Integer> linhasTxt = new ArrayList<Integer>();

					String texto;

					while((texto = entrada.readLine()) != null){
						linhasTxt.add(Integer.parseInt(texto, 16));//converte de hexadecimal para inteiro	
					}

					int codAcesso = linhasTxt.get(3);

					if(codAcesso == Integer.parseInt(String.valueOf(passwordField.getPassword()))){
						
						TelaSelecionarOpcoes op = new TelaSelecionarOpcoes();
					
						op.internacionalizar(getIdioma()); 
						op.setAgencia(getAgencia());
						
						ContaDAO contaDAO = new ContaDAO();
						try {
							op.setNomeCliente(contaDAO.innerJoin(getNumConta()));
							setNome(contaDAO.innerJoin(getNumConta()));
							op.setTitle(getNome());
						} catch (ClassNotFoundException e1) {
				
							e1.printStackTrace();
						} catch (SQLException e1) {
				
							e1.printStackTrace();
						}
						
						op.setNumConta(getNumConta());
						op.setSize(500, 300);
						op.setVisible(true);
						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Codigo de Acesso Incorreto");
					}			
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		passwordField.addKeyListener(new KeyAdapter(){  
			public void keyTyped(KeyEvent e) {  
				if(passwordField.getPassword().length >= 3){ //limita a digitação no JPasswordField a 3 caracteeres  
					e.consume();  //não permite que se digite mais 
				}  
			}  
		});  
		
		frame.setSize(350,250);
		frame.setVisible(true);
		panelBotoes.add(btnOk);
		panelBotoes.add(btnLimpar);
		panelBotoes.add(btnCancelar);

		frame.add(layout, BorderLayout.NORTH);
		frame.add(panelBotoes, BorderLayout.SOUTH);
	
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public void internacionalizar(ResourceBundle idiomaEscolhido) {
		resourseBundle = idiomaEscolhido;

		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui

		//muda o idioma dos botões
		btnLimpar.setText(resourseBundle.getString("telaEntrarComCodigo.JButton.Limpar"));
		btnCancelar.setText(resourseBundle.getString("telaEntrarComCodigo.JButton.Cancelar"));

		//Muda o idioma da label
		lblEntreComO.setText(resourseBundle.getString("telaEntrarComCodigo.JLabel.lblEntreComO"));

		setIdioma(idiomaEscolhido);
	}
}