
import com.xxxxx.mapper.UserMapper;
import com.xxxxx.pojo.User;
import com.xxxxx.pojo.UserExample;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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




    // CRUD
    // 增加 (Create)
    // 删除 (Delete)
    // 更新 (Update)
    // 查询 (Retrieve)

    // 相关教程:  https://blog.csdn.net/thedarkclouds/article/details/82384606



    //  增加(Create)
    @Test
    public void Insert() throws IOException {

        SqlSession session = get_SqlSession();

        //测试插入一条数据
        User user = new User();
        // id 是主键, 不能重复插入相同的数据
        user.setUsername("username_YXB");;
        user.setPassword("123123123");

        //通过sqlSession执行对数据库的相关操作
        UserMapper userMapper = session.getMapper(UserMapper.class);

        int i = userMapper.insert(user);

        //这里一定要提交事务，不然不会更新到数据库！！！
        session.commit();
        System.err.println("成功插入了"+i+"条数据！");
        session.close();
    }




    // 删除 (Delete)
    @Test
    public void Delete() throws IOException {
        SqlSession session = get_SqlSession();

        //通过sqlSession执行对数据库的相关操作
        UserMapper userMapper = session.getMapper(UserMapper.class);

        int i = userMapper.deleteByPrimaryKey(666);

        //这里一定要提交事务，不然不会更新到数据库！！！
        session.commit();
        System.err.println("success delete date....."+i+"条数据！");
        session.close();
    }




    // 更新 (Update)
    @Test
    public void Update() throws IOException {
        SqlSession session = get_SqlSession();

        //测试插入一条数据
        User user = new User();
        // id 是主键, 不能重复插入相同的数据
        user.setId(333);
        user.setUsername("update");;
        user.setPassword("update");

        //通过sqlSession执行对数据库的相关操作
        UserMapper userMapper = session.getMapper(UserMapper.class);

        int i = userMapper.updateByPrimaryKey(user);

        //这里一定要提交事务，不然不会更新到数据库！！！
        session.commit();
        System.err.println("success updata date....."+i+"条数据！");
        session.close();
    }



//

  // 查询(Retrieve)
    @Test
    public void selectByPrimaryKey() throws Exception {

        SqlSession session = get_SqlSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(4);   // 主键查询
        System.err.println(user.getUsername() + "  " + user.getPassword());
        session.close();

       }



   /*
        自定义查询条件 - 模糊查询
        需求:
            username like jack
    */
   @Test
   public void selectByExample_001() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

       UserExample userExample = new UserExample();
       UserExample.Criteria criteria = userExample.createCriteria();

       // 注意!!  查询的关键字需要加上 % % 才可以拼接成功 (模糊查询)
       criteria.andUsernameLike("%jack%");
       List<User> list = userMapper.selectByExample(userExample);

       for(User user : list){
           System.err.println(user.getUsername()  + "        " +  user.getPassword());
           System.out.println("--------------------------------------");
       }
   }



    // 自定义查询条件 -  WHERE ( price between ? and ? )
    @Test
    public void andXxxxxBetween() throws Exception {

        SqlSession sqlSession = get_SqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdBetween(600 , 800);

        List<User> list = userMapper.selectByExample(example);

        for(User user : list){
            System.err.println(user.getUsername()  + "     " + user.getPassword() );
            System.out.println("\n--------------------------------------\n");
        }
    }


/*
    自定义查询条件 - or 语句
    需求:
        username like   jack
        password ==     tom
    SQL:
        select id, username, password from user WHERE ( username like ? and password = ? )
*/
   @Test
   public void selectByExample_003() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

       UserExample userExample = new UserExample();
       UserExample.Criteria criteria_1= userExample.createCriteria();
       UserExample.Criteria criteria_2 = userExample.createCriteria();

       criteria_1.andUsernameLike("%ja%");    // 注意!!  查询的关键字需要加上 % % 才可以拼接成功 (模糊查询)
       criteria_1.andPasswordEqualTo("tom");

       userExample.or(criteria_2);  //   sql or

       List<User> list = userMapper.selectByExample(userExample);
       for(User user : list){
           System.err.println(user.getUsername()  + "        " +  user.getPassword());
           System.out.println("--------------------------------------");
       }
   }


   @Test
   public void selectByExample_002() throws IOException {

       SqlSession sqlSession = get_SqlSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       UserExample example = new UserExample();

       UserExample.Criteria criteria = example.createCriteria();

       criteria.andUsernameEqualTo("wyw");
       criteria.andUsernameIsNull();
       example.setOrderByClause("username asc,email desc");

       List<?>list = userMapper.selectByExample(example);

       // 相当于：select * from user where username = 'wyw' and  username is null order by username asc,email desc
   }



   // 自定义查询条件 - 查询所有
   @Test
   public void selectAll() throws IOException {
       SqlSession sqlSession = get_SqlSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

       List<User> list = userMapper.selectByExample(null);  //  null 就是查询所有
       for(User user : list){
           System.err.println(user.getUsername()  + "   " +  user.getPassword());
       }
   }


}
