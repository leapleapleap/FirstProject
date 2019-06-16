package itcast.dao;

import itcast.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Update("INSERT INTO tab_product VALUES(#{pid},#{productName},#{productPrice},#{storeNum},#{factory},#{shopID})")
    void insertProduct(Product product);
    @Select("SELECT * FROM tab_product p WHERE p.pid=#{pid}")
    Product selectProductByID(String pid);
    @Select("SELECT * FROM tab_product p WHERE p.productName LIKE #{productName} AND p.factory LIKE #{factory}")
    List<Product> selectByNameOrFactory(Product product);
    @Select("SELECT * FROM tab_product WHERE shopID =#{shopID}")
    List<Product> selectByShopID(String shopID);



}
