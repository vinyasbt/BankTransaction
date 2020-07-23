package App;

import java.util.Scanner;

import bean.Account;
import bean.Loan;
import bean.Transaction;
import exception.AccountIDException;
import exception.AccountNameException;
import service.Service;
import service.ServiceImpl;

public class User {

	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		Loan[] loans = new Loan[10];
		Service service = new ServiceImpl();
		Transaction transaction = new Transaction();
		Scanner sc = new Scanner(System.in);
		String AccountId, AccountName, loanType,LoanAccountId;
		double originalamount,loanAmount = 0.0,finalamount;
		Integer amount;
		int  a=0,k = 0, loanId=0;
		outerwhile:while (true) {
			System.out.println("Enter your choice: \n 1.Create Account \n 2.Deposit Amount"
					+ " \n 3.Withdraw amount \n 4.Show Account Details\n 5.Apply Loan\n 6.Pay Loan\n 7.Show Loan details"
					+ "\n 8.Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				Account account=new Account();
			
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						account.setAccountid(AccountId);
						break;
					} else
						throw new AccountIDException();
				}

				System.out.println("Enter AccountName : ");
				while (true) {
					AccountName = sc.next();
					if (service.accountNameIsValid(AccountName)) {
						account.setAccountname(AccountName);
						break;
					}else
						throw new AccountNameException();
				}

				System.out.println("Enter Address : ");
//				address = sc.next();
				account.setAddress(sc.next());

				System.out.println("Enter deposit Amount : ");
//				amount = sc.nextDouble();
				account.setDepositAmount(sc.nextDouble());
				
				
			accounts[a]=account;
			a++;
				System.out.println(a);
				
				System.out.println("Account created");
//				System.out.println(accounts[--a]);
				for(Account temp:accounts) {
					System.out.println(temp);
				}

				break;
			}
			case 2: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						for(Account temp:accounts) {
//							System.out.println("$$$$"+temp.getAccountid());
							if(temp.getAccountid().equals(AccountId)) {
								System.out.println("Enter deposit Amount : ");
								amount = sc.nextInt();
								originalamount=temp.getDepositAmount();
								finalamount=transaction.depositAmount(originalamount, amount);
							temp.setDepositAmount(finalamount);
							System.out.println("updated balance"+finalamount);
								break;
							}
							
						}
						
					} else {
						throw new AccountIDException();
				}

				break;
			}
			
			break;
			
			}
			case 3: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						for(Account temp:accounts) {
//							System.out.println("$$$$"+temp.getAccountid());
							if(temp.getAccountid().equals(AccountId)) {
								System.out.println("Enter withdraw Amount : ");
								amount = sc.nextInt();
								originalamount=temp.getDepositAmount();
								finalamount=transaction.withdrawAmount(originalamount, amount);
							temp.setDepositAmount(finalamount);
							System.out.println("updated balance"+finalamount);
								break;
							}
							
						}
						
					} else {
						throw new AccountIDException();
				}

				break;
			}
			
			break;
			
			}
			case 4: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						transaction.showDetails(AccountId, accounts);
						break;
					} else
						throw new AccountIDException();
						
				}
				

				break;

			}
			case 5: {
				Loan loan=new Loan();
			
				System.out.println("enter loanId: ");
				loanId = sc.nextInt();

				System.out.println("Enter LoanAmount : ");
				loanAmount = sc.nextDouble();

				System.out.println("Enter Loan Type: 1.Home 2.Car 3.Education 4.Gold");
			
					loanType = sc.next();
					System.out.println("Enter your accountID");
					LoanAccountId=sc.next();
				outer:	for(Account temp:accounts) {
//						System.out.println("$$$$"+temp.getAccountid());
						if(temp.getAccountid().equals(LoanAccountId)) {
							System.out.println("inside condition");
							loan=transaction.getLoan(loanId,loanAmount,loanType);
							System.out.println(loan);
							loans[k]=loan;
							k++;
							System.out.println("Loan Applied...");
						break outer;
						}
					}
	
				break;
			}
			case 6: {
				System.out.println("enter loanId: ");
				loanId = sc.nextInt();
				
				outer1:for(Loan temp:loans) {
					if(temp.getLoanId().equals(loanId)) {
						System.out.println("amount want to pay"+temp.getLoanAmount());
						System.out.println("enter the amount you want to pay");
						loanAmount=sc.nextDouble();
						System.out.println(transaction.payLoan(temp,loanAmount));
						break outer1;
					}
//					else {
//						System.out.println("enter valid loan id");
//					}
				}
//				System.out.println(trans.payLoan(loanId, loans));

				break;
			}
			
			case 7: {
//				Loan l=new Loan();
				System.out.println("enter your Loanid ");
				loanId = sc.nextInt();
					outer2:for(Loan loan:loans)
					{
//						System.out.println("inside for");
						if(loan.getLoanId().equals(loanId)) {
//							System.out.println("inside if");
						System.out.println(transaction.showLoanDetails(loan));
//							System.out.println("value returned");
//							System.out.println(l);
							break outer2;
						}
					}
			break;
				
	}
			case 8: {
				System.out.println("Thank you visit again");
				break outerwhile;

			}
			default: {
				System.out.println("invalid choice");
				break;
			}
	}
	}
}
}
