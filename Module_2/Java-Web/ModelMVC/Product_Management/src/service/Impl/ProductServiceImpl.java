package service.Impl;

import model.Product;
import service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> listProduct = new HashMap<>();

    static {
        listProduct.put(1,new Product(1,"Iphone 7","4.7 inches","Apple"));
        listProduct.put(2,new Product(2,"Iphone 7 plus","5.5 inches","Apple"));
        listProduct.put(3,new Product(3,"Iphone X","5.8 inches","Apple"));
        listProduct.put(4,new Product(4,"Redmi Note 8","6.3 inches","Xiaomi"));
        listProduct.put(5,new Product(5,"Vsmart Active 3","6.39 inches","Vin Group"));
    }

    @Override
    public List<Product> findAll()  {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(),product);
    }

    @Override
    public void update(int id, String name, String description, String manufacturer) {
        Product product = listProduct.get(id);
        product.setName(name);
        product.setDescription(description);
        product.setManufacturer(manufacturer);
    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listProductFilter = new ArrayList<>();
        Product tempProduct;
        Set<Integer> keyProductSet = listProduct.keySet();
        for (Integer key: keyProductSet) {
            tempProduct = listProduct.get(key);
            if (name.equals(tempProduct.getName())) {
                listProductFilter.add(tempProduct);
            }
        }
        return listProductFilter;
    }
}
