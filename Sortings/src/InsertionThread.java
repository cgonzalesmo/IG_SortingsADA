

public class InsertionThread extends Thread{
	int[] array;
	PanelSorting ventanaSorting;
	int milis;
	
	public InsertionThread(int[] ar, PanelSorting panel, int milis) {
		this.array = ar;
		this.ventanaSorting = panel;
		this.milis = milis;
	}
	
	@Override
	public void run() {
		insertionSort();
	}
	private void insertionSort() {
		int n = array.length; 
        for (int i = 1; i < n; ++i) { 
            int key = array[i]; 
            int j = i - 1; 
            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j];
                ventanaSorting.paintComponent(ventanaSorting.getGraphics());
                j = j - 1;
                try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
            array[j + 1] = key;
            ventanaSorting.paintComponent(ventanaSorting.getGraphics());
        } 
	}
}
