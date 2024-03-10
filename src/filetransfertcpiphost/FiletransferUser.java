/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filetransfertcpiphost;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ghost
 */
public class FiletransferUser {

    public static void main(String[] args) throws IOException {
        String servidor = "201.114.109.197";
        String archivo = "C:\\Users\\Ghost\\OneDrive\\Documentos\\pruebaconec.txt";

        int puerto = 8080;

        Socket socket = new Socket(servidor, puerto);

        // Enviar el nombre del archivo
        OutputStream outputStream = socket.getOutputStream();
        byte[] nombreArchivoBytes = archivo.getBytes();
        outputStream.write(nombreArchivoBytes);

        // Enviar el archivo
        FileInputStream fileInputStream = new FileInputStream(archivo);
        byte[] archivoBytes = new byte[1024];
        int bytesLeidos;
        while ((bytesLeidos = fileInputStream.read(archivoBytes)) != -1) {
            outputStream.write(archivoBytes, 0, bytesLeidos);
        }
        fileInputStream.close();

        // Cerrar la conexión
        socket.close();
    }
}
