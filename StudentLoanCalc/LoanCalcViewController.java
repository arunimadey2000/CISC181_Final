package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javax.swing.text.TableView.TableCell;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoanCalcViewController extends Loan implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;

	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private TextField ExtraPayment;
	
	@FXML
	private TableView<Payments> tableView;
	
	@FXML
	private TableColumn numCol;
	
	@FXML
	private TableColumn dueDateCol;
	
	@FXML
	private TableColumn paymentCol;
	
	@FXML
	private TableColumn adPaymentCol;
	
	@FXML
	private TableColumn interestCol;
	
	@FXML
	private TableColumn principalCol;
	
	@FXML
	private TableColumn balanceCol;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		numCol.setCellValueFactory(new PropertyValueFactory<Payments, Integer>("num"));
		dueDateCol.setCellValueFactory(new PropertyValueFactory<Payments, LocalDate>("due"));
		paymentCol.setCellValueFactory(new PropertyValueFactory<Payments, Double>("pay"));
		adPaymentCol.setCellValueFactory(new PropertyValueFactory<Payments, Double>("adPay"));
		interestCol.setCellValueFactory(new PropertyValueFactory<Payments, Double>("interest"));
		principalCol.setCellValueFactory(new PropertyValueFactory<Payments, Double>("prin"));
		balanceCol.setCellValueFactory(new PropertyValueFactory<Payments, Double>("balance"));
		 
		  
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		double loanAmount = Double.parseDouble(LoanAmount.getText());
		
		lblTotalPayemnts.setText((String.valueOf(getTotalPayments(Double.parseDouble(LoanAmount.getText()),
				Integer.parseInt(NbrOfYears.getText()),
				Double.parseDouble(InterestRate.getText())))));
		lblTotalInterest.setText(String.valueOf(getTotalPayments(Double.parseDouble(LoanAmount.getText()),
				Integer.parseInt(NbrOfYears.getText()),
				Double.parseDouble(InterestRate.getText()))-Double.parseDouble(LoanAmount.getText())));
		
		
		tableView.setItems(getPayments());
		
	}
	
	
	public ObservableList<Payments> getPayments(){
		 
		ObservableList<Payments> payments = FXCollections.observableArrayList();
		Loan x = new Loan();
		double bal = Double.parseDouble(LoanAmount.getText());
		double adPayment = Double.parseDouble(ExtraPayment.getText());
		bal=bal-adPayment;
		int years = Integer.parseInt(NbrOfYears.getText());
		int months = years*12;
		double intRate = Double.parseDouble(InterestRate.getText());
		double totalPay = x.getTotalPayments(bal,years,intRate);
	
		LocalDate date = PaymentStartDate.getValue();
		
		double payment = Math.round(totalPay/months);
		double interest;
		double principal;
		
		
		
	
		payments.add(new Payments(0,null,0,adPayment,0,0,bal));
		
		for(int i=1; i<=months;i++ ) {
			interest=Math.round((bal*intRate)*100)/100;
			principal=Math.round((payment-interest)*100)/100;
			bal=Math.round((bal-principal)*100)/100;
			date=date.plusMonths(1);
			
			if(bal<0) {
				bal=0.0;
			}
	
			payments.add(new Payments(i,date,payment,0,interest,principal,bal));
			
		}
		
		
		return payments;
	}
	
	
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
	

}
