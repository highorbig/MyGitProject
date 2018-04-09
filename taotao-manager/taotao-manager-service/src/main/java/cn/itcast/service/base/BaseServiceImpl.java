package cn.itcast.service.base;

import cn.itcast.base.BaseService;
import cn.itcast.common.TaoResult;
import cn.itcast.pojo.BasePojo;
import cn.itcast.pojo.Item;
import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl<T extends BasePojo> implements BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    private Class<T> clazz;

    public BaseServiceImpl() {
        // 获取父类的type
        Type type = this.getClass().getGenericSuperclass();

        // 强转为ParameterizedType，可以使用获取泛型类型的方法
        ParameterizedType pType = (ParameterizedType) type;

        // 获取泛型的class
        this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
    }


    @Override
    public T queryById(Long id) {
        T t = this.mapper.selectByPrimaryKey(id);
        return t;
    }

    @Override
    public List<T> queryAll() {
        List<T> list = this.mapper.select(null);
        return list;
    }

    @Override
    public Integer queryCountByWhere(T t) {
        int count = this.mapper.selectCount(t);
        return count;
    }

    @Override
    public List<T> queryListByWhere(T t) {
        List<T> list = this.mapper.select(t);
        return list;
    }

    @Override
    public List<T> queryByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<T> list = this.mapper.select(null);
        return list;
    }

    @Override
    public T queryOne(T t) {
        T result = this.mapper.selectOne(t);
        return result;
    }

    @Override
    public void save(T t) {
        timeUpdate(t);


        this.mapper.insert(t);

    }

    private void timeUpdate(T t) {
        // 需要判断，如果调用者没有设置时间，则这里设置，如果设置了时间，则这里不设置了
        if (t.getCreated() == null) {
            t.setCreated(new Date());
            t.setUpdated(t.getCreated());
        } else if (t.getUpdated() == null) {
            t.setUpdated(t.getCreated());
        }
    }

    @Override
    public void saveSelective(T t) {
        // 需要判断，如果调用者没有设置时间，则这里设置，如果设置了时间，则这里不设置了
        timeUpdate(t);

        this.mapper.insertSelective(t);
    }

    @Override
    public void updateById(T t) {
        // 更新方法直接设置时间
        t.setUpdated(new Date());

        this.mapper.updateByPrimaryKey(t);
    }

    @Override
    public void updateByIdSelective(T t) {
        // 更新方法直接设置时间
        t.setUpdated(new Date());

        this.mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public void deleteById(Long id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Object> ids) {
        // 声明条件
        Example example = new Example(this.clazz);
        example.createCriteria().andIn("id", ids);

        this.mapper.deleteByExample(example);

    }

    @Override
    public TaoResult<T> queryListByPage(T param, Integer page, Integer rows, String updated_desc) {
        PageHelper.startPage(page,rows);
        PageHelper.orderBy(updated_desc);
        List<T> list = queryListByWhere(param);

        // 获取分页的详细数据
        PageInfo<T> pageInfo = new PageInfo<>(list);

        TaoResult<T>taoResult=new TaoResult<>();
        taoResult.setTotal(pageInfo.getTotal());
        taoResult.setRows(list);
        return taoResult;
    }
}
