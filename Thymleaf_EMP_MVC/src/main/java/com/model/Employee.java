package com.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
@javax.persistence.Entity
@Data
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMP_ID_SEQ",initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	//private  Integer deptno=10;
}
