package kim.dongyoung.bookstore;

public class CountExit implements Runnable {

	private int[] count;

	public CountExit() {
		count = new int[3];
		int start = 3; 

		for (int i = 0; i < count.length; i++) {
			count[i] = start;
			start--;
		}
		
	}

	@Override
	public void run() {
		for(int start:count) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.println("******"+ start + "******");
		}
		System.out.println("종료합니다. 감사합니다.");
		System.exit(0);
	
		
	}
	
}
