package doyun.lee.api.prd.service;

import doyun.lee.api.prd.domain.Product;

import java.util.List;


public interface ProductService {
	public List<Product> findByPrdNo(long prdNo);
	public List<Product> findByPrdNameContaining(String ctgName);
	public List<Product> findByCtgName(String ctgName);
	public String deleteById(long prdNo);
}