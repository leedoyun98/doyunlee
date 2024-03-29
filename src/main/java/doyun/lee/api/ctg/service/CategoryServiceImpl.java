package doyun.lee.api.ctg.service;

import java.util.List;
import java.util.Optional;


import doyun.lee.api.cmm.service.AbstractService;
import doyun.lee.api.ctg.domain.Category;
import doyun.lee.api.ctg.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
	private final CategoryRepository repo;
	
	@Override public long save(Category t) { return (repo.save(t) != null) ? 1 : 0; }
	@Override public long count() { return (long)repo.count(); }
	@Override public Category getOne(long id) { return repo.getOne(id); }
	@Override public Optional<Category> findById(long id) { return repo.findById(id); }
	@Override public boolean existsById(long id) { return repo.existsById(id); }
	@Override public List<Category> findAll() { return repo.findAll(); }
	@Override public long delete(Category t) { repo.delete(t); return (getOne(t.getCtgNo()) == null) ? 1 : 0; }
}