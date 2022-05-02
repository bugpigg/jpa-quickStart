package com.rubypaper.persistence.hibernate;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity // 하이버네이트가 관리하는 엔티티 클래스임을 선언, 이 클래스만 객체로 생성하고 관리함
@Table(name="s_emp") // 테이블과 매핑되도록 설정
public class EmployeeVO {
    @Id // PK가 설정된 ID 칼럼과 매핑한다는 의미
    private Long id;

    private String name;

    @Column(name="start_date")
    private Timestamp startDate;

    private String title;

    @Column(name="dept_name")
    private String deptName;

    private Double salary;

    private String email;

}
