

public class HeapThread extends Thread{
	int[] array;
	PanelSorting ventanaSorting;
	int milis;
	
	public HeapThread(int[] ar, PanelSorting panel, int milis) {
		this.array = ar;
		this.ventanaSorting = panel;
		this.milis = milis;
	}
	
	@Override
	public void run() {
		heapSort();
	}
	
	private  void heapSort() {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			heapChild(array, array.length, i);
			ventanaSorting.paintComponent(ventanaSorting.getGraphics());
			
		}
			
		
		for (int i = array.length - 1; i >= 1; i--) {
			Integer temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapChild(array, i, 0);
			ventanaSorting.paintComponent(ventanaSorting.getGraphics());
         
            
		}
		 // ojo
	
	}
	private void heapChild(int [] enteros, int n, int i) {
		
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (enteros[child]>enteros[max]) {
				max = child;    
			}
		
		if (child + 1 < n)
			if (enteros[child + 1]>enteros[max]) {
				max = child + 1; 
			}
		
		if (max != i) {
			Integer temp = enteros[i];
			enteros[i] = enteros[max];
			enteros[max] = temp;
			ventanaSorting.paintComponent(ventanaSorting.getGraphics());
            heapChild(enteros, n, max);
			
		}
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}