import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Job> jobQueue = new LinkedList<>();
	static LinkedList<Job> ready = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createJopsQueue();
		setReadyQueue();
		execution();
	}

	// create Jobs Queue randomly
	public static void createJopsQueue() {

		for (int i = 0; i < 6; i++) {
			int size = (int) (Math.random() * (500 - 1 + 1) + 1);
			int time = (int) (Math.random() * (25 - 1 + 1) + 1);
			
			Job j = new Job(size, time);
			jobQueue.add(j);
		}
	}

	// create the ready queue
	public static void setReadyQueue() {

		ready.add(new Job(20, (int) (Math.random() * (25 - 1 + 1) + 1)));
		ready.add(new Job(80, (int) (Math.random() * (25 - 1 + 1) + 1)));
		ready.add(new Job(200, (int) (Math.random() * (25 - 1 + 1) + 1)));
		ready.add(new Job(500, (int) (Math.random() * (25 - 1 + 1) + 1)));

	}

	public static void execution() {
		int time = 0;
		while (true) {
			System.out.println("Job Queue");
			System.out.println(jobQueue.toString());
			System.out.println("Ready Queue");
			System.out.println(ready.toString());
			System.out.println("__________________________________________________________________________________________________________________________________________________________");
			for (int i = 0; i < ready.size(); i++) {
				if (ready.get(i) != null) {
					ready.get(i).burst--;
					
				}
				if (ready.get(i).burst == 0) {
					int size = ready.get(i).size;
					ready.remove(i);
					System.out.println("The process with "+size + " finished At " + time);
					System.out.println();
					
						for (int s = 0; s < jobQueue.size(); s++) {
							if (size <= 20 && jobQueue.peek().size <= 20) {
								
								ready.add(i, jobQueue.poll());
								Job j = new Job((int) (Math.random() * (500 - 1 + 1) + 1),
										(int) (Math.random() * (25 - 1 + 1) + 1));

								jobQueue.add(j);
								
								break;
							} else if (size <= 80 && size >20 && jobQueue.peek().size <= 80 ) {
								
								ready.add(i, jobQueue.poll());
								Job j = new Job((int) (Math.random() * (500 - 1 + 1) + 1),
										(int) (Math.random() * (25 - 1 + 1) + 1));

								jobQueue.add(j);
								break;
							} else if (size <= 200  && size >80 && jobQueue.peek().size <= 200) {
							
								ready.add(i, jobQueue.poll());
								Job j = new Job((int) (Math.random() * (500 - 1 + 1) + 1),
										(int) (Math.random() * (25 - 1 + 1) + 1));

								jobQueue.add(j);
								break;
							} else if (size <= 500  && size > 200 && jobQueue.peek().size <= 500 ) {
								
								ready.add(i, jobQueue.poll());
								Job j = new Job((int) (Math.random() * (500 - 1 + 1) + 1),
										(int) (Math.random() * (25 - 1 + 1) + 1));

								jobQueue.add(j);
								break;
							} else {
								
								Job r = jobQueue.poll();
								jobQueue.add(r);
								continue;
							}
						}
						Job j = new Job((int) (Math.random() * (500 - 1 + 1) + 1),
								(int) (Math.random() * (25 - 1 + 1) + 1));

						jobQueue.add(j);
					
				}

			}
			if(time==50)
				break;
			time++;
		}
	}
}
