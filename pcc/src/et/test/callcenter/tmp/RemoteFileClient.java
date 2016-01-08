package et.test.callcenter.tmp;

import java.io.*;
import java.net.*;

public class RemoteFileClient {
    protected String hostIp;
    protected int hostPort;
    protected BufferedReader socketReader;
    protected PrintWriter socketWriter;

    public RemoteFileClient(String aHostIp, int aHostPort) {
        hostIp = aHostIp;
        hostPort = aHostPort;
    }
    public static void main(String[] args) {
    	for(int i=0;i<10000;i++){
    		RemoteFileClient remoteFileClient = new RemoteFileClient("127.0.0.1", 3000);
            remoteFileClient.setUpConnection();
            String fileContents =
            	remoteFileClient.getFile("C:\\TCPACHIP.LOG");
            remoteFileClient.tearDownConnection();
            //System.out.println(fileContents);
            System.out.print("\r\n"+i+"\r\n");
    	}
    	RemoteFileClient remoteFileClient = new RemoteFileClient("127.0.0.1", 3000);
        remoteFileClient.setUpConnection();
        String fileContents =
            remoteFileClient.getFile("C:\\WINNT\\Temp\\RemoteFile.txt");
        remoteFileClient.tearDownConnection();
        System.out.println(fileContents);
    }
    public void setUpConnection() {
    	try {
            Socket client = new Socket(hostIp, hostPort);

            socketReader = new BufferedReader(
            		   new InputStreamReader(client.getInputStream()));
            socketWriter = new PrintWriter(client.getOutputStream());

        } catch (UnknownHostException e) {
            System.out.println("Error setting up socket connection: unknown host at " + hostIp + ":" + hostPort);
        } catch (IOException e) {
            System.out.println("Error setting up socket connection: " + e);
        }
    }
//ҵ���߼�
    public String getFile(String fileNameToGet) {
    	StringBuffer fileLines = new StringBuffer();

        try {
            socketWriter.println(fileNameToGet);
            socketWriter.flush();

            String line = null;
            while ((line = socketReader.readLine()) != null)
                fileLines.append(line + "\n");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + fileNameToGet);
        }

        return fileLines.toString();
    }

    public void tearDownConnection() {
    	try {
            socketWriter.close();
            socketReader.close();
        } catch (IOException e) {
            System.out.println("Error tearing down socket connection: " + e);
        }

    }
}

