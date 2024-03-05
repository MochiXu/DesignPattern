package java_design.decorator;

import java.io.*;

public class FileDataSource implements DataSource{
    private String fileName;
    public FileDataSource(String fileName){
        this.fileName = fileName;
    }
    // 将字符串数据写入到文件
    @Override
    public void writeData(String data) {
        System.out.println("execute -> FileDataSource.writeData");
        File file = new File(fileName);
        try (OutputStream ops = new FileOutputStream(file)) {
            ops.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println("exp happened when writeData:"+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // 返回文件中的内容
    @Override
    public String readData() {
        System.out.println("execute -> FileDataSource.readData");
        char[] buffer = null;
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
