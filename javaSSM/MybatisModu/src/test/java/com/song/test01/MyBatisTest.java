package com.song.test01;

import com.song.mybatis.mapper.BrandMapper;
import com.song.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyBatisTest {
    /**
     * 查询表所有数据
     * @throws IOException
     */
    @Test
    public void testSelectAll() throws IOException {
        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";//声明config文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //释放资源
        sqlSession.close();

    }

    /**
     * 根据id查询行数据
     * @throws IOException
     */
    @Test
    public void testSelectById() throws IOException {

        int id = 1;

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        Brand brands = mapper.selectById(id);
        System.out.println(brands);

        //释放资源
        sqlSession.close();

    }

    /**
     * 多条件查询数据
     * @throws IOException
     */
    @Test
    public void testSelectByCoundition() throws IOException {
        //定义接收的参数
        int Status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName +"%";
        brandName = "%"+ brandName +"%";

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        /**
         * 方法一
         * 接口方法参数使用@param方法调用方法
         */
//        List<Brand> brands = mapper.selectByCondition(Status, companyName, brandName);


        /*
        *方法二
        * 接口方法参数是 实体类对象 的方式调用方法
        * 封装对象
        */
//        Brand brand = new Brand();
//        brand.setStatus(Status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        /**
         * 方法三
         * 接口方法参数是 map集合对象 方式调用的方法
         */
        Map map = new HashMap();
        map.put("staus" , Status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        List<Brand> brands = mapper.selectByCondition(map);

        List<Brand> brands1 = mapper.selectByConditionDynamic(map);

        System.out.println(brands1);
        //释放资源
        sqlSession.close();

    }

    /**
     * 单条件查询
     * @throws IOException
     */
    @Test
    public void testSelectByCounditionSingle() throws IOException {
        //定义接收的参数
        int Status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName +"%";
        brandName = "%"+ brandName +"%";

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        /*
         *方法二
         * 接口方法参数是 实体类对象 的方式调用方法
         * 封装对象
         * 业务方面应该是加入判断看是哪个输入了然后查询
         */
        Brand brand = new Brand();
//        brand.setStatus(Status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);


        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        //释放资源
        sqlSession.close();

    }

    /**
     * 添加数据方法
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        //定义接收的参数
        int Status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String descripition = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(Status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descripition);
        brand.setOrdered(ordered);

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取sqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);设置为true为自动提交事务，这里可以不用自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行添加方法
        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    /**
     * 添加数据方法： 添加了主键返回的功能 --运行发生异常 数据未添加进去也没回滚，主键值向下延申
     * 以此类推可以获取加入的所有值
     * 用于解决关联数据的问题，如订单和订单项，一个订单对应多个订单项，订单项的外键指向订单的主键
     * 多个订单项的主键也要同时添加到订单表中，订单项添加需指定id值
     *
     * @throws IOException
     */
    @Test
    public void testAddKey() throws IOException {
        //定义接收的参数
        int Status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String descripition = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(Status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descripition);
        brand.setOrdered(ordered);

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取sqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);设置为true为自动提交事务，这里可以不用自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        try {
            //执行添加方法
            brandMapper.addKey(brand);
            Integer id = brand.getId();
            System.out.println(id);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            //事务回滚
            sqlSession.rollback();
            System.out.println(e);
        }finally {
            //释放资源
            sqlSession.close();
        }

    }

    /**
     * 根据给出的数据进行修改替换
     * 业务方面到时候可以变成传参等非写死方式
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        //定义接收的参数
        int Status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String descripition = "手机中的战斗机";
        int ordered = 200;
        int id = 6;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(Status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descripition);
        brand.setOrdered(ordered);
        brand.setId(id);

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取sqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);设置为true为自动提交事务，这里可以不用自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法

        int count = brandMapper.update(brand);
        System.out.println(count);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    /**
     * 删除一行数据
     * @throws IOException
     */
    @Test
    public void testDeleteById() throws IOException {
        //定义接收的参数
        int id = 6;

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取sqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);设置为true为自动提交事务，这里可以不用自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        brandMapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    /**
     * 删除多行数据
     * 删除添加后发现主键不连续 -使用 ALTER TABLE tb_brand AUTO_INCREMENT = 1; 设置主键自增
     * 需删除不连续的数据后执行
     * @throws IOException
     */
    @Test
    public void testDeleteByIds() throws IOException {
        //定义接收的参数
        int[] ids = {14};

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取sqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);设置为true为自动提交事务，这里可以不用自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }







}
