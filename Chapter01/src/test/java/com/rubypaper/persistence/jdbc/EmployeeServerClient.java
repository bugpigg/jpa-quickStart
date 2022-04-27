package com.rubypaper.persistence.jdbc;

import java.sql.Timestamp;
import java.util.List;

class EmployeeServerClient {

    public static void main(String[] args) {
        EmployeeVO vo = new EmployeeVO();
        vo.setName("crong");
        vo.setStartDate(new Timestamp(System.currentTimeMillis()));
        vo.setTitle("과장");
        vo.setDeptName("총무부");
        vo.setSalary(27000.00);

        EmployeeDAO dao = new EmployeeDAO();
        dao.insertEmployee(vo);

        List<EmployeeVO> employeeList = dao.getEmployeeList();
        for (EmployeeVO employeeVO : employeeList) {
            System.out.println("employeeVO = " + employeeVO);
        }
    }
}
