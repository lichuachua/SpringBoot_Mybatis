package com.lichuachua.blog.core.support.service.impl;

import com.lichuachua.blog.core.support.service.IBaseService;

/**
 * @author 段启岩
 * 通用Service实现类
 * @param <T> 实体表对应的Java类型
 * @param <K> 实体表主键对应的Java类型
 */
public class BaseServiceImpl<T, K> implements IBaseService<T, K> {

//    @Autowired
//    private JpaRepository<T, K> repository;
//
//    @Override
//    public List<T> select(T record) {
//        Example<T> example = Example.of(record);
//        return repository.findAll(example);
//    }
//
//    @Override
//    public Optional<T> selectByKey(K key) {
//        return repository.findById(key);
//    }
//
//    @Override
//    public List<T> selectAll() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Optional<T> selectOne(Example<T> example) {
//        return repository.findOne(example);
//    }
//
//    @Override
//    public int selectCount(T record) {
//        return 0;
//    }
//
//    @Override
//    public T save(T record) {
//        return repository.save(record);
//    }
//
//    @Override
//    public Iterable<T> batchSave(Iterable<T> list) {
//        return repository.saveAll(list);
//    }
//
//    @Override
//    public T update(T entity) {
//        return repository.save(entity);
//    }
//
//    @Override
//    public void delete(T record) {
//        repository.delete(record);
//    }
//
//    @Override
//    public void batchDelete(Iterable<T> list) {
//        repository.deleteInBatch(list);
//    }
//
//    @Override
//    public void deleteByKey(K key) {
//        repository.deleteById(key);
//    }
//
//    @Override
//    public List<T> selectByExample(Example<T> example) {
//        return repository.findAll(example);
//    }
//
//    @Override
//    public List<T> selectByExample(Example<T> example, Sort sort) {
//        return repository.findAll(example, sort);
//    }
//
//    @Override
//    public long selectCountByExample(Example<T> example) {
//        return repository.count(example);
//    }
//
//    @Override
//    public Page<T> selectPage(Example<T> example, Pageable pageable) {
//        return repository.findAll(example, pageable);
//    }

}
