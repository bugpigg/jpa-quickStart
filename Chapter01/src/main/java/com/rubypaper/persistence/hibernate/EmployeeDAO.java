package com.rubypaper.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public EmployeeDAO() {
        String config = "com/rubypaper/persistence/hibernate/hibernate.cfg.xml";
        sessionFactory = new Configuration().configure(config).buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.getTransaction();
    }

    public void insertEmployee(EmployeeVO vo) {
        System.out.println("===> Hibernate 기반으로 직원 등록 기능 처리");
        try {
            transaction.begin();
            session.persist(vo); // insert 구현
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<EmployeeVO> getEmployeeList() {
        System.out.println("===> Hibernate 기반으로 직원 목록 조회 기능 처리");
        String jpql = "select e from EmployeeVO e order by e.id"; // 이를 HQL 쿼리라고 함 // 기본 SQL과 거의 동일
        List<EmployeeVO> employeeList = session.createQuery(jpql).getResultList();
        return employeeList;
    }
}
