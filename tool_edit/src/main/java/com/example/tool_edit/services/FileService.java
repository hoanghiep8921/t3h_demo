package com.example.tool_edit.services;

import com.example.tool_edit.model.FileModel;
import com.example.tool_edit.model.JsonModel;
import com.example.tool_edit.util.Utils;
import com.google.common.io.Files;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private FileWriter file;
    public JsonModel readFileJson(String filePath){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        Object data = null;
        JsonModel model = null;
        try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            data = jsonParser.parse(reader);
            JSONObject response = (JSONObject) data;
            String jsonString = response.toJSONString();
            Gson gson = new Gson();
            model = gson.fromJson(jsonString,JsonModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return model;
    }
    public void writeJsonToFile(String json,String filePath){
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter(filePath);
            file.write(json);
            System.out.println("Successfully Copied JSON Object to File...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void listFilesForFolder(final File folder,FileModel fileModel,String pathJson) {
        String pathJsonFile = "";
        if(folder.getName().contains("mainpage")){
            pathJsonFile = pathJson;
        }
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.getName().contains(".json")){
                pathJsonFile = fileEntry.getPath();
            }
        }

        for (final File fileEntry : folder.listFiles()) {
            //thêm 1 file vào list file con
            FileModel childFile = new FileModel();
            childFile.setPathJson(pathJson);
            childFile.setPathJsonFormat(pathJson.replaceAll("\\\\",","));
            childFile.setChildren(new ArrayList<>());
            childFile.setName(fileEntry.getName());
            childFile.setDirectory(fileEntry.isDirectory());
            childFile.setPath(fileEntry.getPath());
            childFile.setPathFormat(fileEntry.getPath().replaceAll("\\\\",","));
            childFile.setLastModified(fileEntry.lastModified());
            childFile.setSize(Utils.bytesToMegabyte(fileEntry.length()));
            childFile.setType(Files.getFileExtension(fileEntry.getName()));

            fileModel.getChildren().add(childFile);
            //nếu file con là folder thì đệ quy
            if (fileEntry.isDirectory()) {
                childFile.setParent(fileModel);
                long folderSize = Utils.folderSize(fileEntry);
                childFile.setSize(Utils.bytesToMegabyte(folderSize));
                listFilesForFolder(fileEntry,childFile,pathJsonFile);
            } else {
                if(fileEntry.listFiles() == null || fileEntry.listFiles().length == 0)
                    System.out.println("Hết file");
            }
        }
    }
    public FileModel getFileInFolderByPath(List<String> breadcrumb,FileModel rootFolder){
        FileModel currentFolder = rootFolder;
        //get list file in current folder
        for(int i=0;i<breadcrumb.size();i++){
            String itemFolder = breadcrumb.get(i);
            FileModel childFolder = getChildFolder(itemFolder,currentFolder);
            if(childFolder != null){
                currentFolder = childFolder;
            }else{
                return currentFolder;
            }
        }
        if(currentFolder != null){
            return currentFolder;
        }else{
            return null;
        }
    }
    public FileModel getChildFolder(String folderName,FileModel root){
        for(FileModel f : root.getChildren()){
            if(f.getName().equals(folderName)){
                return f;
            }
        }
        return null;
    }

}
