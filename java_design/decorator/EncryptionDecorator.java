package java_design.decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator{
    public EncryptionDecorator(DataSource innerDataSource) {
        super(innerDataSource);
    }

    // 加密后写入数据
    @Override
    public void writeData(String data) {
        System.out.println("execute -> EncryptionDecorator.writeData");
        super.writeData(this.encode(data));
    }

    // 读取数据后解密
    @Override
    public String readData() {
        System.out.println("execute -> EncryptionDecorator.readData");
        return this.decode(super.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
