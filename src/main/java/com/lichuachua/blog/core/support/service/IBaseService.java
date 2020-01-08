package com.lichuachua.blog.core.support.service;

/**
 * @author 段启岩
 * 通用Service接口类
 * @param <T> 实体表对应的Java类型
 * @param <K> 实体表主键对应的Java类型
 */
public interface IBaseService<T, K> {

//    /**
//     * 根据实体中的属性值进行查询, 查询条件使用等号  @param record the record
//     *
//     * @param record the record
//     *
//     * @return the list
//     */
//    List<T> select(T record);
//
//    /**
//     * 根据主键字段进行查询, 方法参数必须包含完整的主键属性, 查询条件使用等号  @param key the key
//     *
//     * @param key the key
//     *
//     * @return the t
//     */
//    Optional<T> selectByKey(K key);
//
//    /**
//     * 查询全部结果, select(null)方法能达到同样的效果  @return the list
//     *
//     * @return the list
//     */
//    List<T> selectAll();
//
//    /**
//     * 根据实体中的属性进行查询, 只能有一个返回值, 有多个结果是抛出异常, 查询条件使用等号  @param record the record
//     *
//     * @param record the record
//     *
//     * @return the t
//     */
//    Optional<T> selectOne(Example<T> record);
//
//    /**
//     * 根据实体中的属性查询总数, 查询条件使用等号  @param record the record
//     *
//     * @param record the record
//     *
//     * @return the int
//     */
//    int selectCount(T record);
//
//    /**
//     * 保存一个实体, null的属性不会保存, 会使用数据库默认值  @param record the record
//     *
//     * @param record the record
//     *
//     * @return the int
//     */
//    T save(T record);
//
//    /**
//     * 批量保存  @param list the list
//     *
//     * @param list the list
//     *
//     * @return the int
//     */
//    @Transactional
//    Iterable<T> batchSave(Iterable<T> list);
//
//    /**
//     * 根据主键更新属性不为null的值  @param entity the entity
//     *
//     * @param entity the entity
//     *
//     * @return the int
//     */
//    T update(T entity);
//
//    /**
//     * 根据实体属性作为条件进行删除, 查询条件使用等号  @param record the record
//     *
//     * @param record the record
//     *
//     * @return the int
//     */
//    void delete(T record);
//
//    /**
//     * 批量删除  @param list the list
//     *
//     * @param list the list
//     *
//     * @return the int
//     */
//    @Transactional
//    void batchDelete(Iterable<T> list);
//
//    /**
//     * 根据主键字段进行删除, 方法参数必须包含完整的主键属性  @param key the key
//     *
//     * @param key the key
//     *
//     * @return the int
//     */
//    void deleteByKey(K key);
//
//    /**
//     * 这个查询支持通过Example类指定查询列, 通过selectProperties方法指定查询列  @param example the example
//     *
//     * @param example the example
//     *
//     * @return the list
//     */
//    List<T> selectByExample(Example<T> example);
//
//    /**
//     * 根据条件查询
//     * @param example
//     * @param sort
//     * @return
//     */
//    public List<T> selectByExample(Example<T> example, Sort sort);
//
//    /**
//     * 根据Example条件进行查询总数  @param example the example
//     *
//     * @param example the example
//     *
//     * @return the int
//     */
//    long selectCountByExample(Example<T> example);
//
//    /**
//     * 分页查询数据
//     * @param example 查询条件
//     * @param pageable 分页请求参数
//     * @return
//     */
//    Page<T> selectPage(Example<T> example, Pageable pageable);

}
