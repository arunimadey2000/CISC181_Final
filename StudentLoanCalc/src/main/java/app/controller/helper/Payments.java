package app.controller.helper;

import java.time.LocalDate;

public class Payments{
	private Integer num;
    private LocalDate due;
    private Double pay;
    private Double adPay;
    private Double interest;
    private Double prin;
    private Double balance;
 

	public Payments(int num, LocalDate due, double pay, double adPay, double interest, double prin,double balance) {
		this.num = num;
		this.due = due;
		this.pay = pay;
		this.adPay = adPay;
		this.interest = interest;
		this.prin = prin;
		this.balance = balance;
	}


	public void setNum(int num) {
		this.num=num;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public void setDue(LocalDate due) {
		this.due=due;
	}

	public LocalDate getDue() {
		return due;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public Double getPay() {
		return pay;
	}

	public void seAdPay(double adPay) {
		this.adPay = adPay;
	}

	public Double getAdPay() {
		return adPay;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Double getInterest() {
		return interest;
	}

	public void setPrin(double prin) {
		this.prin = prin;
	}

	public Double getPrin() {
		return prin;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}
	
	

}
