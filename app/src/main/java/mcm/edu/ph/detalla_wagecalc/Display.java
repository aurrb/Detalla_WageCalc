package mcm.edu.ph.detalla_wagecalc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {

    int hours, othours, wage, otwage, totalwage;
    String s_type;
    TextView total_wage, ot_wage, reg_wage, total_hours, ot_hours;
    Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        hours = intent.getIntExtra("hours", 0);
        s_type = intent.getStringExtra("type");
        switch (s_type) {
            case "probationary":
            case "Probationary":
                if (hours > 8) {
                    othours = hours - 8;
                    otwage = othours * 100;

                }
                wage = (hours - othours) * 90;
                totalwage = wage + otwage;
                break;
            case "part time":
            case "part-time":
            case "Part Time":
            case "Part-Time":
                if (hours > 8) {
                    othours = hours - 8;
                    otwage = othours * 90;

                }
                wage = (hours - othours) * 75;
                totalwage = wage + otwage;
                break;
            case "regular":
            case "Regular":
            default:
                if (hours > 8) {
                    othours = hours - 8;
                    otwage = othours * 115;

                }
                wage = (hours - othours) * 100;
                totalwage = wage + otwage;
                break;
        }
        total_wage = findViewById(R.id.totalwage);
        total_wage.setText(String.valueOf(totalwage));
        ot_wage = findViewById(R.id.overwage);
        ot_wage.setText(String.valueOf(otwage));
        reg_wage = findViewById(R.id.regwage);
        reg_wage.setText(String.valueOf(wage));
        total_hours = findViewById(R.id.totalhours);
        total_hours.setText(String.valueOf(hours));
        ot_hours = findViewById(R.id.overhours);
        ot_hours.setText(String.valueOf(othours));
        btn_return = findViewById(R.id.breturn);
        btn_return.setOnClickListener(v -> startActivity(new Intent(Display.this,Calculate.class)));
    }
}