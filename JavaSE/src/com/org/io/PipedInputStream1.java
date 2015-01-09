package com.org.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-16
 */
class Read implements Runnable {
	PipedInputStream pis;
	Read(PipedInputStream pis) {
		this.pis = pis;
	}
	@Override
	public void run() {
		try {
			byte buf[] = new byte[1024];
			int len = pis.read(buf);
			String s = new String(buf, 0, len);
			System.out.println(s);
			pis.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception"+e.toString());
		}
	}
}

/**
 * 
 */
class Write implements Runnable {
	PipedOutputStream pos;

	Write(PipedOutputStream pos) {

		this.pos = pos;
	}

	@Override
	public void run() {
		try {
			pos.write("write".getBytes());
			pos.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception"+e.toString());
		}
	}
}

public class PipedInputStream1 {
	/**
	 *管道流~~~
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PipedInputStream inputStream=new PipedInputStream();
		
		PipedOutputStream outputStream=new PipedOutputStream();
		
		inputStream.connect(outputStream);
		
		Read reader=new Read(inputStream );
		
		Write writer=new Write(outputStream);
		
		
		new Thread(reader).start();
		new Thread(writer).start();
		
	}
}
