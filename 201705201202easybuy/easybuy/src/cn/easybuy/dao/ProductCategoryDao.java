package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.ProductCategory;

public interface ProductCategoryDao {
	public List<ProductCategory> getProductCategories(Long parentId);
}
