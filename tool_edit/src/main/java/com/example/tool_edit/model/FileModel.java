package com.example.tool_edit.model;

import java.util.List;

public class FileModel implements Comparable {
    private String name;
    private double size;
    private String type;
    private boolean isDirectory;
    private String path;
    private String pathJson;
    private String pathFormat;
    private String pathJsonFormat;
    private String parent;
    private String parentFormat;
    private long lastModified;
    private List<FileModel> children;
    private boolean isConfirm;

    public String getParentFormat() {
        return parentFormat;
    }

    public void setParentFormat(String parentFormat) {
        this.parentFormat = parentFormat;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public String getPathJsonFormat() {
        return pathJsonFormat;
    }

    public void setPathJsonFormat(String pathJsonFormat) {
        this.pathJsonFormat = pathJsonFormat;
    }

    public String getPathJson() {
        return pathJson;
    }

    public void setPathJson(String pathJson) {
        this.pathJson = pathJson;
    }

    public String getPathFormat() {
        return pathFormat;
    }

    public void setPathFormat(String pathFormat) {
        this.pathFormat = pathFormat;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<FileModel> getChildren() {
        return children;
    }

    public void setChildren(List<FileModel> children) {
        this.children = children;
    }

    @Override
    public int compareTo(Object o) {
        FileModel other = (FileModel)o;
        if(this.isConfirm && other.isConfirm){
            return 0;
        }
        if(this.isConfirm && !other.isConfirm){
            return 1;
        }
        if(!this.isConfirm && other.isConfirm){
            return -1;
        }
        return 0;
    }
}
