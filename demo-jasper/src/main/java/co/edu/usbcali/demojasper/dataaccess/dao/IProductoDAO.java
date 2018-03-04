package co.edu.usbcali.demojasper.dataaccess.dao;

import java.util.List;

import co.edu.usbcali.demojasper.dataaccess.api.Dao;
import co.edu.usbcali.demojasper.modelo.Producto;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;


/**
* Interface for   ProductoDAO.
*
*/
public interface IProductoDAO extends Dao<Producto, Integer> {
	
	public List<ProductoDTO> productosFactura(Integer factId) throws Exception;
}
