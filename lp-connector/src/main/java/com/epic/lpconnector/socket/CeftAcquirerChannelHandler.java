package com.epic.lpconnector.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;   
import org.springframework.stereotype.Service;

import com.epic.ceft.bean.CeftRequest; 
 
@Service
public class CeftAcquirerChannelHandler implements Runnable {

	private static DataInputStream IN = null;
	private static DataOutputStream OUT = null;
	private static Socket s = null;
	private static boolean isConnect = false;
	private static int readTimeoutValue = 0;
	private static int conTimeoutValue = 0;
	private static int conPort = 0;
	private static String conIP = null;
	private static String channelId = null;
	private static boolean startup = true;
	private static boolean keepAliveStatus = true;
	private static boolean log_on_status = false;
	private static int ceft_auto_log_on_status = 0;

	public static boolean isLog_on_status() {
		return log_on_status;
	}

	public static void setLog_on_status(boolean log_on_status) {
		CeftAcquirerChannelHandler.log_on_status = log_on_status;
	}

	public static boolean isConnect() {
		return isConnect;
	}

	private static void logOn() {

		Socket s = null;
		PrintWriter pw = null;
		try { 
			Thread.sleep(1000);  
			s = new Socket();
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("CEFT|13|SYSTEM|127.0.0.1|");
			pw.flush();
  
		} catch (Exception e) {
			  
		} finally {
			try {
				if (s != null) {
					s.close();
				}
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e) {
			}
		}
	}

	private static void connect() throws Exception {

		try {
			isConnect = false;
			if (startup)
				channelId = "CHNLJAY";
			InetAddress anetAdd = InetAddress.getByName("localhost");
			InetSocketAddress sockAddress = new InetSocketAddress(anetAdd, 6969);
			 
			
			s = new Socket();
			s.setKeepAlive(keepAliveStatus);
			s.connect(sockAddress, 10000);
			IN = new DataInputStream(s.getInputStream());
			OUT = new DataOutputStream(s.getOutputStream());

			String debug = null;
			if (startup) {
				debug = "Channel (ceft-acq) on Id " + channelId + " is successfully established : " + conIP + "  at "
						 ;
			} else {
				debug = "Channel (ceft-acq) on Id " + channelId + " is successfully re-established : " + conIP + "  at "
						 ;
			}
			 
			debug = null;
			startup = false;
			isConnect = true;

			if (ceft_auto_log_on_status == 0) {   //0  1
				Thread.sleep(1000);
				logOn();
			}

		} catch (Exception e) {
 
			throw e;
		}

	}

	public static void disconnect() throws Exception {

		setLog_on_status(false);

		isConnect = false;
		if (s != null) {
			s.close();
			s = null;
		}
		if (IN != null) {
			IN.close();
			IN = null;
		}
		if (OUT != null) {
			OUT.close();
			OUT = null;
		}
 
	}

	public static void establish(boolean open) throws Exception {
		readTimeoutValue = 10000;
		conPort = 6969;
		conTimeoutValue = 10000;
		conIP = "localhost";
		ceft_auto_log_on_status = 0;

		if (true) {
			keepAliveStatus = false;
		}
		if (open) {
			new Thread(new CeftAcquirerChannelHandler()).start();
		}
		Thread.sleep(1000);
	}

//	public static boolean send(byte[] message, SessionHandler session) throws Exception {
// 
//		if (isConnect) {
//			synchronized (OUT) {
//				 
//				if (!session.isCeft_request()) {
//					QueueCeftAcqurirerSession.addCeftSession(session);
//				}
//
//				OUT.write(message);
//				OUT.flush();
//
//				return true;
//
//			}
//		}
//
//		return false;
//	}

	@Override
	public void run() {

		while (true) {
			try {
				if (isConnect) {
					synchronized (IN) {

						int HD_LEN = 0;
						s.setSoTimeout(0);
						final int HEADER_SIZE = 4;// want to change 4byte in LIVE, and 2 byte in UAT
						byte[] HD = new byte[HEADER_SIZE];
						IN.readFully(HD, 0, HEADER_SIZE);
						HD_LEN = 1;
						CeftRequest open_session = new CeftRequest();
						open_session.setAccountno("781");
						open_session.setAvlbalance("10.00 LKR"); 
						 

						if (HD_LEN > 0) {
							   
//							InitConfigValue.ENGINE_QUEUE.add(open_session);
						} else {
							 
							disconnect();
						}

					}
				} else {
					Thread.sleep(3000);
					System.out.println("Not Connected !");
					try {
						connect();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception e) {
				try {
					disconnect();
					 
					  
				} catch (Exception e1) {
					 
				}
			}
		} // end while

	}

}
