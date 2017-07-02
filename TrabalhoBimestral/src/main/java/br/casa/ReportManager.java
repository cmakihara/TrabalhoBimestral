package br.casa;

import java.sql.Connection;
import java.util.Locale;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager {
	
	private static final String JASPER_CONTATO = "C:\\Users\\Maki\\JaspersoftWorkspace\\MyReports\\dois.jasper";

	public void imprimir() {
		JasperPrint jasperPrintPDF = getPrint();
		Locale locale = Locale.getDefault();
		JasperViewer.viewReport(jasperPrintPDF,false,locale);
		
	}

	private JasperPrint getPrint() {
		Connection con = ConexaoDB.getInstance().getConnection();
		try {
			return JasperFillManager.fillReport(JASPER_CONTATO, null,con);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

}
