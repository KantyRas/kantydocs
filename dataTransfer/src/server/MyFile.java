package server;

public class MyFile {
    private int id;
    private String name;
    private byte[] data;
    private String fileExtension;

    public MyFile(int id, String name, byte[] data, String fileExtension) {
        this.setId(id);
        this.setName(name);
        this.setData(data);
        this.setFileExtension(fileExtension);
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public byte[] getData() {
        return this.data;
    }
    public String getFileExtension() {
        return this.fileExtension;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
