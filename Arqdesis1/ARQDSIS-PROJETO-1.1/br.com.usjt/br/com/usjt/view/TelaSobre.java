package br.com.usjt.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;


public class TelaSobre extends JFrame{


	public TelaSobre() {
		setTitle("Sobre");
		setBounds(100,100,325,170);
		setLayout(new FlowLayout());
		setResizable(false);

		// Create the StyleContext, the document and the pane
		StyleContext sc = new StyleContext();
		DefaultStyledDocument doc = new DefaultStyledDocument(sc);
		JTextPane pane = new JTextPane(doc);

		pane.setEditable(false);
	
		String text = "\tUnivesidade São Judas Tadeu\n" 
				+ "\tFaculdade de Tecnologia e Ciências Exatas \n"
				+ "\tCiência da computação\n"
				+ "\t\tCCO3AN-BUA\n"
				+ "\t\tARQDSIS\n"
				+ "\nProjeto Integrado - Caixa Eletronico\n"
				+ "\n@autor nome: Anderson de Oliveira Santos RA:201310251\n"
				+ "@autor nome: Gabrielle Rodrigues Castelo RA:201415109";

		

		try {
			doc.insertString(0, text, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().add(new JScrollPane(pane));
	}
}
