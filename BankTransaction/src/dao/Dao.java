package dao;

import bean.Account;
import bean.Loan;

public interface Dao {
	Account getDetails(String accountId, Account accounts[]);
//	void showDetails();
	Loan getLoan(Integer loanId,Double loanAmount,String loanType);
	Loan showLoanDetails(Loan loan);
	Double depositAmount(Double originalamount, Integer amount);
	Double withdrawAmount(Double originalamount, Integer amount);
	Loan payLoan(Loan loan,Double loanamount);
//	void showAccountDetails();
}
