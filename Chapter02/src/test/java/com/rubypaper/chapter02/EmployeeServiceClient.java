package com.rubypaper.chapter02;


import com.rubypaper.chapter02.domain.Employee;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class EmployeeServiceClient {

    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 생성
        // persistence.xml 파일 로딩하여 영속성 유닛 설정을 기반으로 팩토리 객체 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter02");

        // 엔티티 매니저 생성
        EntityManager entityManager = emf.createEntityManager();

        // 엔티티 트랜잭션 생성
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 직원 엔티티 생성
            Employee employee = new Employee();
            employee.setId(1L);
            employee.setName("둘리");
            employee.setMailId("gurum");
            employee.setStartDate(new Date());
            employee.setTitle("과장");
            employee.setDeptName("총무부");
            employee.setSalary(2500.00);
            employee.setCommissionPct(12.50);

            // 트랜잭션 시작
            transaction.begin();

            // 직원 등록 처리
            entityManager.persist(employee);

            // 트랜잭션 종료
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 엔티티 매니저 및 엔티티 매니저 팩토리 종료
            entityManager.close();
            emf.close();
        }
    }
}
