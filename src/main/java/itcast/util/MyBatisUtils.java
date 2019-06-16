package itcast.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {
	//会话工厂
	private static SqlSessionFactory factory;
	/**初始化：会话工厂*/
	static{
		try{
			//1、获取资源流
			InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
			//2、获取会话工厂
			factory = new SqlSessionFactoryBuilder().build(is);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**使用ThreadLocal，管理某个线程的SqlSession*/
	private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
	/**获取新会话*/
	public static SqlSession openSession(){
		SqlSession session = null;
		session = local.get();
		if(session==null){
			session = factory.openSession();
			local.set(session);
		}
		return session;
	}
	/**关闭会话*/
	public static void close(){
		SqlSession session = local.get();
		if(session!=null){
			session.close();
			//不删除会导致线程再次使用到一个关闭的SqlSession会话
			local.remove();
		}
	}
	/**提交并关闭事务*/
	public static void commitAndClose(){
		SqlSession session = local.get();
		if(session!=null){
			session.commit();
			close();
		}
	}
	/**回滚并关闭事务*/
	public static void rollbackAndClose(){
		SqlSession session = local.get();
		if(session!=null){
			session.rollback();
			close();
		}
	}
	
	/**获取Mapper
	 * 注：若session已被关闭，必须重新调用getMapper获取新的Dao对象
	 * */
	public static <T> T getMapper(Class<T> clazz){
		return openSession().getMapper(clazz);
	}

}
