package LiaYang.LiaYangAssignment;

public class LaiYangStates {

	private Process p1;
	
	private Process p2;
	
	private Timestamp[] timestamps;
	
	private Message[] messages;

	public void initializeProcess(int initialValueP1, int initialValueP2) {
		p1 = new Process(Constants.PROCESS_ID_P1, initialValueP1);
		p2 = new Process(Constants.PROCESS_ID_P2, initialValueP2);

		System.out.println("Processes Initialized Successfully.");
		System.out.println("Initial Value P1 = " + p1.getValue());
		System.out.println("Initial Value P2 = " + p2.getValue());
		System.out.println("Total System Value = " + (p1.getValue() + p2.getValue()));
		System.out.println(Constants.DOUBLE_LINE_SEPERATOR);
	}

	public void initializeTimestamps(int totalTimestamps) throws LaiYangException {
		if (totalTimestamps > Constants.MAX_TIMESTAMPS) {
			throw new LaiYangException("Max timestamps allowed is " + Constants.MAX_TIMESTAMPS);
		}

		timestamps = new Timestamp[totalTimestamps];
	}

	public void initializeMessages(int totalMessages) throws LaiYangException {
		if (totalMessages > Constants.MAX_MESSAGES) {
			throw new LaiYangException("Max messages allowed is " + Constants.MAX_MESSAGES);
		}

		messages = new Message[totalMessages];
	}

	public void setupTimestamps() {
		System.out.println("==========================");
		System.out.println("|  Timestamp" + "   P1   " + "   P2 |");
		for (int i = 0; i < timestamps.length; i++) {

			for (int k = 0; k < messages.length; k++) {
				if (messages[k].startTime > i && messages[k].endTime > i) {
					break;
				} else {
					processMessage(i, messages[k], p1, p2);
				}
			}

			timestamps[i] = new Timestamp(i, p1.getValue(), p2.getValue());
			System.out.println("==========================");
			System.out.println("|   T" + (i + 1) + "  |  " + p1.getValue() + "  |  " + p2.getValue() + "  |");
		}
	}

	private void processMessage(int timestamp, Message message, Process p1, Process p2) {

		switch (message.fromProcess) {
		case Constants.PROCESS_ID_P1:
			if (timestamp == message.startTime) {
				p1.setValue(p1.getValue() - message.value);
			}
			if (timestamp == message.endTime) {
				p2.setValue(p2.getValue() + message.value)  ;
			}
			break;
		case Constants.PROCESS_ID_P2:
			if (timestamp == message.startTime) {
				p2.setValue( p2.getValue() - message.value);
			}
			if (timestamp == message.endTime) {
				p1.setValue(p1.getValue() + message.value);
			}
			break;
		}

	}

	public Process getP1() {
		return p1;
	}

	public Process getP2() {
		return p2;
	}

	public Timestamp[] getTimestamps() {
		return timestamps;
	}

	public Message[] getMessages() {
		return messages;
	}

}
