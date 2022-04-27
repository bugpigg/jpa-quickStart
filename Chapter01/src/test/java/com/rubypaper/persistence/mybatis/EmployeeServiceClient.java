package com.rubypaper.persistence.mybatis;

import java.sql.Timestamp;
import java.util.List;

class EmployeeServiceClient {

    public static void main(String[] args) {
        EmployeeVO vo = new EmployeeVO();
        vo.setName("duri");
        vo.setStartDate(new Timestamp(System.currentTimeMillis()));
        vo.setTitle("사원");
        vo.setDeptName("영업부");
        vo.setSalary(1700.00);

        EmployeeDAO dao = new EmployeeDAO();
        dao.insertEmployee(vo);

        List<EmployeeVO> employeeList = dao.getEmployeeList();
        for (EmployeeVO employeeVO : employeeList) {
            System.out.println("employeeVO = " + employeeVO);
        }
    }

}
