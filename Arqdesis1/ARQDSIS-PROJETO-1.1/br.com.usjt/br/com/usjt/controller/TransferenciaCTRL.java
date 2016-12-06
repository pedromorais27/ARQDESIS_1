package br.com.usjt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import javax.swing.JOptionPane;

import br.com.usjt.model.Transferencia;
import br.com.usjt.view.TelaSelecionarOpcoes;
import br.com.usjt.view.TelaTranferencia;

public class TransferenciaCTRL extends TelaTranferencia{
	public TransferenciaCTRL(Transferencia transferencia) throws ParseException {
		super(transferencia);
		addbtnVoltarListener(new BtnVoltarListener());
		addbtnContinuarListener(new BtnContinuarListener());
		addbtnLimparListener(new BtnLimparListener());
	}

	public void update(Observable arg0, Object arg1) {

	}

	class BtnVoltarListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			TelaSelecionarOpcoes selecionar = new TelaSelecionarOpcoes();
			selecionar.internacionalizar(getIdioma());
			selecionar.setNumConta(getNumConta());
			selecionar.setAgencia(getAgencia());
			selecionar.setTitle(getNomeCliente());
			selecionar.setNomeCliente(getNomeCliente());
			selecionar.setSize(500,300);
			selecionar.setVisible(true);
			dispose();
		}
	}

	class BtnContinuarListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

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
					if(rdbtnHoje.isSelected()){
						
						try { 
							getTransferencia().setContaDestino(getTxtConta());
						}catch(NumberFormatException erro){ 
							JOptionPane.showMessageDialog(null, "entre com uma conta valida"); 
							return; 
						}
						
						try { 
							getTransferencia().setAgenciaDestino(getTxtAgencia());
						}catch(NumberFormatException erro){ 
							JOptionPane.showMessageDialog(null, "entre com uma agencia valida"); 
							return; 
						}

						try { 
							getTransferencia().setValorDaOperacao(getTxtValor());
						}catch(NumberFormatException erro){ 
							JOptionPane.showMessageDialog(null, "entre com um valor valido"); 
							return; 
						}
						

						try { 
							Date data = new Date(); 						
							getTransferencia().setDataDoMovimento(data);
						}catch(NumberFormatException erro){ 
							JOptionPane.showMessageDialog(null, "entre com uma data valida"); 
							return; 
						}
												
						try { 
							getTransferencia().setConta(getNumConta());
						}catch(NumberFormatException erro){ 
							JOptionPane.showMessageDialog(null, "entre com uma conta valida"); 
							return; 
						}

						try {
							getTransferencia().fazeTransferencia();
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(rdbtnAgendadaPara.isSelected()){
						getTransferencia().setContaDestino(getTxtConta());
						getTransferencia().setAgenciaDestino(getTxtAgencia());
						getTransferencia().setValorDaOperacao(getTxtValor());
						try {
							getTransferencia().setDataDoMovimento(new SimpleDateFormat("dd/MM/yyyy").parse(getTxtData()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						getTransferencia().setConta(getNumConta());
						try {
							getTransferencia().fazeTransferencia();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Codigo de Acesso Incorreto");
				}		
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class BtnLimparListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			txtConta.setText("");
			txtValor.setText("");
			txtAgencia.setText("");
			txtData.setText("");
			passwordField.setText("");
		}
	}
}