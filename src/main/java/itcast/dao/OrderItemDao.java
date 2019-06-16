package itcast.dao;

import itcast.domain.OrderItem;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderItemDao {
    @Select("select * from order_item where oid = #{oid}")
    @Results({
            /*  @Result(column = "oid",property = "oid"),
                @Result(column = "pid",property = "pid"),
                @Result(column = "num",property = "num"),
                @Result(column = "price",property = "price"),   */
            @Result(
                    column = "pid",
                    property = "product",
                    one = @One(select = "itcast.dao.ProductDao.selectProductByID")
            )
    })
    List<OrderItem> findByOid(String oid);
}
