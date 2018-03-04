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
import co.edu.usbcali.demojasper.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IClienteLogic clienteLogic;
    @Autowired
    private IDetalleFacturaLogic detalleFacturaLogic;
    @Autowired
    private IFacturaLogic facturaLogic;
    @Autowired
    private IProductoLogic productoLogic;

    public List<Cliente> getCliente() throws Exception {
        return clienteLogic.getCliente();
    }

    public void saveCliente(Cliente entity) throws Exception {
        clienteLogic.saveCliente(entity);
    }

    public void deleteCliente(Cliente entity) throws Exception {
        clienteLogic.deleteCliente(entity);
    }

    public void updateCliente(Cliente entity) throws Exception {
        clienteLogic.updateCliente(entity);
    }

    public Cliente getCliente(Integer clieId) throws Exception {
        Cliente cliente = null;

        try {
            cliente = clienteLogic.getCliente(clieId);
        } catch (Exception e) {
            throw e;
        }

        return cliente;
    }

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return clienteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return clienteLogic.findPageCliente(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCliente() throws Exception {
        return clienteLogic.findTotalNumberCliente();
    }

    public List<ClienteDTO> getDataCliente() throws Exception {
        return clienteLogic.getDataCliente();
    }

    public List<DetalleFactura> getDetalleFactura() throws Exception {
        return detalleFacturaLogic.getDetalleFactura();
    }

    public void saveDetalleFactura(DetalleFactura entity)
        throws Exception {
        detalleFacturaLogic.saveDetalleFactura(entity);
    }

    public void deleteDetalleFactura(DetalleFactura entity)
        throws Exception {
        detalleFacturaLogic.deleteDetalleFactura(entity);
    }

    public void updateDetalleFactura(DetalleFactura entity)
        throws Exception {
        detalleFacturaLogic.updateDetalleFactura(entity);
    }

    public DetalleFactura getDetalleFactura(Integer defaId)
        throws Exception {
        DetalleFactura detalleFactura = null;

        try {
            detalleFactura = detalleFacturaLogic.getDetalleFactura(defaId);
        } catch (Exception e) {
            throw e;
        }

        return detalleFactura;
    }

    public List<DetalleFactura> findByCriteriaInDetalleFactura(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return detalleFacturaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<DetalleFactura> findPageDetalleFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return detalleFacturaLogic.findPageDetalleFactura(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberDetalleFactura() throws Exception {
        return detalleFacturaLogic.findTotalNumberDetalleFactura();
    }

    public List<DetalleFacturaDTO> getDataDetalleFactura()
        throws Exception {
        return detalleFacturaLogic.getDataDetalleFactura();
    }

    public List<Factura> getFactura() throws Exception {
        return facturaLogic.getFactura();
    }

    public void saveFactura(Factura entity) throws Exception {
        facturaLogic.saveFactura(entity);
    }

    public void deleteFactura(Factura entity) throws Exception {
        facturaLogic.deleteFactura(entity);
    }

    public void updateFactura(Factura entity) throws Exception {
        facturaLogic.updateFactura(entity);
    }

    public Factura getFactura(Integer factId) throws Exception {
        Factura factura = null;

        try {
            factura = facturaLogic.getFactura(factId);
        } catch (Exception e) {
            throw e;
        }

        return factura;
    }

    public List<Factura> findByCriteriaInFactura(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return facturaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Factura> findPageFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return facturaLogic.findPageFactura(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberFactura() throws Exception {
        return facturaLogic.findTotalNumberFactura();
    }

    public List<FacturaDTO> getDataFactura() throws Exception {
        return facturaLogic.getDataFactura();
    }

    public List<Producto> getProducto() throws Exception {
        return productoLogic.getProducto();
    }

    public void saveProducto(Producto entity) throws Exception {
        productoLogic.saveProducto(entity);
    }

    public void deleteProducto(Producto entity) throws Exception {
        productoLogic.deleteProducto(entity);
    }

    public void updateProducto(Producto entity) throws Exception {
        productoLogic.updateProducto(entity);
    }

    public Producto getProducto(Integer prodId) throws Exception {
        Producto producto = null;

        try {
            producto = productoLogic.getProducto(prodId);
        } catch (Exception e) {
            throw e;
        }

        return producto;
    }

    public List<Producto> findByCriteriaInProducto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return productoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Producto> findPageProducto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return productoLogic.findPageProducto(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberProducto() throws Exception {
        return productoLogic.findTotalNumberProducto();
    }

    public List<ProductoDTO> getDataProducto() throws Exception {
        return productoLogic.getDataProducto();
    }

	@Override
	public Integer realizarCompra(Cliente cliente, List<ProductoDTO> productosAComprar) throws Exception {
		return facturaLogic.realizarCompra(cliente, productosAComprar);
	}

	@Override
	public List<ProductoDTO> productosFactura(Integer factId) throws Exception {
		return productoLogic.productosFactura(factId);
	}

	@Override
	public ByteArrayInputStream generarFactura(Integer factId, String nombreCliente, List<ProductoDTO> productos)
			throws Exception {
		return facturaLogic.generarFactura(factId, nombreCliente, productos);
	}
}
