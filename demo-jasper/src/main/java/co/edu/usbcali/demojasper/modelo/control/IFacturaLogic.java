package co.edu.usbcali.demojasper.modelo.control;

import java.io.ByteArrayInputStream;
import java.util.List;

import co.edu.usbcali.demojasper.modelo.Cliente;
import co.edu.usbcali.demojasper.modelo.Factura;
import co.edu.usbcali.demojasper.modelo.dto.FacturaDTO;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IFacturaLogic {
    public List<Factura> getFactura() throws Exception;

    /**
         * Save an new Factura entity
         */
    public void saveFactura(Factura entity) throws Exception;

    /**
         * Delete an existing Factura entity
         *
         */
    public void deleteFactura(Factura entity) throws Exception;

    /**
        * Update an existing Factura entity
        *
        */
    public void updateFactura(Factura entity) throws Exception;

    /**
         * Load an existing Factura entity
         *
         */
    public Factura getFactura(Integer factId) throws Exception;

    public List<Factura> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Factura> findPageFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberFactura() throws Exception;

    public List<FacturaDTO> getDataFactura() throws Exception;
    
    public Integer realizarCompra(Cliente cliente, List<ProductoDTO> productosAComprar) throws Exception;
    
    public ByteArrayInputStream generarFactura(Integer factId, String nombreCliente, List<ProductoDTO> productos) throws Exception;
}
