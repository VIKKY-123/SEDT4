package practies_read_data;

public class ReversString {

	public static void main(String[] args) {
		String name="vikky";
		String rev=" ";
		for (int i =name.length()-1; i >=0; i--) {
			rev=rev+name.charAt(i);
			
		}
		
		System.out.println(rev);
	}
}
