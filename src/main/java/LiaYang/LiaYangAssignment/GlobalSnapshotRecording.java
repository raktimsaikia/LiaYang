package LiaYang.LiaYangAssignment;

public class GlobalSnapshotRecording {

	private Message redMessage;
	private LaiYangStates laiYangStates;

	public GlobalSnapshotRecording(LaiYangStates laiYangStates, int redMessageIndex) {
		this.laiYangStates = laiYangStates;
		this.redMessage = laiYangStates.getMessages()[redMessageIndex];
	}

	private int recordLocalSnapshot() {
		int startTime = redMessage.startTime;
		int endTime = redMessage.endTime;
		Timestamp[] timestamp = laiYangStates.getTimestamps();
		if (startTime > -1 && endTime > 1 && startTime < timestamp.length && startTime < timestamp.length) {
			System.out.println("Local State P1: " + timestamp[startTime].p1State + "\nLocal State P2: "
					+ timestamp[endTime - 1].p2State);
			return timestamp[startTime].p1State + timestamp[endTime - 1].p2State;
		}
		return 0;
	}

	public int recordChannelStates() {
		int ch12Diff = Math.subtractExact(sentP1_P2(), receiveP1_P2());
		int ch21Diff = Math.subtractExact(sentP2_P1(), receiveP2_P1());

		return ch12Diff + ch21Diff;
	}

	public void verifyConsistantState() {

		int totalInitialValue = laiYangStates.getP1().getValue() + laiYangStates.getP2().getValue();
		int totalSnapshotValue = recordLocalSnapshot() + recordChannelStates();

		if (totalInitialValue == totalSnapshotValue) {
			System.out.println(
					"Total Initial Value " + totalInitialValue + " == " + "Total Snapshot Value " + totalSnapshotValue);
			System.out
					.println("Initial system value is EQUAL to snapshot value hence it is a consistant global state.");
		} else {
			System.out.println(
					"Total Initial Value " + totalInitialValue + " != " + "Total Snapshot Value " + totalSnapshotValue);
			System.out.println(
					"Initial system value is NOT EQUAL to snapshot value hence it is a consistant global state.");
		}
	}

	private int sentP1_P2() {
		int redStartTime = redMessage.startTime;
		int sumSentP1_P2 = 0;
		Message[] messages = laiYangStates.getMessages();
		for (int i = 0; i < messages.length; i++) {
			if (messages[i].fromProcess == 1 && messages[i].startTime <= redStartTime) {
				sumSentP1_P2 = sumSentP1_P2 + messages[i].value;
			}
		}

		System.out.println("Total of sent messages from P1 to P2:  " + sumSentP1_P2);
		return sumSentP1_P2;
	}

	private int receiveP1_P2() {
		int redEndTime = redMessage.endTime;
		int sumReceiveP1_P2 = 0;
		Message[] messages = laiYangStates.getMessages();
		for (int i = 0; i < messages.length; i++) {

			if (messages[i].fromProcess == 1 && messages[i].endTime < redEndTime) {
				sumReceiveP1_P2 = sumReceiveP1_P2 + messages[i].value;
			}

		}

		System.out.println("Total of messages received from P1 to P2:  " + sumReceiveP1_P2);
		return sumReceiveP1_P2;
	}

	private int sentP2_P1() {
		int sumSentP2_P1 = 0;
		int redEndTime = redMessage.endTime;
		Message[] messages = laiYangStates.getMessages();
		for (int i = 0; i < messages.length; i++) {

			if (messages[i].fromProcess == 2 && messages[i].startTime <= redEndTime) {
				sumSentP2_P1 = sumSentP2_P1 + messages[i].value;
			}

		}

		System.out.println("Total of sent messages from P2 to P1:  " + sumSentP2_P1);
		return sumSentP2_P1;
	}

	private int receiveP2_P1() {
		int redStartTime = redMessage.startTime;
		int sumReceiveP2_P1 = 0;
		Message[] messages = laiYangStates.getMessages();
		for (int i = 0; i < messages.length; i++) {

			if (messages[i].fromProcess == 2 && messages[i].endTime <= redStartTime) {
				sumReceiveP2_P1 = sumReceiveP2_P1 + messages[i].value;
			}

		}

		System.out.println("Total of messages received from P2 to P1:  " + sumReceiveP2_P1);
		return sumReceiveP2_P1;
	}
}
