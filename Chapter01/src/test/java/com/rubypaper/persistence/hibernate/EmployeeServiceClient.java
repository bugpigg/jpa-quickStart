package com.rubypaper.persistence.hibernate;

import java.sql.Timestamp;
import java.util.List;

class EmployeeServiceClient {

    public static void main(String[] args) {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setId(6L);
        employeeVO.setName("고길동");
        employeeVO.setStartDate(new Timestamp(System.currentTimeMillis()));
        employeeVO.setTitle("과장");
        employeeVO.setDeptName("총무부");
        employeeVO.setSalary(2500.00);
        employeeVO.setEmail("guest@ruby.co.kr");

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.insertEmployee(employeeVO);

        List<EmployeeVO> employeeList = employeeDAO.getEmployeeList();
        for (EmployeeVO vo : employeeList) {
            System.out.println("vo = " + vo.toString());
        }
    }

}
