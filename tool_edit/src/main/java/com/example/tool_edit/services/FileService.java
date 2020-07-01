package com.example.tool_edit.services;

import com.example.tool_edit.model.FileModel;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class FileService {
    private static FileWriter file;
    public static void main(String[] args) {

        File folder = new File("folderTest");
        FileModel fileModel = new FileModel();
        fileModel.setName("root");
        fileModel.setParent(null);
        fileModel.setChildren(new ArrayList<>());
        listFilesForFolder(folder,fileModel);
        System.out.println(fileModel);
//        String json = "{\"dcmm\":\"123\"}";
//        try {
//            // Constructs a FileWriter given a file name, using the platform's default charset
//            file = new FileWriter("folderTest/hiep123/userinfo.json");
//            file.write(json);
//            System.out.println("Successfully Copied JSON Object to File...");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                file.flush();
//                file.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
    }
    public static void listFilesForFolder(final File folder,FileModel fileModel) {

        for (final File fileEntry : folder.listFiles()) {
            //thêm 1 file vào list file con
            FileModel childFile = new FileModel();
            childFile.setChildren(new ArrayList<>());
            childFile.setName(fileEntry.getName());
            fileModel.getChildren().add(childFile);
            //nếu file con là folder thì đệ quy
            if (fileEntry.isDirectory()) {
                childFile.setParent(fileModel);
                listFilesForFolder(fileEntry,childFile);
            } else {
                if(fileEntry.listFiles() == null || fileEntry.listFiles().length == 0) System.out.println("Hết file");
            }
        }
    }
}
