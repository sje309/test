import java.io.Serializable;

/** @Author: shuyizhi @Date: 2018-07-30 9:30 @Description: 文件返回参数model */
public class FileModel implements Serializable {
    private static final long serialVersionUID = 3772747011437698661L;
    private String filePath;
    private long fileSize;
    private String fileName;
    private String fileParent;
    private boolean isCreate;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileParent() {
        return fileParent;
    }

    public void setFileParent(String fileParent) {
        this.fileParent = fileParent;
    }

    public boolean isCreate() {
        return isCreate;
    }

    public void setCreate(boolean create) {
        isCreate = create;
    }

    @Override
    public String toString() {
        return "FileModel["
                + "filePath='"
                + filePath
                + '\''
                + ", fileSize="
                + fileSize
                + ", fileName='"
                + fileName
                + '\''
                + ", fileParent='"
                + fileParent
                + '\''
                + ", isCreate="
                + isCreate
                + ']';
    }
}
