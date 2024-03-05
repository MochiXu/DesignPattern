package java_design.decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
