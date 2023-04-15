
public class Job {
	int size;
	int burst;
	
	public Job(int size, int burst) {
		super();
		this.size = size;
		this.burst = burst;
		
	}

	@Override
	public String toString() {
		return "Job [size=" + size + ", time=" + burst + "]";
	}
	
	
}
