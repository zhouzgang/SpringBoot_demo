package cn.ecomb.dao;

import cn.ecomb.entity.Employees;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/4/3.
 */
public interface EmployeesMapper {
    public List<Employees> selectByPrimaryKey(int employeeId);
}
