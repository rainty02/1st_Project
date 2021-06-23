package member;

public class Menu {

	private String mname;
	private int price;

	public Menu(String mname, int price) {
		this.mname = mname;
		this.price = price;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Admin [mname=" + mname + ", price=" + price + "]";
	}	
}