

public class QuickThread extends Thread{
	int[] array;
	PanelSorting ventanaSorting;
	int milis;
	
	public QuickThread(int[] ar, PanelSorting panel, int milis) {
		this.array = ar;
		this.ventanaSorting = panel;
		this.milis = milis;
	}
	
	@Override
	public void run() {
		quickSort(array,0,array.length-1);
	}
	

    private void quickSort(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                                try {
                					Thread.sleep(milis);
                				} catch (InterruptedException e) {
                					// TODO Auto-generated catch block
                					e.printStackTrace();
                				}
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                                try {
                					Thread.sleep(milis);
                				} catch (InterruptedException e) {
                					// TODO Auto-generated catch block
                					e.printStackTrace();
                				}
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                                ventanaSorting.paintComponent(ventanaSorting.getGraphics());
                                try {
        							Thread.sleep(milis);
        						} catch (InterruptedException e) {
        							// TODO Auto-generated catch block
        							e.printStackTrace();
        						}
                        }
                        
                        
                       
                }
                
                if(elemDer>inicio){
                        int temp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=temp;
                        
                }
                ventanaSorting.paintComponent(ventanaSorting.getGraphics());
                
                quickSort(vec, inicio, elemDer-1);
                quickSort(vec, elemDer+1, fin);
        }
}
