package LiaYang.LiaYangAssignment;

public class Message {

	int value;

	int fromProcess;

	int toProcess;

	int startTime;

	int endTime;

	public Message(int value, int fromProcess, int toProcess, int startTime, int endTime) throws LaiYangException {
		this.value = value;
		this.fromProcess = fromProcess;
		this.toProcess = toProcess;
		this.startTime = startTime;
		this.endTime = endTime;
	}

}
