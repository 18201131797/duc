package com.tkmybatis.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description: serviceimpl基类，有所serviceimpl都需继承
 * @Author: liwt
 * @date: 2019/5/30 14:07
 */

public abstract class IBaseServiceImpl<T> implements IBaseService<T> {

    protected abstract IBaseMapper<T> mapper();

    /**
     * @version 1.0.0.0
     * @Description: 查询全部结果
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public List<T> selectAll() {
        return mapper().selectAll();
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public List<T> select(T record) {
        return mapper().select(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int delete(T record) {
        return mapper().delete(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件删除数据
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int deleteByExample(Object example) {
        return mapper().deleteByExample(example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int deleteByPrimaryKey(Object key) {
        return mapper().deleteByPrimaryKey(key);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public boolean existsWithPrimaryKey(Object key) {
        return mapper().existsWithPrimaryKey(key);
    }

    /**
     * @version 1.0.0.0
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int insert(T record) {
        return mapper().insert(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int insertSelective(T record) {
        return mapper().insertSelective(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public List<T> selectByExample(Object example) {
        return mapper().selectByExample(example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据example条件和RowBounds进行分页查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public T selectByPrimaryKey(Object key) {
        return mapper().selectByPrimaryKey(key);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体属性和RowBounds进行分页查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return mapper().selectByRowBounds(record, rowBounds);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int selectCount(T record) {
        return mapper().selectCount(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询总数
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int selectCountByExample(Object example) {
        return mapper().selectCountByExample(example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public T selectOne(T record) {
        return mapper().selectOne(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public T selectOneByExample(Object example) {
        return mapper().selectOneByExample(example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件更新实体`record`包含的全部属性，null值会被更新
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int updateByExample(T record, Object example) {
        return mapper().updateByExample(record, example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件更新实体`record`包含的不是null的属性值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int updateByExampleSelective(T record, Object example) {
        return mapper().updateByExampleSelective(record, example);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int updateByPrimaryKey(T record) {
        return mapper().updateByPrimaryKey(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据主键更新属性不为null的值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    public int updateByPrimaryKeySelective(T record) {
        return mapper().updateByPrimaryKeySelective(record);
    }


    /**
     * @version 1.0.0.0
     * @Description: 批量插入
     * @Author: liwt
     * @date: 2019/7/03 10:54
     */
    public int insertList(List<T> recordList) {
        return mapper().insertList(recordList);
    }

    /**
     * @version 1.0.0.0
     * @Description: 插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
     * @Author: liwt
     * @date: 2019/7/03 10:54
     */
    public int insertUseGeneratedKeys(T record) {
        return mapper().insertUseGeneratedKeys(record);
    }

    /**
     * @version 1.0.0.0
     * @Description: 分页获取所有数据
     * @Author: liwt
     * @date: 2019/7/03 10:06
     */
    public PageInfo selectPage(Integer pageNum, Integer pageSize, String... orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy.length > 0 ? orderBy[0] : "");
        List<T> list = mapper().selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据实体获取分页数据
     * @Author: liwt
     * @date: 2019/7/03 10:40
     */
    public PageInfo selectPageByEntity(T record, Integer pageNum, Integer pageSize, String... orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy.length > 0 ? orderBy[0] : "");
        List<T> list = mapper().select(record);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据Example获取分页数据
     * @Author: liwt
     * @date: 2019/7/03 10:49
     */
    public PageInfo selectPageByExample(Object example, Integer pageNum, Integer pageSize, String... orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy.length > 0 ? orderBy[0] : "");
        List<T> list = mapper().selectByExample(example);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }
}
