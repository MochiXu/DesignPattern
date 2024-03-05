package java_design.decorator;

public class DataSourceDecorator implements DataSource{
    // 被 wrapper 的 DataSource
    private DataSource innerDataSource;

    public DataSourceDecorator(DataSource innerDataSource){
        this.innerDataSource = innerDataSource;
    }

    @Override
    public void writeData(String data) {
        System.out.println("execute -> DataSourceDecorator.writeData");
        this.innerDataSource.writeData(data);
    }

    @Override
    public String readData() {
        System.out.println("execute -> DataSourceDecorator.readData");
        return this.innerDataSource.readData();
    }
}
