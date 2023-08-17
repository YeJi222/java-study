package prob03;

import java.util.Objects;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money() {
	}
	
	public Money(int num) {
		this.amount = num;
	}

	public Money add(Money amount) {
		// 자신의 금액과 인자로 넘어온 Money 객체의 금액(amount) 계산 
		int temp = this.amount;
		this.amount += amount.amount;
		// 계산된 금액으로 새로운 Money 객체로 생성하여 리턴 
		Money money = new Money(this.amount);
		this.amount = temp;
		
		return money;
	}
	
	public Money minus(Money amount) {
		int temp = this.amount;
		this.amount -= amount.amount;
		Money money = new Money(this.amount);
		this.amount = temp;
				
		return money;
	}
	
	public Money multiply(Money amount) {
		int temp = this.amount;
		this.amount *= amount.amount;
		Money money = new Money(this.amount);
		this.amount = temp;
		
		return money;
	}
	
	public Money divide(Money amount) {
		int temp = this.amount;
		this.amount /= amount.amount;
		Money money = new Money(this.amount);
		this.amount = temp;
		
		return money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		// System.out.println(obj.getClass().getName());
		
		// 인자로 넘어온 Object 객체가 Money 타입인지를 확인
		if (getClass() == obj.getClass()) {
			Money other = (Money) obj;
			if(amount == other.amount) return true;
		} 
		return false;
	}
}
