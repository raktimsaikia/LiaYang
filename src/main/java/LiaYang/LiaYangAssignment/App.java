package LiaYang.LiaYangAssignment;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LaiYangException
    {
    	System.out.println("\n" + Constants.DOUBLE_LINE_SEPERATOR);
		System.out.println("\tLai Yang Global Snapshot Algoritham");
		System.out.println(Constants.DOUBLE_LINE_SEPERATOR);

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter initial value for process P1:");
			int p1Value = scanner.nextInt();

			System.out.println("Enter initial value for process P2:");
			int p2Value = scanner.nextInt();

			System.out.println("Enter total number of timestamps");
			int timestamps = scanner.nextInt();

			System.out.println("Enter total number of messages");
			int totalMessages = scanner.nextInt();

			LaiYangStates laiYangStates = new LaiYangStates();
			laiYangStates.initializeProcess(p1Value, p2Value);
			laiYangStates.initializeTimestamps(timestamps);
			laiYangStates.initializeMessages(totalMessages);

			for (int i = 0; i < totalMessages; i++) {
				System.out.println("Enter values for message " + (i + 1));

				System.out.println("Amount: ");
				int amount = scanner.nextInt();

				System.out.println("From Process[1 OR 2]: ");
				int fromProcess = scanner.nextInt();

				System.out.println("To Process[1 OR 2]: ");
				int toProcess = scanner.nextInt();

				System.out.println("Start Timestamp[0-" + timestamps + "]:");
				int startTime = scanner.nextInt();

				System.out.println("End Timestamp[0-" + timestamps + "]:");
				int endTime = scanner.nextInt();

				laiYangStates.getMessages()[i] = new Message(amount, fromProcess, toProcess, startTime, endTime);

			}
			
			laiYangStates.setupTimestamps();

			System.out.println("Enter RED message index[1-" + totalMessages + "]:");
			int redMessageIndex = scanner.nextInt();

			GlobalSnapshotRecording snapshotRecording = new GlobalSnapshotRecording(laiYangStates, (redMessageIndex - 1));
			snapshotRecording.verifyConsistantState();
		}

		System.out.println("\n" + Constants.DOUBLE_LINE_SEPERATOR);
		System.out.println("\tEND OF PROGRAM");
		System.out.println(Constants.DOUBLE_LINE_SEPERATOR);
    }
}
