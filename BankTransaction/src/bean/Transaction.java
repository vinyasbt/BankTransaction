package bean;

import dao.Dao;
import dao.DaoImpl;

public class Transaction extends Loan {
	Dao dao = new DaoImpl();
	Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + "]";
	}

	public Double depositAmount(Double originalamount, Integer amount) {
		return (dao.depositAmount(originalamount,amount));
	}

	public Double withdrawAmount(Double originalamount, Integer amount) {
		return (dao.withdrawAmount(originalamount,amount));
	}

	public Loan payLoan(Loan loan,Double loanamount) {
		return(dao.payLoan(loan,loanamount));
	}

	public void showAccountDetails() {

	}
}
