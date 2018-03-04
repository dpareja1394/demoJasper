package co.edu.usbcali.demojasper.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class FacturaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(FacturaDTO.class);
    private String cabecera;
    private Integer factId;
    private Date fecha;
    private Integer clieId_Cliente;

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getFactId() {
        return factId;
    }

    public void setFactId(Integer factId) {
        this.factId = factId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getClieId_Cliente() {
        return clieId_Cliente;
    }

    public void setClieId_Cliente(Integer clieId_Cliente) {
        this.clieId_Cliente = clieId_Cliente;
    }
}
