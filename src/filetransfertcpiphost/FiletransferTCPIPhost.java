/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filetransfertcpiphost;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ghost
 */
public class FiletransferTCPIPhost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int puerto = 8080;
        ServerSocket serverSocket = new ServerSocket(puerto);

        while (true) {
            Socket socket = serverSocket.accept();

            // Recibir el nombre del archivo
            InputStream inputStream = socket.getInputStream();
            byte[] nombreArchivoBytes = new byte[1024];
            inputStream.read(nombreArchivoBytes);
            String nombreArchivo = new String(nombreArchivoBytes);

            // Recibir el archivo
            byte[] archivoBytes = new byte[1024];
            int bytesLeidos;
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
            while ((bytesLeidos = inputStream.read(archivoBytes)) != -1) {
                fileOutputStream.write(archivoBytes, 0, bytesLeidos);
            }
            fileOutputStream.close();

            // Cerrar la conexión
            socket.close();
        }
    }

}
