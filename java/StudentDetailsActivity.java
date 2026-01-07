import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        // Get the position of the student passed from the list
        int pos = getIntent().getIntExtra("pos", 0);
        Student s = Model.instance().getAllStudents().get(pos);

        TextView name = findViewById(R.id.details_name);
        TextView id = findViewById(R.id.details_id);
        TextView phone = findViewById(R.id.details_phone);
        TextView address = findViewById(R.id.details_address);
        CheckBox cb = findViewById(R.id.details_check);
        Button editBtn = findViewById(R.id.details_edit_btn);

        name.setText("Name: " + s.name);
        id.setText("ID: " + s.id);
        phone.setText("Phone: " + s.phone);
        address.setText("Address: " + s.address);
        cb.setChecked(s.isChecked);

      editBtn.setOnClickListener(v -> {
    Intent intent = new Intent(this, EditStudentActivity.class);
    // Pass the same position so the Edit screen knows which student to change
    intent.putExtra("pos", pos); 
    startActivity(intent);
});
    }
}

@Override
protected void onResume() {
    super.onResume();
    
    // Refresh the data on the screen in case it was edited
    int pos = getIntent().getIntExtra("pos", 0);
    Student s = Model.instance().getAllStudents().get(pos);

    TextView name = findViewById(R.id.details_name);
    TextView id = findViewById(R.id.details_id);
    TextView phone = findViewById(R.id.details_phone);
    TextView address = findViewById(R.id.details_address);
    CheckBox cb = findViewById(R.id.details_check);

    name.setText("Name: " + s.name);
    id.setText("ID: " + s.id);
    phone.setText("Phone: " + s.phone);
    address.setText("Address: " + s.address);
    cb.setChecked(s.isChecked);
}