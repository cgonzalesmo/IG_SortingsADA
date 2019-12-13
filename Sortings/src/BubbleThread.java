

public class BubbleThread extends Thread{
	int[] array;
	PanelSorting ventanaSorting;
	int milis;
	
	public BubbleThread(int[] ar,PanelSorting panel, int milis) {
		this.array = ar;
		this.ventanaSorting = panel;
		this.milis = milis;
	}
	
	@Override
	public void run() {
		bubbleSort();
	}
	private void bubbleSort() {
		int n = array.length; 
		for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++) { 
                if (array[j] > array[j+1]) { 
                    int temp = array[j];
                    ventanaSorting.paintComponent(ventanaSorting.getGraphics());
                    array[j] = array[j+1];
                    ventanaSorting.paintComponent(ventanaSorting.getGraphics());
                    array[j+1] = temp;  
                }
                try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		
	}
}
