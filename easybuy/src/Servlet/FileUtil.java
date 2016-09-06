package Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.util.Properties;

public class FileUtil {

    public static String UPLOAD_DIR;
    
    static {
        
        Properties properties = new Properties();
        
        InputStream is = FileUtil.class.getResourceAsStream("/project.properties");
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new InternalError(e.getMessage());
        }
        
        String osType = System.getProperty("os.name").toLowerCase();
        
        if (osType.indexOf("win") >= 0) {
            UPLOAD_DIR = properties.getProperty("WIN_UPLOAD_DIR");
        } else if (osType.indexOf("mac") >= 0) {
            UPLOAD_DIR = properties.getProperty("MAC_UPLOAD_DIR");
        } else if (osType.indexOf("nix") >= 0 || osType.indexOf("nux") >= 0) {
            UPLOAD_DIR = properties.getProperty("NIX_UPLOAD_DIR");
        } else if (osType.indexOf("sunos") >= 0) {
            UPLOAD_DIR = properties.getProperty("SOL_UPLOAD_DIR");
        } else {
            throw new InternalError("Your system is not supported!");
        }
        
    }
    
    public static byte[] readIntoByteArray(String fileName) throws IOException {
        FileInputStream fis = null;
        
        File file = new File(fileName);
        
        if (Integer.MAX_VALUE <= file.length()) {
            throw new RuntimeException("File is too big, and length = " + file.length());
        }
        
        try {
            fis = new FileInputStream(file);
            ByteBuffer bb = ByteBuffer.allocate((int)file.length());
            
            int bytesRead = fis.getChannel().read(bb);
            
            if (bytesRead != file.length()) {
                throw new IOException("Error occurred while reading file, bytes = " + bytesRead);
            }
            
            return bb.array();
        } catch (IOException e) {
            throw new IOException(e.getLocalizedMessage());
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        
    }
    
    /*
     * http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
     */
    public static String readIntoString(InputStream is, String encoding) throws IOException {
        final char[] buffer = new char[0x2000];
        
        StringBuilder out = new StringBuilder();
        
        Reader in = new InputStreamReader(is, encoding != null ? encoding : "UTF-8");
        
        int read;
        
        do {
            read = in.read(buffer, 0, buffer.length);
            
            if (read > 0) {
                out.append(buffer, 0, read);
            }
            
        } while (read >= 0);
        
        return out.toString();
    }
    
    public static void deleteDir(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            if (file.listFiles().length == 0) {
                file.delete();
            } else {
                File[] deleteFile = file.listFiles();
                int i = file.listFiles().length;
                for (int j = 0; j < i; j ++) {
                    if (deleteFile[j].isDirectory()) {
                        deleteDir(deleteFile[j].getAbsolutePath());
                    }
                    deleteFile[j].delete();
                }
                file.delete();
            }
        }
    }
    
}
