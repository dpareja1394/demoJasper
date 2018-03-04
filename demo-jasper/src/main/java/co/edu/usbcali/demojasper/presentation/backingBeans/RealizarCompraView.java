package co.edu.usbcali.demojasper.presentation.backingBeans;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demojasper.modelo.Cliente;
import co.edu.usbcali.demojasper.modelo.Factura;
import co.edu.usbcali.demojasper.modelo.Producto;
import co.edu.usbcali.demojasper.modelo.dto.ClienteDTO;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;
import co.edu.usbcali.demojasper.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.demojasper.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RealizarCompraView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RealizarCompraView.class);
	private List<ClienteDTO> clientesDTO;
	private List<ProductoDTO> productosDTO;
	private Cliente clienteSeleccionado;
	private Factura factura;
	private String nombreCliente;
	private boolean verListaClientes;
	private Producto productoSeleccionado;
	private List<ProductoDTO> productosAComprar;
	private String descripcionProducto;
	private boolean verIngresarCantidadProducto;
	private InputNumber txtCantidadProducto;
	private Integer facturaId;
	
	private StreamedContent fileReporteGenerado;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RealizarCompraView() {
		super();
	}

	public List<ClienteDTO> getClientesDTO() {
		try {
			if (clientesDTO == null) {
				clientesDTO = businessDelegatorView.getDataCliente();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientesDTO;
	}

	public void setClientesDTO(List<ClienteDTO> clientesDTO) {
		this.clientesDTO = clientesDTO;
	}

	public List<ProductoDTO> getProductosDTO() {
		try {
			if (productosDTO == null) {
				productosDTO = businessDelegatorView.getDataProducto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productosDTO;
	}

	public void setProductosDTO(List<ProductoDTO> productosDTO) {
		this.productosDTO = productosDTO;
	}

	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public boolean isVerListaClientes() {
		return verListaClientes;
	}

	public void setVerListaClientes(boolean verListaClientes) {
		this.verListaClientes = verListaClientes;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public List<ProductoDTO> getProductosAComprar() {
		return productosAComprar;
	}

	public void setProductosAComprar(List<ProductoDTO> productosAComprar) {
		this.productosAComprar = productosAComprar;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public boolean isVerIngresarCantidadProducto() {
		return verIngresarCantidadProducto;
	}

	public void setVerIngresarCantidadProducto(boolean verIngresarCantidadProducto) {
		this.verIngresarCantidadProducto = verIngresarCantidadProducto;
	}

	public InputNumber getTxtCantidadProducto() {
		return txtCantidadProducto;
	}

	public void setTxtCantidadProducto(InputNumber txtCantidadProducto) {
		this.txtCantidadProducto = txtCantidadProducto;
	}

	public String seleccionarCliente(ActionEvent actionEvent) {
		try {
			ClienteDTO clienteDTO = (ClienteDTO) (actionEvent.getComponent().getAttributes().get("clienteSeleccionado"));
			clienteSeleccionado = businessDelegatorView.getCliente(clienteDTO.getClieId());
			nombreCliente = (clienteSeleccionado!=null)?clienteSeleccionado.getNombreCompleto():null;
			setVerListaClientes(false);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}
	
	public void abrirDialogoSeleccionarUnCliente() {
		setVerListaClientes(true);
	}
	
	public String seleccionarProducto(ActionEvent actionEvent) {
		try {
			ProductoDTO productoDTO = (ProductoDTO)(actionEvent.getComponent().getAttributes().get("productoSeleccionado"));
			productoSeleccionado = businessDelegatorView.getProducto(productoDTO.getProdId());
			setVerIngresarCantidadProducto(true);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}
	
	public void agregarProductoALista() {
		try {
			ProductoDTO productoCarrito = new ProductoDTO();
			productoCarrito.setCantidad(Integer.parseInt(txtCantidadProducto.getValue().toString().trim()));
			productoCarrito.setDescripcion(productoSeleccionado.getDescripcion());
			productoCarrito.setProdId(productoSeleccionado.getProdId());
			productoCarrito.setValorUnitario(productoSeleccionado.getValorUnitario());
			productoCarrito.setValorTotal(productoCarrito.getValorUnitario()*productoCarrito.getCantidad());
			
			if(productosAComprar == null) {
				productosAComprar = new ArrayList<>();
			}
			productosAComprar.add(productoCarrito);
			txtCantidadProducto.setValue(null);
			setVerIngresarCantidadProducto(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void realizarCompra() {
		try {
			facturaId = businessDelegatorView.realizarCompra(clienteSeleccionado, productosAComprar);
			FacesUtils.addInfoMessage("El cliente "+clienteSeleccionado.getNombreCompleto()+" ha realizado una compra con factura "+facturaId);
			productosAComprar = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public StreamedContent getReportePdf() {

		try {
			List<ProductoDTO> productosComprados = businessDelegatorView.productosFactura(facturaId);
			ByteArrayInputStream bais = businessDelegatorView.generarFactura(facturaId, clienteSeleccionado.getNombreCompleto(), productosComprados);
			fileReporteGenerado = new DefaultStreamedContent(bais, "application/pdf", "Factura.pdf");
			return fileReporteGenerado;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			return null;
		}
	}
	
	
}
