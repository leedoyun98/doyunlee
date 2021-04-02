package doyun.lee.api.rcv.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import doyun.lee.api.pay.domain.Payment;

@Entity
public class Receiver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rcv_no")
	private int rcvNo;
	@Column(name = "rcv_name")
	private String rcvName;
	@Column(name = "rcv_phone")
	private String rcvPhone;
	@Column(name = "rcv_addr")
	private String rcvAddr;

	@ManyToOne
	@JoinColumn(name = "pay_no")
	private Payment payment;
}