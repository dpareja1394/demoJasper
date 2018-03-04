package co.edu.usbcali.demojasper.dataaccess.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.demojasper.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.demojasper.modelo.Producto;
import co.edu.usbcali.demojasper.modelo.dto.ProductoDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * Producto entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Producto
 */
@Scope("singleton")
@Repository("ProductoDAO")
public class ProductoDAO extends HibernateDaoImpl<Producto, Integer>
    implements IProductoDAO {
    private static final Logger log = LoggerFactory.getLogger(ProductoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IProductoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProductoDAO) ctx.getBean("ProductoDAO");
    }

	@Override
	public List<ProductoDTO> productosFactura(Integer factId) throws Exception {
		List	<ProductoDTO> lista = null;
		try {
			Query query = getSession().getNamedQuery("consultar_detalle_factura_dado_fact_id");
			query.setParameter("pFactId", factId);
			query.setResultTransformer(Transformers.aliasToBean(ProductoDTO.class));
			lista = query.list();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		return lista;
	}
}
