package info.tsukasaya.mybatistest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MyBatisの調査用
 *
 * @author tksy
 */
public class Main {

    public static void main(String... args) throws IOException {
        try {
            MyBatisTest test = new MyBatisTest();
            //MyBatisXMLTest test = new MyBatisXMLTest();
            test.exec();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
