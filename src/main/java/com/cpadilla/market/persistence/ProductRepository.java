package com.cpadilla.market.persistence;

import com.cpadilla.market.domain.Product;
import com.cpadilla.market.domain.repository.IProductRepository;
import com.cpadilla.market.persistence.crud.ProductCrudRepository;
import com.cpadilla.market.persistence.entity.ProductEntity;
import com.cpadilla.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // since this class performs database operations, is a good practice indicate to spring this is a repository class
public class ProductRepository implements IProductRepository {

    @Autowired // dependency injection through spring in order to avoid instantiation of these attributes internally, and use them
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(productEntities);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> productEntities = productCrudRepository.findByCategoryIdOrderByName(categoryId);
        return Optional.of(mapper.toProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> productEntities = productCrudRepository.findByAmountStockLessThanAndStatus(quantity, true);
        return productEntities.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));

    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }

    @Override
    public Product save(Product product) {
        ProductEntity prodEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productCrudRepository.save(prodEntity));
    }


}
