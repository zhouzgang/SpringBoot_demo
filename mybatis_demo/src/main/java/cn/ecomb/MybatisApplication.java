package cn.ecomb;

import cn.ecomb.entity.Employees;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisApplication {

	public static void main(String[] args) {
		try {
			InputStream inputStream = Resources.getUrlAsStream("/cn/ecomb/config/mybatisConfig.xml");

			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("employeeId", 100);

			List<Employees> list = sqlSession.selectList("cn.ecomb.dao.EmployeesMapper.selectByPrimaryKey", params);
			System.out.println("最低1000：" + list.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
