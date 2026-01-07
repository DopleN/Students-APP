import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    List<Student> data;
    StudentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance().getAllStudents();

        RecyclerView list = findViewById(R.id.student_list_recyvler);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        Button addBtn = findViewById(R.id.add_student_btn);
        addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewStudentActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public StudentViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.student_row_name);
            idTv = itemView.findViewById(R.id.student_row_id);
            cb = itemView.findViewById(R.id.student_row_check);
        }
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            return new StudentViewHolder(view);
        }

    @Override
public void onBindViewHolder(StudentViewHolder holder, int position) {
    Student s = data.get(position);
    holder.nameTv.setText(s.name);
    holder.idTv.setText(s.id);
    
    // 1. Set the initial state from the data
    holder.cb.setChecked(s.isChecked);

    // 2. Update the data when the user clicks the checkbox
    holder.cb.setOnClickListener(v -> {
        s.isChecked = holder.cb.isChecked();
    });

    // 3. Your row click logic to open details
    holder.itemView.setOnClickListener(v -> {
        Intent intent = new Intent(v.getContext(), StudentDetailsActivity.class);
        intent.putExtra("pos", position);
        v.getContext().startActivity(intent);
    });
}
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}