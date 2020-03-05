package com.example.sbhbase;

import org.apache.hadoop.conf.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.protobuf.ServiceException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

@SpringBootApplication
public class SbhbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbhbaseApplication.class, args);
        try {
            new SbhbaseApplication().connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws IOException, ServiceException {
        Configuration config = HBaseConfiguration.create();

        String path = this.getClass().getClassLoader().getResource("hbase-site.xml").getPath();

        config.addResource(new Path(path));

        try {
            HBaseAdmin.available(config);
        } catch (MasterNotRunningException e) {
            System.out.println("HBase is not running." + e.getMessage());
            return;
        }
//
//        HBaseClientOperations HBaseClientOperations = new HBaseClientOperations();
//        HBaseClientOperations.run(config);
    }
}
