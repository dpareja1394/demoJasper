package co.edu.usbcali.demojasper.modelo.control;

import co.edu.usbcali.demojasper.modelo.DetalleFactura;
import co.edu.usbcali.demojasper.modelo.dto.DetalleFacturaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IDetalleFacturaLogic {
    public List<DetalleFactura> getDetalleFactura() throws Exception;

    /**
         * Save an new DetalleFactura entity
         */
    public void saveDetalleFactura(DetalleFactura entity)
        throws Exception;

    /**
         * Delete an existing DetalleFactura entity
         *
         */
    public void deleteDetalleFactura(DetalleFactura entity)
        throws Exception;

    /**
        * Update an existing DetalleFactura entity
        *
        */
    public void updateDetalleFactura(DetalleFactura entity)
        throws Exception;

    /**
         * Load an existing DetalleFactura entity
         *
         */
    public DetalleFactura getDetalleFactura(Integer defaId)
        throws Exception;

    public List<DetalleFactura> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DetalleFactura> findPageDetalleFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDetalleFactura() throws Exception;

    public List<DetalleFacturaDTO> getDataDetalleFactura()
        throws Exception;
}
