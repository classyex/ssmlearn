package com.github.classyex.web.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库通用接口
 * Created by yex on 16-10-10.
 */
interface Dao<T> {

    /**
     * 添加某个对象
     * @param t 待添加的对象
     * @return  返回受影响的行数
     */
    int add(T t);

    /**
     * 删除某个对象，在企业开发中，我们一般不做物理删除，只是添加某个字段对其数据进行可用控制
     * @param t 待删除对象
     * @return 返回受影响的条数
     */
    int  del(T t);

    /**
     * 更新某个对象
     * @param t 待更新对象
     * @return 返回受影响的条数
     */
    int update(T t);

    /**
     * 通过ID查找一个对象
     * @param Id    待查询的对象的ID
     * @return  返回该ID对应的对象
     */
    T findOneById(Serializable Id);

    /**
     * 查找对象集合
     * @return  返回对象集合
     */
    List<T> findAll();

}