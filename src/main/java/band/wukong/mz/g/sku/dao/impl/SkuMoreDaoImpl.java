package band.wukong.mz.g.sku.dao.impl;

import band.wukong.mz.base.exception.IllegalParameterException;
import band.wukong.mz.g.sku.bean.SkuMore;
import band.wukong.mz.g.sku.dao.SkuMoreDao;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
@IocBean(name = "skuMoreDao")
public class SkuMoreDaoImpl implements SkuMoreDao {

    @Inject
    private Dao dao;

    @Override
    public SkuMore find(long id) {
        return dao.fetch(SkuMore.class, id);
    }

    @Override
    public void update(SkuMore sm) {
        if (sm.getId() <= 0) {
            throw new IllegalParameterException();
        }

        dao.update(sm);
    }

    @Override
    public SkuMore findWithSku(long id) {
        SkuMore sm = dao.fetch(SkuMore.class, id);
        dao.fetchLinks(sm, "sku");
        return sm;
    }
}
