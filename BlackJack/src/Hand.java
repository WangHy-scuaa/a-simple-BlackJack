package src;
import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> carray;
	public Hand() {
		// TODO Auto-generated constructor stub
		carray = new ArrayList<Card>();
	}
	public void addcard(Card c) {
		carray.add(c);
	}
	public void give(Card c,Hand h) {
		for (int i = 0; i < carray.size(); i++) {
			if (carray.get(i)==c) {
				carray.remove(i);
				h.addcard(c);
			}
		}
	}
	public ArrayList<Card> getCarray() {
		return carray;
	}
	public int count() {
		if (carray.size()==2) {
			if (((carray.get(0).k%13==9)&(carray.get(1).k)%13==0)|((carray.get(1).k%13==9)&(carray.get(0).k)%13==0)) {
				return -1;
			}
		}
		int price=0;
		int ace=0;
		for (int i = 0; i < carray.size(); i++) {
			if ((carray.get(i).k)%13==0){
				ace++;
			}
			else {
				price+=carray.get(i).k%13>9 ? 10:(carray.get(i).k%13+1);
			}
		}
		for (; ace > 0; ace--) {
			if ((price+11)<=21) {
				price+=11;
			}
			else {
				price+=1;
			}
		}
		return price;
	}
	public void showthecard() {
		for (int i = 0; i < carray.size(); i++) {
			System.out.print(carray.get(i).toString()+' ');
		}
		System.out.println();
	}
	public void clear() {
		carray = new ArrayList<Card>();
	}
	public Card withdraw(){
		Card c=carray.get((int)(Math.random()*carray.size())-1);
		return c;
	}
}
