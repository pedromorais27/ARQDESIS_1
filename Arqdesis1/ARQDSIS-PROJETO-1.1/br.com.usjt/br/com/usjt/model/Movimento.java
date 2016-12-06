package br.com.usjt.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import br.com.usjt.DAO.AcessoBD;
import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.DAO.MovimentoDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.MovimentoTO;

public class Movimento extends Observable{
	private int codigoMovimento;
	private Date dataDoMovimento;
	private double valorDaOperacao;
	private Log log;

	public int getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(int codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
		setChanged();
		notifyObservers();
	}


	public Date getDataDoMovimento() {
		return dataDoMovimento;
	}

	public void setDataDoMovimento(Date dataDoMovimento) {
		this.dataDoMovimento = dataDoMovimento;
		setChanged();
		notifyObservers();
	}

	public double getValorDaOperacao() {
		return valorDaOperacao;
	}

	public void setValorDaOperacao(double valorDaOperacao) {
		this.valorDaOperacao = valorDaOperacao;
		setChanged();
		notifyObservers();
	}

	public void geraMovimento(ContaTO contaTO, MovimentoTO movimentoTO, String tipo){
		MovimentoDAO movDAO = new MovimentoDAO();
		ContaDAO contaDAO = new ContaDAO();

		movDAO.insert(contaTO, movimentoTO /**agenciaDestino, contaDestino, **/, tipo);

		int codigoMovimento = movDAO.selecCodigo(contaTO.getNumConta());
		int codigoCliente = contaDAO.selectCodigoCliente(contaTO.getNumConta());

		log = new Log();
//		log.setAgencia(agencia);
//		log.setConta(conta);
		log.setCodigoMovimento(codigoMovimento);
		log.setCodigoCliente(codigoCliente);
		log.setDataOperacao(getDataDoMovimento());
		log.setValor(getValorDaOperacao());
		log.setOperacao(tipo);

//		log.incluir();		
	}

	public  ArrayList<Log>  consultarExtratoDias(Date dataInicial, Date dataFinal) throws SQLException{
		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<Log> resultadoPesquisa = new ArrayList<Log>();
		Connection conn = new AcessoBD().connection();

		MovimentoDAO movimentoDAO = new MovimentoDAO();

		ResultSet rs = null;

		try{
			rs = movimentoDAO.selecBetween(dataInicial, dataFinal).executeQuery();
			while (rs.next()){
				Log log = new Log();

				log.setCodigoMovimento(rs.getInt(1));
				log.setConta(rs.getInt(2));
				log.setDataOperacao(rs.getDate(3));
				log.setValor(rs.getDouble(4));
				log.setAgenciaDestino(rs.getInt(5));
				log.setContaDestino(rs.getInt(6));
				log.setCodigoCliente(rs.getInt(7));
				log.setOperacao(rs.getString(9));

				resultadoPesquisa.add(log);
			}
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1){
				System.out.print(e1.getStackTrace());
			}
		}
		return resultadoPesquisa;
	}

	public  ArrayList<Log>  consultarExtratoUltimosDias(int conta) throws SQLException{
		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<Log> resultadoPesquisa = new ArrayList<Log>();
		Connection conn = new AcessoBD().connection();

		MovimentoDAO movimentoDAO = new MovimentoDAO();

		ResultSet rs = null;


		try{
			rs = movimentoDAO.selec(conta).executeQuery();
			while (rs.next()){
				Log log = new Log();

				log.setCodigoMovimento(rs.getInt(1));
				log.setConta(rs.getInt(2));
				log.setDataOperacao(rs.getDate(3));
				log.setValor(rs.getDouble(4));
				log.setAgenciaDestino(rs.getInt(5));
				log.setContaDestino(rs.getInt(6));
				log.setCodigoCliente(rs.getInt(7));
				log.setOperacao(rs.getString(9));

				resultadoPesquisa.add(log);
			}
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1){
				System.out.print(e1.getStackTrace());
			}
		}
		return resultadoPesquisa;
	}
}