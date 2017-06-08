package com.example.richardchen.smallap_cpp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.nio.ByteBuffer;

public class MainActivity extends Activity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);

        byte   b1 = 'A';
        byte[] b2 = new byte[]{'B', 'C', 'D'};
        byte[] b3 = {'E', 'F', 'G'};
        buffer.put(b1);
        buffer.put(b2);
        buffer.put(b3);
        char ch0 = (char) buffer.get(0);
        char ch2 = (char) buffer.get(2);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI(buffer));
        ch0 = (char) buffer.get(0);

    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(ByteBuffer buffer);
}
