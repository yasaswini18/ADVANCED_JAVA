//package com.lpu.multithread;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Mythread extends Thread{
//	
//	int[][] a,b,c;
//	int row;
//	
//	public Mythread(int[][] a, int[][] b, int[][] c, int row) {
//		super();
//		this.a = a;
//		this.b = b;
//		this.c = c;
//		this.row = row;
//	}
//	
//	public Mythread() {
//		super();
//	}
//
//	public void run() {
//		
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		for(int i=0;i<5;i++) {
//			c[i][row] = a[i][row] + b[i][row];
//		}
//	}
//}
//
//// how will uh get the info about current thread = Thread.currentThread;
//
//
//class ThreadDemo {
//	public static void main(String[] args) throws InterruptedException {
//		
//		int[][] arr1 = {
//	            {11, 0, 0, 0, 99},
//	            {0, 22, 0, 88, 0},
//	            {0, 0, 55, 0, 0},
//	            {0, 44, 0, 66, 0},
//	            {77, 0, 0, 0, 33}
//	        };
//		int[][] arr2 = {
//	            {10, 0, 0, 0, 90},
//	            {0, 25, 0, 85, 0},
//	            {0, 0, 50, 0, 0},
//	            {0, 45, 0, 60, 0},
//	            {70, 0, 0, 0, 35}
//	        };
//		
//		int[][] arr3 = new int[5][5];
//		List<Mythread> list = new ArrayList<>();
//		
//		for(int i=0;i<5;i++) {
//			Mythread t = new Mythread(arr1,arr2,arr3,i);
//			t.start();
//		}
//		
//		for(Mythread l : list) {
//			System.out.println("main thread waiting for all threads in the list to fnish");
//			l.join();
//		}
//		
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<5;j++) {
//				System.out.print(arr3[i][j] + "  ");
//		}
//			System.out.println();
//	}
//
//}
//}
