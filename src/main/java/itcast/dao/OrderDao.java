package itcast.dao;

import itcast.domain.Order;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Select("SELECT * FROM tab_order o WHERE o.orderTime BETWEEN #{startTime} AND #{endTime}")
    List<Order> findByTime(Order order);
    @Select("SELECT * FROM tab_order WHERE oid =#{oid}")
    @Results({
            @Result(column = "oid",property = "oid"),
            @Result(column = "shopID",property = "shopID"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(
                    column = "oid",
                    property = "orderItemList",
                    many = @Many(select = "itcast.dao.OrderItemDao.findByOid")
            )
    })
    List<Order> selectByOid(String Oid);
}
