package itcast.dao;

import itcast.domain.Product;
import itcast.domain.Shop;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopDao {
    @Select("SELECT * FROM tab_shop WHERE shopName = #{shopName}")
    @Results({
            @Result(column = "shopID" ,property = "shopID"),
            @Result(column = "shopName" ,property = "shopName"),
            @Result(
                    column = "shopID",
                    property = "productList",
                    many = @Many(select = "itcast.dao.ProductDao.selectByShopID")
            )
    })
    Shop findProductByShopName(Shop shop);
}
