package pupu;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.MessageHeader;
import sun.plugin.com.Utils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://j1.pupuapi.com/client/product/storeproduct/detail/deef1dd8-65ee-46bc-9e18-8cf1478a67e9/2266f16d-b00c-4739-acf3-3b06fd5017f0";
        Main m = new Main();
        m.getOut(url);

    }
        public void getOut(String url) throws IOException, InterruptedException {
            Main main = new Main();
            JSONObject jsonObject = JSONObject.parseObject(new Pupushop().httpRequest(url));
            JSONObject d = jsonObject.getJSONObject("data");
            Object name = (String) d.get("name");
            Object spec = (String) d.get("spec");
            Object price = (double) ((Integer) d.get("price")) / 100;
            Object market_price = (double) ((Integer)(d.get("market_price"))) / 100;
            Object share_content = d.get("share_content");
            System.out. println(" ---------------------商品:" + name + "-------------------");
            System.out.println("规格:" + spec);
            System.out.println("价格∶" + price);
            System.out.println("原价/折扣价︰"+market_price+" /"+price);
            System.out.println("详细信息:" + share_content);
            System.out.println(" ---------------------" + name +"的价格波动------------------");
            while (true){
                System.out.println("当前时间为："+DateTime()+"，价格为："+price);
                TimeIntervalTest();
            }

        }
        public static String DateTime(){
                //将现在的时间通过LocalDateTime解析为字符串类型并返回
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.now();
                String date = dateTime.format(formatter);
                return date;
    }
        public double getData(String str){
        //把字符转json
        JSONObject dataObject = JSONObject.parseObject(str);
        JSONObject data = dataObject.getJSONObject("data");
        return Double.parseDouble(data.get("price").toString())/100.00;
    }

    public void TimeIntervalTest() throws InterruptedException {
                // 开始时间
                long time = System.currentTimeMillis();
                // 执行时间（2s）
                Thread.sleep(2000);
                // 结束时间
                long time1 = System.currentTimeMillis();
    }
}
