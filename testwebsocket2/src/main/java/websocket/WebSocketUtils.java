package websocket;

import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by phoenix on 7/3/17.
 */
public class WebSocketUtils extends WebSocketClient {
    public WebSocketUtils(URI serverUri , Draft draft ) {
        super( serverUri, draft );
    }

    public WebSocketUtils( URI serverURI ) {
        super( serverURI );
    }

    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        System.out.println( "opened connection" );
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "received: " + message );
    }

    @Override
    public void onFragment( Framedata fragment ) {
        System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
    }

    @Override
    public void onClose( int code, String reason, boolean remote ) {
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }

    public static void main( String[] args ) throws URISyntaxException {
        WebSocketImpl.DEBUG = true;
        WebSocketUtils c = new WebSocketUtils( new URI( "wss://be.huobi.com/ws" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance( "TLS" );
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            sslContext.init( null, null, null );
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            c.setSocket(factory.createSocket());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            c.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
