package com.example.tool_edit.util;

import java.io.File;

public class Utils {

    private static final long  MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabyte(long bytes) {
        return bytes / MEGABYTE ;
    }
    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
