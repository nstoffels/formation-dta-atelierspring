/**
 * 
 */
package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

/**
 * @author ETY
 *
 */
public class ReportService {
	
	private String auteur;
	private IReportGenerator ireportGenerator = null;
	/**
	 * 
	 */
	public ReportService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param ireportgenerator
	 */
	public ReportService(IReportGenerator ireportgenerator) {
		this.ireportGenerator = ireportgenerator;
	}

	/**
	 * appel à la couche technique
	 */
	public void generateDailyReport(){
		ireportGenerator.generate();
	}
	
	public void generateMonthlyReport(){
		ireportGenerator.generate(auteur);
	}
	
	
	/*
	 * 
	 * génération des getters et setters
	 * 
	 * 
	 */
	
	/**
	 * @return the ireportgenerator
	 */
	public IReportGenerator getIreportgenerator() {
		return ireportGenerator;
	}

	/**
	 * @param ireportgenerator the ireportgenerator to set
	 */
	public void setIreportgenerator(IReportGenerator ireportgenerator) {
		this.ireportGenerator = ireportgenerator;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the ireportGenerator
	 */
	public IReportGenerator getIreportGenerator() {
		return ireportGenerator;
	}

	/**
	 * @param ireportGenerator the ireportGenerator to set
	 */
	public void setIreportGenerator(IReportGenerator ireportGenerator) {
		this.ireportGenerator = ireportGenerator;
	}

	
	
}
