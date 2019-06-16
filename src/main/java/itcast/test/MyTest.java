package itcast.test;


import itcast.dao.OrderDao;
import itcast.dao.ProductDao;
import itcast.dao.ShopDao;
import itcast.domain.Order;
import itcast.domain.OrderItem;
import itcast.domain.Product;
import itcast.domain.Shop;
import itcast.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 该类不允许做任何修改
 */
public class MyTest {

    /**
     * 保存商品到表中
     */
    @Test
    public void t1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        Product p = new Product();
        p.setPid("p21");
        p.setFactory("小米");
        p.setProductName("红米7");
        p.setStoreNum(20);
        p.setProductPrice(1888.8f);
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        mapper.insertProduct(p);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据商品ID查询商品
     */
    @Test
    public void t2(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        Product p10 = mapper.selectProductByID("p10");
        System.out.println(p10);//打印效果：Product{pid='p10', productName='note7小米', productPrice=1300.0, productNum=30, factory='小米'}
        sqlSession.close();
    }

    /**
	 * t3_A  t3_B 两个方法都可以实现本需求，只需选择一个方法实现即可
	 *
     * 根据商品名称或者生产厂家进行模糊查询
     * 需要考虑查询时候商品名称为null或者空串，以及厂家名称为null或者空串情况，保证程序正确执行且结果正确
     * 例如：商品名称==null,生产厂家!=null,则只查询厂家名称包含指定的厂家名称的商品
     *      商品名称!=null,生产厂家==null, 则只查询商品名称包含指定的商品名称的商品
     *      商品名称!=null,生产厂家!=null, 则查询商品名称包含指定的商品名称,并且厂家名称包含指定的厂家名称的商品
	 *
	 *	
     */
    @Test
    public void t3_A(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        Product p = new Product();
		
        p.setProductName("%Plus%");
        p.setFactory("%华%");

        List<Product> products = mapper.selectByNameOrFactory(p);
        for (Product product : products) {
            System.out.println(product);
        }
        /*
        参考打印信息如下：
        Product{pid='p1', productName='华为Mate20Plus', productPrice=5000.0, productNum=50, factory='华为'}
        Product{pid='p8', productName='华为Mate20Plus', productPrice=3999.0, productNum=50, factory='华为'}
        Product{pid='p9', productName='华为Mate20Plus', productPrice=5299.0, productNum=20, factory='华为'}
         */
    }

	/*@Test
    public void t3_B(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductDao itcast = sqlSession.getMapper(ProductDao.class);
        Product p = new Product();
	
		p.setProductName("Plus");
        p.setFactory("华");
		
        List<Product> products = itcast.selectByNameOrFactory(p);
        for (Product product : products) {
            System.out.println(product);
        }
    }*/
        /*
        参考打印信息如下：
        Product{pid='p1', productName='华为Mate20Plus', productPrice=5000.0, productNum=50, factory='华为'}
        Product{pid='p8', productName='华为Mate20Plus', productPrice=3999.0, productNum=50, factory='华为'}
        Product{pid='p9', productName='华为Mate20Plus', productPrice=5299.0, productNum=20, factory='华为'}
         */

	

    /**
     * 根据时间范围查询订单
     * 注意考虑可能时间只有一个，或者都没有，必须保证程序都能正确执行查询结果
     * 例如：startTime!=null,endTime==null ,则查询大于等于startTime的订单
     *       startTime==null,endTime!=null ,则查询小于等于endTime的订单
     *       startTime!=null,endTime!=null ,则查询大于等于startTime并且小于等于endTime的订单
     */
    @Test
    public void t4() throws ParseException {
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Date startTime = sdf.parse("2019-03-20");
        Date endTime = sdf.parse("2019-03-23");
        Order dtoOrder = new Order();
        dtoOrder.setStartTime(startTime);
        dtoOrder.setEndTime(endTime);
        List<Order> orders = mapper.findByTime(dtoOrder);
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
        /*
        参考打印信息如下：
        Order{oid='o2', orderStatus='支付完成', orderTime=Fri Mar 22 19:09:56 CST 2019}
        Order{oid='o3', orderStatus='支付完成', orderTime=Fri Mar 22 22:31:27 CST 2019}
        Order{oid='o4', orderStatus='待支付', orderTime=Fri Mar 22 08:10:22 CST 2019}
         */
    }

    /**
     * 根据店铺名称查询该店铺中所有的商品信息
     */
    @Test
    public void t5(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        ShopDao mapper = sqlSession.getMapper(ShopDao.class);
        Shop shop = new Shop();
        shop.setShopName("星际数码");
        Shop tempShop = mapper.findProductByShopName(shop);
        List<Product> plist = tempShop.getProductList();
        for (Product product : plist) {
            System.out.println(product);
        }
        /*
        参考打印信息如下：
        Product{pid='p10', productName='note7小米', productPrice=1300.0, productNum=30, factory='小米'}
        Product{pid='p4', productName='HUAWEI Mate20', productPrice=4000.0, productNum=50, factory='华为'}
        Product{pid='p5', productName='三星S10', productPrice=7000.0, productNum=60, factory='三星'}
        Product{pid='p8', productName='华为Mate20Plus', productPrice=3999.0, productNum=50, factory='华为'}
         */
    }

    /**
     * 根据订单ID查询订单下所有的商品
     * 打印订单信息和订单对应的商品信息
     */
    @Test
    public void t6(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        List<Order> orders = mapper.selectByOid("o1");
        for (Order order : orders) {
            System.out.println(order);
            List<OrderItem> itemList = order.getOrderItemList();
            for (OrderItem orderItem : itemList) {
                Product product = orderItem.getProduct();
                System.out.println(product);
            }
        }
        sqlSession.close();
        /*
        参考打印信息如下：
        Order{oid='o1', orderStatus='支付完成', orderTime=Sat Mar 16 18:29:09 CST 2019}
        Product{pid='p3', productName='荣耀10华为', productPrice=1300.0, productNum=100, factory='华为'}
        Product{pid='p5', productName='三星S10', productPrice=7000.0, productNum=60, factory='三星'}
         */
    }

}
