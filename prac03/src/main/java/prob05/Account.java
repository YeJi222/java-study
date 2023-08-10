package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public String getAccountNo() {
		return accountNo;
	}
	public int getBalance() {
		return balance;
	}
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(this.accountNo + " 계좌가 개설되었습니다.");
	}
	public void save(int money) {
		this.balance += money;
		System.out.println(accountNo + " 계좌에 " + balance + "만원이 입금되었습니다.");
	}
	public void deposit(int money) {
		this.balance -= money;
		System.out.println(accountNo + " 계좌에 " + balance + "만원이 출금되었습니다.");
	}
	
}
