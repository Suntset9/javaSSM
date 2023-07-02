package com.song;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.dao.UserDao;
import com.song.domain.User;
import com.song.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusDqlApplicationTests {
	@Autowired
	public UserDao userDao;

	@Test
	void testGetAll() {
		//方式一：按条件查询
		//QueryWrapper<User>  qw = new QueryWrapper<User>();
		//qw.lt("age",12);
		//List<User> userList = userDao.selectList(qw);
		//System.out.println(userList);

		//方式二：lambda格式按条件查询
		//QueryWrapper<User> qw = new QueryWrapper<User>();
		//qw.lambda().lt(User::getAge,10);
		//List<User> userList = userDao.selectList(qw);
		//System.out.println(userList);


		//方式三：lambda格式按条件查询
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		//lqw.lt(User::getAge, 10);
		//List<User> userList = userDao.selectList(lqw);
		//System.out.println(userList);


		//并且与或者关系
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		////并且关系：10到30岁之间
		////lqw.lt(User::getAge, 30).gt(User::getAge, 10);
		////或者关系：小于10岁或者大于30岁
		//lqw.lt(User::getAge, 10).or().gt(User::getAge, 30);
		//List<User> userList = userDao.selectList(lqw);
		//System.out.println(userList);


		//模拟页面传递过来的查询数据
		//UserQuery uq = new UserQuery();
		//uq.setAge(10);
		//uq.setAge2(30);

		//null判定
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		//lqw.lt(User::getAge, uq.getAge2());
		//if( null != uq.getAge()) {
		//    lqw.gt(User::getAge, uq.getAge());
		//}
		//List<User> userList = userDao.selectList(lqw);
		//System.out.println(userList);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //先判定第一个参数是否为true，如果为true连接当前条件
////        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2());
////        lqw.gt(null != uq.getAge(),User::getAge, uq.getAge());
//		//两种写法
//        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2())
//           .gt(null != uq.getAge(),User::getAge, uq.getAge());
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

		//查询投影
		//lambda表达式写法
		/** lambda的格式，其实就是方法引用，有点像匿名函数
		 * user::getId 翻译过来就是 (user) -> user.getId
		 * User::getId等同于new User().getId()
		 */
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		//lqw.select(User::getId, User::getName, User::getAge);
		//或者
//		QueryWrapper<User> lqw = new QueryWrapper<User>();
//		lqw.select("id", "name", "age", "tel");
//		List<User> userList = userDao.selectList(lqw);
//		System.out.println(userList);

		////还有些函数不支持的就在dao层的@mapper的类里面定义 @select()方法进行查询语句
        //QueryWrapper<User> lqw = new QueryWrapper<User>();
        //lqw.select("count(*) as count, tel");
        //lqw.groupBy("tel");
        //List<Map<String, Object>> userList = userDao.selectMaps(lqw);
        //System.out.println(userList);

		//排序查询
		// 需求:查询所有数据，然后按照id降序
		//LambdaQueryWrapper<User> lwq = new LambdaQueryWrapper<>();
		///**
		// * condition ：条件，返回boolean，
		// 当condition为true，进行排序，如果为false，则不排序
		// * isAsc:是否为升序，true为升序，false为降序
		// * columns：需要操作的列
		// */
		//lwq.orderBy(true,true, User::getId);
		//List<User> userList = userDao.selectList(lwq);
		//System.out.println(userList);

		//条件查询=用户登录（eq匹配）
        //LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        ////等同于=
        //lqw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
        //User loginUser = userDao.selectOne(lqw);
        //System.out.println(loginUser);

		//购物设定价格区间、户籍设定年龄区间（le ge匹配 或 between匹配）
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		////范围查询 lt le gt ge eq between
		//lqw.between(User::getAge,10,30);
		//List<User> userList = userDao.selectList(lqw);
		//System.out.println(userList);

		//查信息，搜索新闻（非全文检索版：like匹配）
		//LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
		////模糊匹配 like
		//lqw.likeLeft(User::getName,"J");
		//List<User> userList = userDao.selectList(lqw);
		//System.out.println(userList);

		//统计报表（分组查询聚合函数）
		//QueryWrapper<User> qw = new QueryWrapper<User>();
		//qw.select("password","count(*) as nums");
		//qw.groupBy("password");
		//List<Map<String, Object>> maps = userDao.selectMaps(qw);
		//System.out.println(maps);

		//查询全部
		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		List<User> userList = userDao.selectList(lqw);
		System.out.println(userList);

	}

}
