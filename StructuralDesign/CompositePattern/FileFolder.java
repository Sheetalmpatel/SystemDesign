//Title:File System using Composite Pattern
package StructuralDesign.CompositePattern;

import java.util.*;

public class FileFolder {
	public void main (String[] args) {
        FileItem file1 = new File("file1.txt");
        FileItem file2 = new File("file2.txt");
        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");
       folder1.addItem(file2);

       folder2.addItem(file1);
       folder1.addItem(folder2);

       folder1.showDetails(" ");


    }
}

interface FileItem{
    void showDetails(String indent);
}

class File implements FileItem{
    String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public void showDetails(String indent) {
        System.out.println(indent+"File: " + name);
    }

}
class Folder implements FileItem{
    String name;
    List<FileItem> list = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addItem(FileItem item) {
        list.add(item);
    }
    @Override
    public void showDetails(String indent) {
        System.out.println(indent+"Folder: " + name);
        for(FileItem item : list){
            item.showDetails(indent+ " ");
        }
    }

}

