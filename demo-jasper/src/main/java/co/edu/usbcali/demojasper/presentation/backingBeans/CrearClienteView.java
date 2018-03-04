package co.edu.usbcali.demojasper.presentation.backingBeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.inputtext.InputText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demojasper.modelo.Cliente;
import co.edu.usbcali.demojasper.modelo.dto.ClienteDTO;
import co.edu.usbcali.demojasper.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.demojasper.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CrearClienteView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CrearClienteView.class);
	private InputText txtIdentificacion, txtNombreCompleto;
	private List<ClienteDTO> clientesDTO;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CrearClienteView() {
		super();
	}

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public InputText getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	public void setTxtNombreCompleto(InputText txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	/*Acciones y Métodos*/
	
	public List<ClienteDTO> getClientesDTO() {
		try {
			if(clientesDTO == null) {
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

	public void guardarCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdentificacion(txtIdentificacion.getValue().toString());
			cliente.setNombreCompleto(txtNombreCompleto.getValue().toString());
			
			businessDelegatorView.saveCliente(cliente);
			FacesUtils.addInfoMessage("Se ha registrado el nuevo cliente");
			limpiarFormulario();
			cliente = null;
			clientesDTO = null;
			getClientesDTO();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpiarFormulario() {
		txtIdentificacion.setValue(null);
		txtNombreCompleto.setValue(null);
	}
}
