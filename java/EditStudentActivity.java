public class EditStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        int pos = getIntent().getIntExtra("pos", 0);
        Student s = Model.instance().getAllStudents().get(pos);

        EditText nameEt = findViewById(R.id.edit_student_name);
        EditText idEt = findViewById(R.id.edit_student_id);
        EditText phoneEt = findViewById(R.id.edit_student_phone);
        EditText addressEt = findViewById(R.id.edit_student_address);
        CheckBox cb = findViewById(R.id.edit_student_check);

        nameEt.setText(s.name);
        idEt.setText(s.id);
        phoneEt.setText(s.phone);
        addressEt.setText(s.address);
        cb.setChecked(s.isChecked);

        findViewById(R.id.edit_student_save_btn).setOnClickListener(v -> {
            s.name = nameEt.getText().toString();
            s.id = idEt.getText().toString();
            s.phone = phoneEt.getText().toString();
            s.address = addressEt.getText().toString();
            s.isChecked = cb.isChecked();
            finish();
        });

        findViewById(R.id.edit_student_delete_btn).setOnClickListener(v -> {
            Model.instance().getAllStudents().remove(pos);
            finish();
        });

        findViewById(R.id.edit_student_cancel_btn).setOnClickListener(v -> finish());
    }
}
