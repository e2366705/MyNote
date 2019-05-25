
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUD_Test {



   // 返回 SqlSession
   public static SqlSession get_SqlSession() throws IOException {
       //ͨ定义SqlSession
       SqlSession sqlSession = null;

       //读取MyBatis的全局配置文件
       //  一定要把 resources 文件成为 Sources Root 文件夹   切记切记 !!!!!
       String resource = "mybatis-config.xml";

       //读取MyBatis的全局配置文件
       InputStream inputStream = Resources.getResourceAsStream(resource);

       //根据流对象获取会话工厂sqlSessionFactory
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

       //创建会话sqlSession
       sqlSession = sqlSessionFactory.openSession();
       return sqlSession;
   }


   @Test
   public void mainnn() {
       System.out.println("CRUD_Test.main");
   }




   // 增加(Create)
   // 查询(Retrieve)
   // 更新(Update)
   // 删除(Delete)


   //  retrieve
   @Test
   public void selectByPrimaryKey() throws Exception {
       SqlSession session = get_SqlSession();

       UserTMapper userTMapper = session.getMapper(UserTMapper.class);
       UserT userT = userTMapper.selectByPrimaryKey(0);   // 主键查询
       System.err.println(userT.getUsername() + "  " + userT.getPassword());
       session.close();
   }


   // 自定义查询条件 - 模糊查询
   @Test
   public void selectByExample() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserTMapper userTMapper = sqlSession.getMapper(UserTMapper.class);

       UserTExample userTExample = new UserTExample();
       UserTExample.Criteria criteria = userTExample.createCriteria();

       // 注意!!  查询的关键字需要加上 % % 才可以拼接成功 (模糊查询)
       criteria.andUsernameLike("%ja%");
       List<UserT> list = userTMapper.selectByExample(userTExample);
       for(UserT userT : list){
           System.err.println(userT.getUsername());
           System.err.println(userT.getPassword());
           System.out.println("--------------------------------------");
       }
   }

   // 自定义查询条件 - or 语句
   @Test
   public void selectByExample_or() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserTMapper userTMapper = sqlSession.getMapper(UserTMapper.class);

       UserTExample userTExample = new UserTExample();
       UserTExample.Criteria criteria = userTExample.createCriteria();
       criteria.andUsernameLike("%ja%");    // 注意!!  查询的关键字需要加上 % % 才可以拼接成功 (模糊查询)

       UserTExample.Criteria criteria2 = userTExample.createCriteria();
       criteria.andPasswordEqualTo("123123");

       userTExample.or(criteria2);  //   sql or

       List<UserT> list = userTMapper.selectByExample(userTExample);
       for(UserT userT : list){
           System.err.println(userT.getUsername());
           System.err.println(userT.getPassword());
           System.out.println("--------------------------------------");
       }
   }

   // 自定义查询条件 - 查询所有
   @Test
   public void selectAll() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserTMapper userTMapper = sqlSession.getMapper(UserTMapper.class);

       List<UserT> list = userTMapper.selectByExample(null);  //  null 就是查询所有
       for(UserT userT : list){
           System.err.println(userT.getUsername());
           System.err.println(userT.getPassword());
           System.out.println("--------------------------------------");
       }
   }




   //  create
   @Test
   public void insertUser_t() throws IOException {

       SqlSession session = get_SqlSession();

       //测试插入一条数据
       UserT userT = new UserT();
       // id 是主键, 不能重复插入相同的数据
       userT.setId(666);
       userT.setUsername("username_YXB");;
       userT.setPassword("123123123");

       //通过sqlSession执行对数据库的相关操作
       UserTMapper userTMapper = session.getMapper(UserTMapper.class);

       int i = userTMapper.insert(userT);

       //这里一定要提交事务，不然不会更新到数据库！！！
       session.commit();
       System.err.println("成功插入了"+i+"条数据！");
       session.close();
   }


   // Update
   @Test
   public void update_Data() throws IOException {
       SqlSession session = get_SqlSession();

       //测试插入一条数据
       UserT userT = new UserT();
       // id 是主键, 不能重复插入相同的数据
       userT.setId(333);
       userT.setUsername("update");;
       userT.setPassword("update");

       //通过sqlSession执行对数据库的相关操作
       UserTMapper userTMapper = session.getMapper(UserTMapper.class);

       int i = userTMapper.updateByPrimaryKey(userT);

       //这里一定要提交事务，不然不会更新到数据库！！！
       session.commit();
       System.err.println("success updata date....."+i+"条数据！");
       session.close();
   }



   // Delete
   @Test
   public void delete_Data() throws IOException {
       SqlSession session = get_SqlSession();

       //通过sqlSession执行对数据库的相关操作
       UserTMapper userTMapper = session.getMapper(UserTMapper.class);

       int i = userTMapper.deleteByPrimaryKey(666);

       //这里一定要提交事务，不然不会更新到数据库！！！
       session.commit();
       System.err.println("success delete date....."+i+"条数据！");
       session.close();
   }



}
