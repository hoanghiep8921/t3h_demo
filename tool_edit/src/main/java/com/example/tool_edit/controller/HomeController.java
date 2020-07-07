package com.example.tool_edit.controller;


import com.example.tool_edit.model.BreadCrumb;
import com.example.tool_edit.model.FileModel;
import com.example.tool_edit.model.JsonModel;
import com.example.tool_edit.model.Mainpage;
import com.example.tool_edit.services.FileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static com.example.tool_edit.util.Constant.rootFolder;

@Controller
public class HomeController {

    @Value("${root.folder}")
    private String rootFolderPath;

    @Autowired
    FileService fileService;
    @PostConstruct
    public void initRootFolder(){
        File folder = new File(rootFolderPath);
        //init root folder model

        rootFolder.setName(rootFolderPath);
        rootFolder.setParent(null);
        rootFolder.setChildren(new ArrayList<>());

        //put all children file to root
        fileService.listFilesForFolder(folder,rootFolder,"");

    }

    @RequestMapping("/home")
    private String home(@RequestParam(value = "breadcrumb",required = false) List<String> breadcrumb,
                        Model model){
        if(breadcrumb == null){
            breadcrumb = new ArrayList<>();
        }
        //render list breadcrumb
        List<BreadCrumb> renderBreadCrumb =  new ArrayList<>();
        BreadCrumb rootCrumb = new BreadCrumb();
        String currentPathBreadCrumb = "";
        rootCrumb.setName(rootFolderPath);
        rootCrumb.setPath("");
        renderBreadCrumb.add(rootCrumb);

        for(String item : breadcrumb){
            BreadCrumb breadCrumb = new BreadCrumb();
            breadCrumb.setName(item);
            if(currentPathBreadCrumb.isEmpty()){
                currentPathBreadCrumb += item;
            }else{
                currentPathBreadCrumb += "," + item;
            }
            breadCrumb.setPath(currentPathBreadCrumb);
            renderBreadCrumb.add(breadCrumb);
        }

        //get currentFolder by path
        FileModel currentFolder = fileService.getFileInFolderByPath(breadcrumb,rootFolder);
        model.addAttribute("currentFolder",currentFolder);
        model.addAttribute("rootFolder",rootFolder);
        model.addAttribute("renderBreadCrumb",renderBreadCrumb);
        if(breadcrumb != null && breadcrumb.size() > 0){
            model.addAttribute("currentFile",breadcrumb.get(breadcrumb.size()-1));
            model.addAttribute("breadcrumb",breadcrumb);
        }else{
            model.addAttribute("currentFile",rootFolderPath);
            model.addAttribute("breadcrumb","");
        }

        return "home";
    }

    @GetMapping("/readJson")
    @ResponseBody
    public JsonModel readJson(@RequestParam("path")String path) throws Exception {
        path = path.replaceAll(",","/");
        JsonModel jsonModel = fileService.readFileJson(path);
        if(jsonModel == null){
            throw new Exception("Lỗi đọc file");
        }
        return jsonModel;
    }
    @PostMapping("/writeJson")
    @ResponseBody
    public String writeJson(@RequestParam("path")String path,
                            @RequestBody JsonModel jsonModel) throws Exception {
        if(jsonModel == null){
            throw new Exception("Dữ  liệu không hợp lệ");
        }
        try {
            path = path.replaceAll(",","/");
            Gson gson = new Gson();
            String jsonString = gson.toJson(jsonModel);
//            fileService.writeJsonToFile(jsonString,path);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return "Thành công";
    }

    @GetMapping("/show")
    public ResponseEntity<Resource> getFile(@RequestParam("fileName") String filename) {
        String pathName = filename.replaceAll(",","/");
        Resource file = new FileSystemResource(pathName);
        if(file.exists() || file.isReadable()) {
            MediaType type = MediaType.ALL;
//        check file type image dạng gì
            if(filename.toLowerCase().endsWith("png")) {
                type = MediaType.IMAGE_PNG;
            }else if(filename.toLowerCase().endsWith("jpg") ||
                    filename.toLowerCase().endsWith("jpeg")) {
                type = MediaType.IMAGE_JPEG;
            }else if(filename.toLowerCase().endsWith("gif")) {
                type = MediaType.IMAGE_GIF;
            }
            return ResponseEntity.ok().contentType(type)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filenames=\"" + file.getFilename() + "\"")
                    .body(file);
        }else {
            throw new RuntimeException("FAIL!");
        }
    }
}
