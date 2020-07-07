package com.example.tool_edit;

import com.example.tool_edit.model.FileModel;
import com.example.tool_edit.model.JsonModel;
import com.example.tool_edit.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static com.example.tool_edit.util.Constant.rootFolder;

@SpringBootApplication
public class ToolEditApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ToolEditApplication.class, args);
    }

    @Autowired
    FileService fileService;

    @Override
    public void run(String... args) throws Exception {
    }
}
