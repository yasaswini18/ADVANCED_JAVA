package com.lpu.multithread;


class Printer {
    public void print(String msg) {
        System.out.print("[");
        try {
            Thread.sleep(500); // Simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg + "]");
    }
}
class PrinterThread extends Thread
{
	Printer p;
	String msg;
	public PrinterThread(Printer p, String msg){
		super();
		this.p=p;
		this.msg=msg;
	}
	public void run()
	{
	synchronized(p)
	{
		p.print(msg);
	}
	}
	}
public class SyncDemo {
	public static void main(String[] args)
	{
		Printer p = new Printer();
		PrinterThread t1 = new PrinterThread(p,"java");
		PrinterThread t2 = new PrinterThread(p,"dbms");
		t1.start();
		t2.start();
	}

}
