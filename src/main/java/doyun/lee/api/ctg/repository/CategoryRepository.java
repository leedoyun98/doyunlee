package doyun.lee.api.ctg.repository;

import doyun.lee.api.ctg.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


interface ICategoryRepository {}

public interface CategoryRepository extends JpaRepository<Category, Long>, ICategoryRepository {
	
}