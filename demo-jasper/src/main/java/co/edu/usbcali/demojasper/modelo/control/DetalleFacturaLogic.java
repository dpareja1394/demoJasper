package co.edu.usbcali.demojasper.modelo.control;

import co.edu.usbcali.demojasper.dataaccess.dao.*;
import co.edu.usbcali.demojasper.exceptions.*;
import co.edu.usbcali.demojasper.modelo.*;
import co.edu.usbcali.demojasper.modelo.dto.DetalleFacturaDTO;
import co.edu.usbcali.demojasper.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DetalleFacturaLogic")
public class DetalleFacturaLogic implements IDetalleFacturaLogic {
    private static final Logger log = LoggerFactory.getLogger(DetalleFacturaLogic.class);

    /**
     * DAO injected by Spring that manages DetalleFactura entities
     *
     */
    @Autowired
    private IDetalleFacturaDAO detalleFacturaDAO;

    /**
    * Logic injected by Spring that manages Factura entities
    *
    */
    @Autowired
    IFacturaLogic logicFactura1;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto2;

    @Transactional(readOnly = true)
    public List<DetalleFactura> getDetalleFactura() throws Exception {
        log.debug("finding all DetalleFactura instances");

        List<DetalleFactura> list = new ArrayList<DetalleFactura>();

        try {
            list = detalleFacturaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DetalleFactura failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DetalleFactura");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDetalleFactura(DetalleFactura entity)
        throws Exception {
        log.debug("saving DetalleFactura instance");

        try {
            if (entity.getFactura() == null) {
                throw new ZMessManager().new ForeignException("factura");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getFactura().getFactId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "factId_Factura");
            }

            if (entity.getProducto().getProdId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "prodId_Producto");
            }

            detalleFacturaDAO.save(entity);

            log.debug("save DetalleFactura successful");
        } catch (Exception e) {
            log.error("save DetalleFactura failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDetalleFactura(DetalleFactura entity)
        throws Exception {
        log.debug("deleting DetalleFactura instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DetalleFactura");
        }

        if (entity.getDefaId() == null) {
            throw new ZMessManager().new EmptyFieldException("defaId");
        }

        try {
            detalleFacturaDAO.delete(entity);

            log.debug("delete DetalleFactura successful");
        } catch (Exception e) {
            log.error("delete DetalleFactura failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDetalleFactura(DetalleFactura entity)
        throws Exception {
        log.debug("updating DetalleFactura instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DetalleFactura");
            }

            if (entity.getFactura() == null) {
                throw new ZMessManager().new ForeignException("factura");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getDefaId() == null) {
                throw new ZMessManager().new EmptyFieldException("defaId");
            }

            if (entity.getFactura().getFactId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "factId_Factura");
            }

            if (entity.getProducto().getProdId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "prodId_Producto");
            }

            detalleFacturaDAO.update(entity);

            log.debug("update DetalleFactura successful");
        } catch (Exception e) {
            log.error("update DetalleFactura failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DetalleFacturaDTO> getDataDetalleFactura()
        throws Exception {
        try {
            List<DetalleFactura> detalleFactura = detalleFacturaDAO.findAll();

            List<DetalleFacturaDTO> detalleFacturaDTO = new ArrayList<DetalleFacturaDTO>();

            for (DetalleFactura detalleFacturaTmp : detalleFactura) {
                DetalleFacturaDTO detalleFacturaDTO2 = new DetalleFacturaDTO();

                detalleFacturaDTO2.setDefaId(detalleFacturaTmp.getDefaId());
                detalleFacturaDTO2.setFactId_Factura((detalleFacturaTmp.getFactura()
                                                                       .getFactId() != null)
                    ? detalleFacturaTmp.getFactura().getFactId() : null);
                detalleFacturaDTO2.setProdId_Producto((detalleFacturaTmp.getProducto()
                                                                        .getProdId() != null)
                    ? detalleFacturaTmp.getProducto().getProdId() : null);
                detalleFacturaDTO.add(detalleFacturaDTO2);
            }

            return detalleFacturaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DetalleFactura getDetalleFactura(Integer defaId)
        throws Exception {
        log.debug("getting DetalleFactura instance");

        DetalleFactura entity = null;

        try {
            entity = detalleFacturaDAO.findById(defaId);
        } catch (Exception e) {
            log.error("get DetalleFactura failed", e);
            throw new ZMessManager().new FindingException("DetalleFactura");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DetalleFactura> findPageDetalleFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<DetalleFactura> entity = null;

        try {
            entity = detalleFacturaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DetalleFactura Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDetalleFactura() throws Exception {
        Long entity = null;

        try {
            entity = detalleFacturaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DetalleFactura Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<DetalleFactura> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DetalleFactura> list = new ArrayList<DetalleFactura>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = detalleFacturaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
