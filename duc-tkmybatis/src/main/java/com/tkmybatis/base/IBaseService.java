package com.tkmybatis.base;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description: service基类，有所service都需继承
 * @Author: liwt
 * @date: 2019/5/30 14:06
 */
public interface IBaseService<T> {

    /**
     * @version 1.0.0.0
     * @Description: 查询全部结果
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    List<T> selectAll();

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    List<T> select(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int delete(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件删除数据
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int deleteByExample(Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int deleteByPrimaryKey(Object key);

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    boolean existsWithPrimaryKey(Object key);

    /**
     * @version 1.0.0.0
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int insert(T record);

    /**
     * @version 1.0.0.0
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int insertSelective(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    List<T> selectByExample(Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据example条件和RowBounds进行分页查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

    /**
     * @version 1.0.0.0
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    T selectByPrimaryKey(Object key);

    /**
     * @version 1.0.0.0
     * @Description: 根据实体属性和RowBounds进行分页查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    List<T> selectByRowBounds(T record, RowBounds rowBounds);

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int selectCount(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询总数
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int selectCountByExample(Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    T selectOne(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件进行查询
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    T selectOneByExample(Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件更新实体`record`包含的全部属性，null值会被更新
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int updateByExample(@Param("record") T record, @Param("example") Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example条件更新实体`record`包含的不是null的属性值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    /**
     * @version 1.0.0.0
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int updateByPrimaryKey(T record);

    /**
     * @version 1.0.0.0
     * @Description: 根据主键更新属性不为null的值
     * @Author: liwt
     * @date: 2019/5/30 14:06
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * @version 1.0.0.0
     * @Description: 批量插入
     * @Author: liwt
     * @date: 2019/7/03 10:54
     */
    int insertList(List<T> recordList);

    /**
     * @version 1.0.0.0
     * @Description: 插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
     * @Author: liwt
     * @date: 2019/7/03 10:54
     */
    int insertUseGeneratedKeys(T record);

    /**
     * @version 1.0.0.0
     * @Description: 分页获取所有数据
     * @Author: liwt
     * @date: 2019/7/03 10:06
     */
    PageInfo selectPage(Integer pageNum,Integer pageSize,String ... orderBy);

    /**
     * @version 1.0.0.0
     * @Description: 根据实体获取分页数据
     * @Author: liwt
     * @date: 2019/7/03 10:40
     */
    PageInfo selectPageByEntity(T record,Integer pageNum,Integer pageSize,String ... orderBy);

    /**
     * @version 1.0.0.0
     * @Description: 根据Example获取分页数据
     * @Author: liwt
     * @date: 2019/7/03 10:49
     */
    PageInfo selectPageByExample(Object example,Integer pageNum,Integer pageSize,String ... orderBy);


}
