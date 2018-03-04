package co.edu.usbcali.demojasper.presentation.businessDelegate;

import co.edu.usbcali.demojasper.modelo.Cliente;
import co.edu.usbcali.demojasper.modelo.DetalleFactura;
import co.edu.usbcali.demojasper.modelo.Factura;
import co.edu.usbcali.demojasper.modelo.Producto;
import co.edu.usbcali.demojasper.modelo.control.ClienteLogic;
import co.edu.usbcali.demojasper.modelo.control.DetalleFacturaLogic;
import co.edu.usbcali.demojasper.modelo.control.FacturaLogic;
import co.edu.usbcali.demojasper.modelo.control.IClienteLogic;
import co.edu.usbcali.demojasper.modelo.control.IDetalleFacturaLogic;
import co.edu.usbcali.demojasper.modelo.control.IFacturaLogic;
import co.edu.usbcali.demojasper.modelo.control.IProductoLogic;
import co.edu.usbcali.demojasper.modelo.control.ProductoLogic;
import co.edu.usbcali.demojasper.modelo.dto.ClienteDTO;
import co.edu.usbcali.demojasper.modelo.dto.DetalleFacturaDTO;
import co.edu.usbcali.demojasper.modelo.dto.FacturaDTO;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Cliente> getCliente() throws Exception;

    public void saveCliente(Cliente entity) throws Exception;

    public void deleteCliente(Cliente entity) throws Exception;

    public void updateCliente(Cliente entity) throws Exception;

    public Cliente getCliente(Integer clieId) throws Exception;

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCliente() throws Exception;

    public List<ClienteDTO> getDataCliente() throws Exception;

    public List<DetalleFactura> getDetalleFactura() throws Exception;

    public void saveDetalleFactura(DetalleFactura entity)
        throws Exception;

    public void deleteDetalleFactura(DetalleFactura entity)
        throws Exception;

    public void updateDetalleFactura(DetalleFactura entity)
        throws Exception;

    public DetalleFactura getDetalleFactura(Integer defaId)
        throws Exception;

    public List<DetalleFactura> findByCriteriaInDetalleFactura(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DetalleFactura> findPageDetalleFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDetalleFactura() throws Exception;

    public List<DetalleFacturaDTO> getDataDetalleFactura()
        throws Exception;

    public List<Factura> getFactura() throws Exception;

    public void saveFactura(Factura entity) throws Exception;

    public void deleteFactura(Factura entity) throws Exception;

    public void updateFactura(Factura entity) throws Exception;

    public Factura getFactura(Integer factId) throws Exception;

    public List<Factura> findByCriteriaInFactura(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Factura> findPageFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberFactura() throws Exception;

    public List<FacturaDTO> getDataFactura() throws Exception;

    public List<Producto> getProducto() throws Exception;

    public void saveProducto(Producto entity) throws Exception;

    public void deleteProducto(Producto entity) throws Exception;

    public void updateProducto(Producto entity) throws Exception;

    public Producto getProducto(Integer prodId) throws Exception;

    public List<Producto> findByCriteriaInProducto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Producto> findPageProducto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProducto() throws Exception;

    public List<ProductoDTO> getDataProducto() throws Exception;
    
    public Integer realizarCompra(Cliente cliente, List<ProductoDTO> productosAComprar) throws Exception;
    
    public List<ProductoDTO> productosFactura(Integer factId) throws Exception;
    
    public ByteArrayInputStream generarFactura(Integer factId, String nombreCliente, List<ProductoDTO> productos) throws Exception;
    
}
