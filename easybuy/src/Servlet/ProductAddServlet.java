package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Product;
import Dao.ProductDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ProductAdd
 */
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("GBK");
		
		
		String pname="", pdesc="", ppriceStr="",pstockStr="",pbrand="",
			pcodeStr="",pcatIdStr="",pspecPriceStr="",pspecBuyStr="";
		double pprice=0;
		int pstock=0,pcode=0,pcatId=0,pspecPrice=0,pspecBuy=0;
		int fileStatus = 0;
        
        
        
        
        
		String generateFullFileName="";
		
		//�ϴ�ͼƬ������С
        int maxSize = 3;
        //�����ͼƬ����
        String[] imgTypes = {".jpg",".gif",".bmp",".png",".jpeg",".ico"};
        //�ϴ��ļ���Ŀ¼
        String uploadFullPath = "H:/geekg/easybuy/WebContent/images/product/";
        //�ϴ��ļ�����ʱĿ¼
        String uploadTempFullPath = "H:/geekg/easybuy/WebContent/images/product/temp/";
       
        if(!new File(uploadFullPath).isDirectory()){
            new File(uploadFullPath).mkdirs(); 
        }   
        
        if(!new File(uploadTempFullPath).isDirectory()){   
            new File(uploadTempFullPath).mkdirs();
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //������󻺴�
        factory.setSizeThreshold(5*1024);
        factory.setRepository(new File(uploadTempFullPath));
    
        ServletFileUpload upload = new ServletFileUpload(factory);
        //�����ļ���С����
        upload.setSizeMax(maxSize*1024*1024);
        
        String filePath = null;
        
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
                    generateFullFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                    filePath = uploadFullPath +  generateFullFileName;
                    
                    try {
                        fileItem.write(new File(filePath));
                        fileStatus = 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                } else {
                    request.setAttribute("failMessage", "�ϴ�ʧ�ܣ���ȷ����ѡ����ļ�ΪͼƬ��");
                }
            }
            
            if (fileItem.isFormField()) {
                String fieldName = fileItem.getFieldName();
                if ("pname".equals(fieldName)) {
                    String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                        pname = value;
                    }
                } else if(fieldName.equals("pdesc")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                        pdesc = value;
                    }
                } else if(fieldName.equals("pprice")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	ppriceStr = value;
                    	pprice = Double.parseDouble(ppriceStr);
                    }
                } else if(fieldName.equals("pstock")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pstockStr = value;
                    	pstock = Integer.parseInt(pstockStr);
                    }
                } else if(fieldName.equals("pbrand")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pbrand = value;
                    }
                } else if(fieldName.equals("pcode")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pcodeStr = value;
                    	pcode = Integer.parseInt(pcodeStr);
                    }
                } else if(fieldName.equals("pcatId")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pcatIdStr = value;
                    	pcatId = Integer.parseInt(pcatIdStr);
                    }
                } else if(fieldName.equals("pspecPrice")) {
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pspecPriceStr = value;
                    	pspecPrice = Integer.parseInt(pspecPriceStr);
                    }
                } else if(fieldName.equals("pspecBuy")){
                	String value = new String(fileItem.getString("GBK"));
                    if (value != null && value.length() > 0) {
                    	pspecBuyStr = value;
                    	pspecBuy = Integer.parseInt(pspecBuyStr);
                    }
                }
            }
            
        }
		
		if(fileStatus==0){
			generateFullFileName = "9.jpg";
		}else{
			// �����ļ�
			String fromPath=uploadFullPath+generateFullFileName;// �ļ�·��
	        String targetPath = request.getSession().getServletContext().getRealPath("/")+"images/product/";// �ļ���·��
	        if(!new File(targetPath).isDirectory()){   
	            new File(targetPath).mkdirs();
	        }
	        System.out.println(targetPath);
	        File file = new File(fromPath);
	        FileInputStream in = new FileInputStream(file);
	        FileOutputStream out = new FileOutputStream(targetPath + "/" + file.getName());
	        int c;
	        byte buffer[] = new byte[1024];
	        while ((c = in.read(buffer)) != -1) {
	        for (int i = 0; i < c; i++)
	        out.write(buffer[i]);
	        }
	        in.close();
	        out.close(); 
		}
		Product pro = new Product();
		pro.setPname(pname);
		pro.setPdesc(pdesc);
		pro.setPprice(pprice);
		pro.setPstock(pstock);
		pro.setPbrand(pbrand);
		pro.setPcode(pcode);
		pro.setPcatId(pcatId);
		pro.setPfileName(generateFullFileName);
		pro.setPspecPrice(pspecPrice);
		pro.setPspecBuy(pspecBuy);
		System.out.println(generateFullFileName);
		
		// �������ɹ�����ת
		if(ProductDao.insert(pro) == 0)
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	}

}
