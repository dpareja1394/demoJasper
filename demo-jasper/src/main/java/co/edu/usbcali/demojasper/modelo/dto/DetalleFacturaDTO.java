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
public class DetalleFacturaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DetalleFacturaDTO.class);
    private Integer defaId;
    private Integer factId_Factura;
    private Integer prodId_Producto;

    public Integer getDefaId() {
        return defaId;
    }

    public void setDefaId(Integer defaId) {
        this.defaId = defaId;
    }

    public Integer getFactId_Factura() {
        return factId_Factura;
    }

    public void setFactId_Factura(Integer factId_Factura) {
        this.factId_Factura = factId_Factura;
    }

    public Integer getProdId_Producto() {
        return prodId_Producto;
    }

    public void setProdId_Producto(Integer prodId_Producto) {
        this.prodId_Producto = prodId_Producto;
    }
}
