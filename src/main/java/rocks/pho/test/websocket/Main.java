package rocks.pho.test.websocket;

/**
 * Created by phoenix on 7/3/17.
 */


    public class Main {
        public static void main(String[] args) {
            try {
                WebSocketUtils.executeWebSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
