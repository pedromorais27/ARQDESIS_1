package br.com.usjt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.usjt.model.Log;
import br.com.usjt.model.Movimento;
import br.com.usjt.view.TelaExtratoDaConta;
import br.com.usjt.view.TelaSelecionarOpcoes;

public class ExtratoContaCTRL extends TelaExtratoDaConta{
	public ExtratoContaCTRL(Movimento movimento){
		super(movimento);
		addBtnVoltarListener(new BtnVoltarListener());
		addBtnImprimirListener(new BtnImprimirListener());
		addBtnConsultarListener(new ConsultarListener());
	}

	public void update(Observable arg0, Object arg1) {

	}

	class BtnVoltarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			TelaSelecionarOpcoes selecionar = new TelaSelecionarOpcoes();
			selecionar.internacionalizar(getIdioma());
			selecionar.setTitle(getNomeCliente());
			selecionar.setNomeCliente(getNomeCliente());
			selecionar.setNumConta(getNumConta());
			selecionar.setAgencia(getAgencia());
			selecionar.setSize(500,300);
			selecionar.setVisible(true);
			visual(false);
			dispose();

		}
	}

	public void criaArquivoExtrato(String informacaoes){
		SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy" + " HH.mm.ss");//cria um tipo date para colocar a data de que foi criado o arquivo no nome do arquivo 
		Calendar data = Calendar.getInstance();

		File arquivo;

		String nomeArq = "Extrato da conta " + getNumConta() + " do dia e hora " + formatoData.format(data.getTime()) + ".txt";
		//criando arquivo para preencher com o extrato 
		try
		{
			arquivo = new File(nomeArq);
			arquivo.createNewFile();
			JOptionPane.showMessageDialog(null,"Arquivo '"+ nomeArq + "' criado!","Arquivo",1);
		}
		//mostrando erro em caso se nao for possivel gerar arquivo
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
		}


		try {

			FileWriter output = new FileWriter(new File(nomeArq),true);

			PrintWriter gravarArq = new PrintWriter(output, true);//coloca o arquivo na variavel para preenchelo (o true permite que escreve em um arquivo de texto ja preenchido)

			String newLine = System.getProperty("line.separator");

			String nomeDasColunas = "Codigo Movimento\t" + "Conta\t" + "Data Operacao\t" + "Valor\t" + "Agencia Destino\t" + "Conta Destino\t" + 
					"Codigo Cliente\t" + "Tipo de Operacao";

			gravarArq.format("\n" + nomeDasColunas + newLine + informacaoes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	class BtnImprimirListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(getselecionaPeriodo().getSelectedItem() ==  "Ultimos lançamentos"){

				String newLine = System.getProperty("line.separator");

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();
				
				try {
					ArrayList<Log> recuper = movimento.consultarExtratoUltimosDias(getNumConta());
					
					String informacaoesDoBanco = "";
					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						informacaoesDoBanco += listaLog.getCodigoMovimento() + "\t\t\t" + listaLog.getConta() + "\t" + f.format(listaLog.getDataOperacao()) +
								"\t" + listaLog.getValor() + "\t\t" + listaLog.getAgenciaDestino() + "\t\t" + listaLog.getContaDestino() + "\t\t" + listaLog.getCodigoCliente() 
								+ "\t" +  listaLog.getOperacao() + newLine;     
					}

					
					criaArquivoExtrato(informacaoesDoBanco);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}else if(getselecionaPeriodo().getSelectedItem() ==  "ultimos 7 dias"){

				String newLine = System.getProperty("line.separator");

				// data final igual a hoje  
				Date dataFinal = new Date();  

				// usa calendar para subtrair data  
				Calendar calendarData = Calendar.getInstance();  
				calendarData.setTime(dataFinal);  

				int numeroDiasParaSubtrair = -7;  //numeros  que serão subtraidos

				// achar data de início  

				calendarData.add(Calendar.DATE,numeroDiasParaSubtrair);  
				Date dataInicial = calendarData.getTime(); //pega a data de hoje   

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();

				try {
					ArrayList<Log> recuper = movimento.consultarExtratoDias(dataInicial, dataFinal);

					
					String informacaoesDoBanco = "";
					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						informacaoesDoBanco += listaLog.getCodigoMovimento() + "\t\t\t" + listaLog.getConta() + "\t" + f.format(listaLog.getDataOperacao()) +
								"\t" + listaLog.getValor() + "\t\t" + listaLog.getAgenciaDestino() + "\t\t" + listaLog.getContaDestino() + "\t\t" + listaLog.getCodigoCliente() 
								+ "\t" +  listaLog.getOperacao() + newLine;     
					}

					
					criaArquivoExtrato(informacaoesDoBanco);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}else if(getselecionaPeriodo().getSelectedItem() ==  "ultimos 15 dias"){

				String newLine = System.getProperty("line.separator");

				// data final igual a hoje  
				Date dataFinal = new Date();  

				// usa calendar para subtrair data  
				Calendar calendarData = Calendar.getInstance();  
				calendarData.setTime(dataFinal);  

				int numeroDiasParaSubtrair = -15;  //numeros  que serão subtraidos

				// achar data de início  

				calendarData.add(Calendar.DATE,numeroDiasParaSubtrair);  
				Date dataInicial = calendarData.getTime(); //pega a data de hoje   

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();

				try {
					ArrayList<Log> recuper = movimento.consultarExtratoDias(dataInicial, dataFinal);

					
					String informacaoesDoBanco = "";
					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						informacaoesDoBanco += listaLog.getCodigoMovimento() + "\t\t\t" + listaLog.getConta() + "\t" + f.format(listaLog.getDataOperacao()) +
								"\t" + listaLog.getValor() + "\t\t" + listaLog.getAgenciaDestino() + "\t\t" + listaLog.getContaDestino() + "\t\t" + listaLog.getCodigoCliente() 
								+ "\t" +  listaLog.getOperacao() + newLine;     
					}

					
					criaArquivoExtrato(informacaoesDoBanco);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}else if(getselecionaPeriodo().getSelectedItem() ==  ""){

				String newLine = System.getProperty("line.separator");
				

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					Date dataA = new SimpleDateFormat("dd/MM/yyyy").parse(getTxtDataA());
					Date dataDe =  new SimpleDateFormat("dd/MM/yyyy").parse(getTxtDataDe());
					

					Movimento movimento = new Movimento();

					ArrayList<Log> recuper = movimento.consultarExtratoDias(dataDe, dataA);

					String informacaoesDoBanco = "";
					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						informacaoesDoBanco += listaLog.getCodigoMovimento() + "\t\t\t" + listaLog.getConta() + "\t" + f.format(listaLog.getDataOperacao()) +
								"\t" + listaLog.getValor() + "\t\t" + listaLog.getAgenciaDestino() + "\t\t" + listaLog.getContaDestino() + "\t\t" + listaLog.getCodigoCliente() 
								+ "\t" +  listaLog.getOperacao() + newLine;     
					}					
					criaArquivoExtrato(informacaoesDoBanco);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class ConsultarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {

			if(getselecionaPeriodo().getSelectedItem() ==  "Ultimos lançamentos"){
				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();

				try {
					ArrayList<Log> recuper = movimento.consultarExtratoUltimosDias(getNumConta());

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int k = dtm.getRowCount();  

					try{
						if (k > 0){  
							for (int i=0;i<=k;i++){    
								dtm.removeRow(0);    
							}                
						}  

					}catch(Exception e){

					}

					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						dtm.addRow(new Object[] {listaLog.getCodigoMovimento(), listaLog.getConta() , f.format(listaLog.getDataOperacao()),
								listaLog.getValor(), listaLog.getAgenciaDestino(), listaLog.getContaDestino(), listaLog.getCodigoCliente(), listaLog.getOperacao()});

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(getselecionaPeriodo().getSelectedItem() ==  "ultimos 7 dias"){

				// data final igual a hoje  
				Date dataFinal = new Date();  

				// usa calendar para subtrair data  
				Calendar calendarData = Calendar.getInstance();  
				calendarData.setTime(dataFinal);  

				int numeroDiasParaSubtrair = -7;  //numeros  que serão subtraidos

				// achar data de início  

				calendarData.add(Calendar.DATE,numeroDiasParaSubtrair);  
				Date dataInicial = calendarData.getTime(); //pega a data de hoje   

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();

				try {
					ArrayList<Log> recuper = movimento.consultarExtratoDias(dataInicial, dataFinal);

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int k = dtm.getRowCount();  

					try{
						if (k > 0){  
							for (int i=0;i<=k;i++){    
								dtm.removeRow(0);    
							}                
						}  

					}catch(Exception e){

					}

					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						dtm.addRow(new Object[] {listaLog.getCodigoMovimento(), listaLog.getConta() , f.format(listaLog.getDataOperacao()),
								listaLog.getValor(), listaLog.getAgenciaDestino(), listaLog.getContaDestino(), listaLog.getCodigoCliente(), listaLog.getOperacao()});

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(getselecionaPeriodo().getSelectedItem() ==  "ultimos 15 dias"){

				// data final igual a hoje  
				Date dataFinal = new Date();  

				// usa calendar para subtrair data  
				Calendar calendarData = Calendar.getInstance();  
				calendarData.setTime(dataFinal);  

				int numeroDiasParaSubtrair = -15;  //numeros  que serão subtraidos

				// achar data de início  

				calendarData.add(Calendar.DATE,numeroDiasParaSubtrair);  
				Date dataInicial = calendarData.getTime(); //pega a data de hoje   

				// cria o formatador  
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

				Movimento movimento = new Movimento();

				ArrayList<Log> recuper;
				try {
					recuper = movimento.consultarExtratoDias(dataInicial, dataFinal);

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int k = dtm.getRowCount();  

					try{
						if (k > 0){  
							for (int i=0;i<=k;i++){    
								dtm.removeRow(0);    
							}                
						}  

					}catch(Exception e){

					}

					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						dtm.addRow(new Object[] {listaLog.getCodigoMovimento(), listaLog.getConta() , f.format(listaLog.getDataOperacao()),
								listaLog.getValor(), listaLog.getAgenciaDestino(), listaLog.getContaDestino(), listaLog.getCodigoCliente(), listaLog.getOperacao()});

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}else if(getselecionaPeriodo().getSelectedItem() ==  ""){
				try {
					Date dataA = new SimpleDateFormat("dd/MM/yyyy").parse(getTxtDataA());
					Date dataDe =  new SimpleDateFormat("dd/MM/yyyy").parse(getTxtDataDe());

					Movimento movimento = new Movimento();

					ArrayList<Log> recuper = movimento.consultarExtratoDias(dataDe, dataA);


					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int k = dtm.getRowCount();  

					try{
						if (k > 0){  
							for (int i=0;i<=k;i++){    
								dtm.removeRow(0);    
							}                
						}  
					}catch(Exception e){
					}
					SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
						Log listaLog = it.next();

						dtm.addRow(new Object[] {listaLog.getCodigoMovimento(), listaLog.getConta() , f.format(listaLog.getDataOperacao()),
								listaLog.getValor(), listaLog.getAgenciaDestino(), listaLog.getContaDestino(), listaLog.getCodigoCliente(), listaLog.getOperacao()});
					}

				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null,"Favor entre com uma data valida ou selecione um pediodo");
					e.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}