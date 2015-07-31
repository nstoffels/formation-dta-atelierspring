/**
 * 
 */
package com.bankonet.report;

/**
 * @author ETY
 *
 */
public class HtmlReportGenerator extends ReportGenerator implements IReportGenerator {

	/**
	 * 
	 */
	public HtmlReportGenerator() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * implémentation de la méthode generate de l'interface IReportGenerator
	 */
	public void generate() {
		// TODO Auto-generated method stub
		System.out.println("génération du rapport html");
	}
	/**
	 * 
	 */
	public void generate(String auteur) {
		// TODO Auto-generated method stub
		this.generate();
		System.out.println("->Auteur : "+auteur);
	}

}
