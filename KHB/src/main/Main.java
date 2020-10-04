
public class Main {
	public static void main(String[] args) {
		ICafe cafe = new Cafe();
		cafe.arrive(1, 1, 1);
		System.out.println(cafe.serve());
		System.out.println(cafe.stat());

		System.out.println("Hello, world\n");
	}
}