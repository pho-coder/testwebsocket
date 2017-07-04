package websocket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by phoenix on 7/3/17.
 */


    public class Main {
        public static void main(String[] args) {
            System.out.println((new Long("123")));
            try {
                WSClient wsClient = new WSClient("wss://be.huobi.com/ws", "market.ethcny.depth.step1", 1000L);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
