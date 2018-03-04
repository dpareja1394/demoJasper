package co.edu.usbcali.demojasper.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demojasper.modelo.Producto;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;
import co.edu.usbcali.demojasper.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.demojasper.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CrearProductoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CrearProductoView.class);
	private InputText txtDescripcion;
	private InputNumber txtPrecioUnitario;
	private List<ProductoDTO> productosDTO;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CrearProductoView() {
		super();
	}

	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputNumber getTxtPrecioUnitario() {
		return txtPrecioUnitario;
	}

	public void setTxtPrecioUnitario(InputNumber txtPrecioUnitario) {
		this.txtPrecioUnitario = txtPrecioUnitario;
	}

	public List<ProductoDTO> getProductosDTO() {
		try {
			if(productosDTO == null) {
				productosDTO= businessDelegatorView.getDataProducto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productosDTO;
	}

	public void setProductosDTO(List<ProductoDTO> productosDTO) {
		this.productosDTO = productosDTO;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	/* Acciones y Métodos */

	public void guardarProducto() {
		try {
			Producto producto = new Producto();
			producto.setDescripcion(txtDescripcion.getValue().toString());
			producto.setValorUnitario(Double.parseDouble(txtPrecioUnitario.getValue().toString()));

			businessDelegatorView.saveProducto(producto);

			FacesUtils.addInfoMessage("Se ha registrado el nuevo Producto " + producto.getDescripcion());
			
			limpiarFormulario();
			producto = null;
			
			productosDTO = null;
			getProductosDTO();

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public void limpiarFormulario() {
		txtDescripcion.setValue(null);
		txtPrecioUnitario.setValue(null);
	}
}
