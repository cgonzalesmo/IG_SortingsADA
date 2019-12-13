
public class SelectionThread extends Thread{
	int[] array;
	PanelSorting ventanaSorting;	
	int milis;
	
	public SelectionThread(int[] ar, PanelSorting panel, int milis) {
		this.array = ar;
		this.ventanaSorting = panel;
		this.milis = milis;
	}
	
	@Override
	public void run() {
        SelectionSort();

	}
	private void SelectionSort() {
		//Es un mejoramiento del metodo de insercion ya que soluciona su principal problema al momento por ejemplo de trasladar un elemento por casi todo el arreglo para ubicarlo. 
		// Va entonces ordenando los elementos considerando una distancia
		int n = array.length;
		// Cambiamos uno por uno los elementos no ordenados
		for (int i = 0; i < n-1; i++){
			// Encontramos el minimo elemento del arreglo
			int min_idx = i;
			for (int j = i+1; j < n; j++) {
				ventanaSorting.paintComponent(ventanaSorting.getGraphics());
				if (array[j] < array[min_idx]) {
					min_idx = j;	
				}	
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Intercambiamos el minimo elemento con el primer elemento
			int temp = array[min_idx];
			array[min_idx] = array[i];
			array[i] = temp;
			ventanaSorting.paintComponent(ventanaSorting.getGraphics());
			
		}
		
		
	}
	

}
