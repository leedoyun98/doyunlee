package doyun.lee.api.cmm.service;

import doyun.lee.api.cmm.utl.Pagination;

import java.util.List;
import java.util.Optional;


public abstract class AbstractService<T> {
	public abstract long save(T t);
	public abstract long delete(T t);
	public abstract long count();
	public abstract T getOne(long id);
	public abstract Optional<T> findById(long id);
	public abstract boolean existsById(long id);
	public abstract List<T> findAll();



}