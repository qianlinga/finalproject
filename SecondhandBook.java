
public class SecondhandBook extends Book {
	
	private String offer;
	private String condition;

	public SecondhandBook(String name, String lesson, int price,String offer,String condi) {
		super(name, lesson, price);
		// TODO Auto-generated constructor stub
		this.offer = offer;
		this.condition = condi;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
