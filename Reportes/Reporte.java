/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
/*
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
*/
/**
 *
 * @author Juan Suaza
 */
public class Reporte {
    DAOReporte daoReporte;
    String ruta_absoluta;
    
    public Reporte(){
        daoReporte = new DAOReporte();
        ruta_absoluta = System.getProperty("user.dir");
    }
 /*   
    public void crearReportePasajerosSistema(){                
        ResultSet tabla = daoReporte.crearReportePasajerosSistema();
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reportePasajerosSistema.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReportePasajerosMovilizados(){
        ResultSet tabla = daoReporte.crearReportePasajerosMovilizados();
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reportePasajerosMovilizados.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReporteGanancias(String dia, String mes, String year){
        ResultSet tabla = daoReporte.crearReporteGanancias(dia, mes, year);
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reporteGanancia.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReporteListadoSolicitudes(String dia, String mes, String year){
        ResultSet tabla = daoReporte.crearReporteListadoSolicitudes(dia, mes, year);
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reporteListadoSolicitudes.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReporteListadoRutas(){
        ResultSet tabla = daoReporte.crearReporteListadoRutas();
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reporteListadoRutas.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReporteListadoBuses(){
        ResultSet tabla = daoReporte.crearReporteListadoBuses();
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reporteListadoBuses.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void crearReporteQuejas(){
        ResultSet tabla = daoReporte.crearReporteQuejas();
        
        try {
            ruta_absoluta += "\\src\\Reportes\\reporteQuejas.jrxml";
            System.out.println(ruta_absoluta);
            JasperReport jasperReport = JasperCompileManager.compileReport(ruta_absoluta);
            JRResultSetDataSource jasperReports = new JRResultSetDataSource(tabla);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jasperReports);
            JasperViewer.viewReport(jasperPrint, false);
            
            //String filename = null;
            //filename = "reporteCantidadVehiculos" + 5 + ".pdf";

            //Report saved in specified path
            //JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    */
}
