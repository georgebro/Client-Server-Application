package com.geobro.project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 11/02/2020 GGB
 */

public class Phone implements Closeable {

    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    // constractor 1
    public Phone(String ip, int port) throws IOException {
        try {
            this.socket = new Socket(ip, port);
            this.reader = createReader();
            this.writer = createWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // constractor 2
    public Phone(ServerSocket server) throws IOException {
        this.socket = server.accept();
        this.reader = createReader();
        this.writer = createWriter();
    }

    public void writeLine(String message){
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public String readLine(){
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

            private BufferedReader createReader(){
                try {
                    return new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            // ----
            private BufferedWriter createWriter() throws IOException {
                return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            }

            @Override
            public void close ( ) throws IOException {
                writer.close();
                reader.close();
                socket.close();
            }
        }


