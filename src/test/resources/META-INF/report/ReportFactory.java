/**
 * 
 */
package com.bankonet.report;


/**
 * @author ETY
 *
 */
public class ReportFactory {

	/**
	 * 
	 */
	public  ReportFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ReportGenerator createReport(String reportType){

		if(reportType.equals("html")){
			 return new HtmlReportGenerator();
		}else if(reportType.equals("pdf")){
			 return new PdfReportGenerator();
		}else{
			throw new IllegalArgumentException("mauvais choix");
		}


	}

}
