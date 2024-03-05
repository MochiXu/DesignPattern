package java_design.decorator;

public class Demo {
    public static void main(String[] args){
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded =
                new CompressionDecorator(                               // 压缩装饰器
                    new EncryptionDecorator(                            // 加密装饰器
                        new FileDataSource("OutputDemo.txt")   // innerDataSource
                    )
                );
        System.out.println("- Try write encoded data -");
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input -----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded ---------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded ---------------");
        System.out.println(encoded.readData());
    }
}
