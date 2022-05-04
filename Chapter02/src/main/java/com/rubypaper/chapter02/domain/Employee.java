package com.rubypaper.chapter02.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity // 필수
@Table(name = "s_emp") // 옵션
public class Employee {

    @Id // 필수
    private Long id;

    private String name;
    private String mailId;

    @Column(name = "start_date")
    private Date startDate;

    private String title;

    @Column(name = "dept_name")
    private String deptName;

    private Double salary;

    @Column(name = "commision_pct")
    private Double commissionPct;
}
