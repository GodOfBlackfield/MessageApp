package exportkit.example.messageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_send = findViewById(R.id.msg_send);
        EditText phone_no = findViewById(R.id.phone_no);
        EditText msg = findViewById(R.id.msg);
        MsgViewModel vm = new ViewModelProvider(this).get(MsgViewModel.class);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phone_no.getText().toString();
                String message = msg.getText().toString();
                boolean x = vm.check1(phone);
                boolean y = vm.check2(message);
                if (x && y) {
                    vm.initialise(phone,message);
                    vm.send();
                    Toast.makeText(getApplicationContext(), "Message Sent!", Toast.LENGTH_SHORT).show();
                }
                else if (x && !y) {
                    Toast.makeText(getApplicationContext(), "Message Too Long!", Toast.LENGTH_SHORT).show();
                }
                else if (!x && y) {
                    Toast.makeText(getApplicationContext(), "Invalid Phone Number!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Message Too Long and Invalid Phone number!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}