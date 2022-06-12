public class Main {

	public static void main(String[] args) {
		System.out.println("   _____              ____        \r\n" + "  / ___/__________ __/ __/_  _____\r\n"
		+ " / / _ / ___/ __  /\\  / _  \\/ ___/\r\n" + "/ /_/ / /  / /_/ / / / /_/ /__  ) \r\n"
		+ "\\____/_/   \\_____\\/_/\\____/____/  \r\n" + "\r\n");
		System.out.println("Pontificia Universidade Catolica De Minas Gerais - Sistemas de Informacao - 2022");
		System.out.println("Gustavo Henrique, Matheus Ryuji, Maxwuell Junio, Rafael Penido" + "\r\n");

		Reader reader = new Reader();
		System.out.println(reader.readFile());
	}
}
