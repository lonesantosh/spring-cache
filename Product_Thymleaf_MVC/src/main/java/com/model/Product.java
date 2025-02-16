package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Product implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMP_SEQ_ID",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="gen1")
	private Integer productId;
	private String pName;
	private Integer pQty;
	private Float price;
}
