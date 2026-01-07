import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class NewStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        EditText nameEt = findViewById(R.id.new_student_name);
        EditText idEt = findViewById(R.id.new_student_id);
        EditText phoneEt = findViewById(R.id.new_student_phone);
        EditText addressEt = findViewById(R.id.new_student_address);
        CheckBox cb = findViewById(R.id.new_student_check);
        Button saveBtn = findViewById(R.id.new_student_save_btn);
        Button cancelBtn = findViewById(R.id.new_student_cancel_btn);

        saveBtn.setOnClickListener(v -> {
            // Create a new Student object using the data from the screen
            Student s = new Student(
                nameEt.getText().toString(),
                idEt.getText().toString(),
                phoneEt.getText().toString(),
                addressEt.getText().toString(),
                cb.isChecked()
            );

            // This line MUST match your inMemory.java filename
            Model.instance().addStudent(s);
            
            // Go back to the list screen
            finish();
        });

        cancelBtn.setOnClickListener(v -> finish());
    }
}