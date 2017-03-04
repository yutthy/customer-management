package com.myproject.webapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by uyutthy on 2/10/2017.
 */
@WebServlet(name = "Upload")
public class Upload extends HttpServlet {
    private String filePath;
    private boolean isMultipart;
    private int maxFileSize = 500 *1024;
    private int maxMemSize  = 40 * 1024;
    private File file;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");

        Gson gson = new Gson();
        JsonObject obj = new JsonObject();


        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {

            obj.addProperty("uploadState", false);
            obj.addProperty("msg", "No File Uploaded");

        }else {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            String tempDir = System.getProperty("java.io.tmpdir");
            factory.setRepository(new File(tempDir));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);

            try {
                // Parse the request to get file items.
                List<FileItem> fileItems = upload.parseRequest(request);

                // Process the uploaded file items
                Iterator<FileItem> i = fileItems.iterator();


                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        //String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        //String contentType = fi.getContentType();
                        //boolean isInMemory = fi.isInMemory();
                        //long sizeInBytes = fi.getSize();

                        // Write the file
                        file = new File(filePath + fileName);

                        fi.write(file);

                        HttpSession session = request.getSession();
                        String urlPhoto = (String)request.getAttribute("urlPhoto");
                        urlPhoto = fileName.toString();
                        session.setAttribute("urlPhoto", urlPhoto);


                        obj.addProperty("uploadState", true);
                        obj.addProperty("msg", fileName.toString());
                    }
                }

            } catch (Exception ex) {
                //System.out.println(ex);
                //throw new ServletException(ex.getMessage());
                obj.addProperty("uploadState", false);
                obj.addProperty("msg","Upload Fail");
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
