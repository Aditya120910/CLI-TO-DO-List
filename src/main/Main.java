package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> taskList = new ArrayList<>();
		System.out.println("""
				Welcome to To-Do-List!
				(1)For adding tasks, Write \"add: (task)\" and it will automatically indexed.
				(2)For removing tasks, Write \"remove (index)\" and it will remove that index.
				(3)For printing your tasks, Write \"print\", and it will print every task with index.
				(4)For exit, just Write \"exit\" or \"quit\" and you are done!""");
		String commands = new String();
		boolean running = true;
		while (running) {
			System.out.print(">>> ");
			commands = scanner.nextLine();
			if (commands.equalsIgnoreCase("quit") || commands.equalsIgnoreCase("exit")) {
				running = false;
			}
			if (commands.startsWith("add: ")) {
				taskList.add(commands.substring(5));
			}
			if (commands.equalsIgnoreCase("print")) {
				try {
					for (int i = 0; i < taskList.size(); i++) {
						System.out.println((i+1) + ". " + taskList.get(i));
					}
				} catch (Exception e) {
					System.out.println("Error, index " + e.getMessage());
				}
			}
			try {
				if (commands.startsWith("remove: ")) {
					int indexToRemove = Integer.parseInt(commands.substring(8)) - 1;
					taskList.remove(indexToRemove);
				}
			} catch (Exception e) {
				System.out.println("Error, that index doesn't exist.");
			}
		}
		scanner.close();
	}

}
