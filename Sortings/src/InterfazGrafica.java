import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class InterfazGrafica extends JFrame{
	
		
	
	JPanel panelBotones;
	JPanel panelSortings;
	
	PanelSorting panelBubble;
	PanelSorting panelSelection;
	PanelSorting panelInsertion;
	PanelSorting panelMerge;
	PanelSorting panelQuick;
	PanelSorting panelHeap;
	
	JButton botonSorting;
	JButton botonSalir;
	
	JRadioButton jRadioButton1; // randomArray
	JRadioButton jRadioButton2; // NearlySortedArray
	JRadioButton jRadioButton3; // ReverseArray
	JRadioButton jRadioButton4; // FewUniqueArray
	ButtonGroup arrayGroup;
	int[] Arreglo;
	public InterfazGrafica() {
		
		setBounds(-5,100,1500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		
	}
	
	public void initComponents() {
		
		int cantidadElements=37 ;
		int maxValue=100;
		int milis=10;
		
		panelSortings = new JPanel();
		panelSortings.setLayout(new GridLayout(2,2));
		panelSortings.setSize(new Dimension(1080,720));
		
		
		Arreglo = generateArray(cantidadElements,maxValue);
	
		panelBubble = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
		panelSelection = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
		panelInsertion = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
		panelMerge = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
		panelQuick = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
		panelHeap = new PanelSorting(Arrays.copyOf(Arreglo, Arreglo.length),100);
	

		panelBubble.setBorder(new TitledBorder(new EtchedBorder(), "Bubble Sort"));
		panelSelection.setBorder(new TitledBorder(new EtchedBorder(), "Selection Sort"));
		panelInsertion.setBorder(new TitledBorder(new EtchedBorder(), "Insertion Sort"));
		panelMerge.setBorder(new TitledBorder(new EtchedBorder(), "Merge Sort"));
		panelQuick.setBorder(new TitledBorder(new EtchedBorder(), "Quick Sort"));
		panelHeap.setBorder( new TitledBorder(new EtchedBorder(), "Heap Sort"));
			
		panelSortings.add(panelBubble);
		panelSortings.add(panelSelection);
		panelSortings.add(panelInsertion);
		panelSortings.add(panelMerge);
		panelSortings.add(panelQuick);
		panelSortings.add(panelHeap);
		
		panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(180,720));
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		
		botonSorting = new JButton("Sorting");
		botonSorting.setPreferredSize(new Dimension(140,50));
		botonSalir = new JButton("Salir");
		botonSalir.setPreferredSize(new Dimension(140,50));
		
		jRadioButton1=new JRadioButton("randomArray");
		jRadioButton1.setPreferredSize(new Dimension(140,20));
		jRadioButton2=new JRadioButton("NearlySortedArray");
		jRadioButton2.setPreferredSize(new Dimension(140,20));
		jRadioButton3=new JRadioButton("ReverseArray");
		jRadioButton3.setPreferredSize(new Dimension(140,20));
		jRadioButton4=new JRadioButton("FewUniqueArray");
		jRadioButton4.setPreferredSize(new Dimension(140,20));
		arrayGroup = new ButtonGroup();
		
		
		
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Arreglo=generateArray(cantidadElements,maxValue);;
			}
		});
		
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Arreglo = NearlySortedArray(cantidadElements,maxValue);
			}
		});
		
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Arreglo = ReverseArray(cantidadElements,maxValue);
			}
		});
		
		jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Arreglo = FewUniqueArray(cantidadElements,maxValue);
				
			}
		});
		panelBotones.add(botonSorting);
		botonSorting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

				panelBubble.limpiar(panelBubble.getGraphics());
				panelSelection.limpiar(panelSelection.getGraphics());
				panelInsertion.limpiar(panelInsertion.getGraphics());
				panelMerge.limpiar(panelMerge.getGraphics());
				panelQuick.limpiar(panelQuick.getGraphics());
				panelHeap.limpiar(panelHeap.getGraphics());
				jRadioButton1.setText("randomArray");
				
				
				
				panelBubble.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				panelSelection.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				panelInsertion.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				panelMerge.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				panelQuick.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				panelHeap.actualizar(Arrays.copyOf(Arreglo, Arreglo.length),maxValue);
				
				Thread bubbleThread = new BubbleThread(panelBubble.getArray(),panelBubble,milis);
				Thread selectionThread = new SelectionThread(panelSelection.getArray(),panelSelection,milis);
				Thread insertionThread = new InsertionThread(panelInsertion.getArray(),panelInsertion,milis);
				Thread mergeThread = new MergeThread(panelMerge.getArray(),panelMerge,milis);
				Thread quickThread = new QuickThread(panelQuick.getArray(),panelQuick,milis);
				Thread heapSortThread = new HeapThread(panelHeap.getArray(),panelHeap,milis);
				
				bubbleThread.start();
				selectionThread.start();
				insertionThread.start();
				mergeThread.start();
				quickThread.start();
				heapSortThread.start();
				
			}
			
		});
		
		panelBotones.add(botonSalir);
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		arrayGroup.add(jRadioButton1);
		arrayGroup.add(jRadioButton2);
		arrayGroup.add(jRadioButton3);
		arrayGroup.add(jRadioButton4);
		
		panelBotones.add(jRadioButton1);
		panelBotones.add(jRadioButton2);
		panelBotones.add(jRadioButton3);
		panelBotones.add(jRadioButton4);
		
		add(panelSortings, BorderLayout.CENTER);
		add(panelBotones,BorderLayout.WEST);
		
	}
	public int[] generateArray(int cantidadElements, int maximo) {
		int[] ar = new int[cantidadElements];
		Random rd = new Random();
		for(int i=0;i<ar.length;i++) {
			ar[i] = rd.nextInt(maximo-10)+11;
		}
			
		return ar;
	}
    
    public  int[] NearlySortedArray(int cantidadElements, int maximo) {
    	int aux=cantidadElements*1/3;
    	int [] arr=new int[cantidadElements];
        int [] arreglo=generateArray(aux,maximo);
        System.arraycopy(arreglo, 0,arr,0,aux);
        for(int i=aux-1,j=aux;i<arr.length;j++,i++) {
        	arr[i]=j;
        }
        return arr;
	}
      
    public int[] ReverseArray(int cantidadElements, int maximo) {
    	int[] ar = new int[cantidadElements];
    	 for (int i=ar.length-1,j=0; i>=0; i--,j+=2) {
    		ar[i] =j;
    	
    	 }	
    	 return ar;
    }
    
    public int[] FewUniqueArray(int cantidadElements, int maximo) {
    	int[] array = new int[cantidadElements];
    	int repetir=array.length/5;
    
    	for (int i=0; i<array.length; i++ ) {
			  
    		if((repetir)<array.length) {
			  for (int j=1; j<array.length/5; j++ ) {
				  array[i] = repetir;
				  i++;
			  }
			  repetir+=array.length/5;
    		}
    		array[i]=i;
		}
    	return array;
    }
   
	
}
