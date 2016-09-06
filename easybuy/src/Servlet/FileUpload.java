package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


// @WebServlet(urlPatterns = { "/UploadFile" })
public class FileUpload extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //上传图片的最大大小
        int maxSize = 3;
        //允许的图片类型
        String[] imgTypes = {".jpg",".gif",".bmp",".png",".jpeg",".ico"};
        //上传文件的目录
        String uploadFullPath = "H:/geekg/easybuy/WebContent/upload/images/";;
        //上传文件的临时目录
        String uploadTempFullPath = "H:/geekg/easybuy/WebContent/upload/images/temp/";
        
        if(!new File(uploadFullPath).isDirectory()){
            new File(uploadFullPath).mkdirs(); 
        }   
        
        if(!new File(uploadTempFullPath).isDirectory()){   
            new File(uploadTempFullPath).mkdirs();
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置最大缓存
        factory.setSizeThreshold(5*1024);
        factory.setRepository(new File(uploadTempFullPath));
    
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置文件大小上限
        upload.setSizeMax(maxSize*1024*1024);
        
        String filePath = null;
        String simpleField = null;
        
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        
        for (FileItem fileItem : fileItems) {
            
            if (!fileItem.isFormField()) {
                String fileName = fileItem.getName().toLowerCase();
                if (fileName.endsWith(imgTypes[0])
                        || fileName.endsWith(imgTypes[1])
                        || fileName.endsWith(imgTypes[2])
                        || fileName.endsWith(imgTypes[3])
                        || fileName.endsWith(imgTypes[4])
                        || fileName.endsWith(imgTypes[5])) {
                    
                    String uuid = UUID.randomUUID().toString();
                    String generateFullFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                    filePath = uploadFullPath +  generateFullFileName;
                    
                    System.out.println("filePath: " + filePath);
                    
                    try {
                        fileItem.write(new File(filePath));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    request.setAttribute("fullFilePath", filePath);
                    request.setAttribute("imgUrl", "/img/" + generateFullFileName);
                    
                } else {
                    request.setAttribute("failMessage", "上传失败，请确定你选择的文件为图片！");
                }
            }
            
            if (fileItem.isFormField()) {
                String fieldName = fileItem.getFieldName();
                if ("simpleField".equals(fieldName)) {
                    String value = new String(fileItem.getString("utf-8"));
                    if (value != null && value.length() > 0) {
                        simpleField = value;
                        request.setAttribute("simpleField", simpleField);
                    }
                }
            }
            
        }
        
        request.getRequestDispatcher("fileUpload.jsp").forward(request, response);
    }

}

