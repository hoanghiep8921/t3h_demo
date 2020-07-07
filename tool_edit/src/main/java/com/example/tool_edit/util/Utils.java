package com.example.tool_edit.util;

import java.io.File;
import java.text.DecimalFormat;

public class Utils {

    private static final long  MEGABYTE = 1024L * 1024L;
    private static final DecimalFormat df = new DecimalFormat("0.0000");

    public static double bytesToMegabyte(long bytes) {
        return Double.parseDouble(df.format((double)bytes / MEGABYTE));
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
