package com.illidan.my_project_memo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.illidan.my_project_memo.R;
import com.illidan.my_project_memo.database.MemoVO;

public class MemoFragment extends Fragment {

    TextView txt_memo;
    Button btn_write_ok;
    Spinner cats;
    String strCat;
    FirebaseDatabase firebaseDatabase;

    public MemoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.memo_fragment,container,false);
        strCat = "일상메모";
        txt_memo = view.findViewById(R.id.memo_text);
        btn_write_ok = view.findViewById(R.id.memo_write_ok);
        firebaseDatabase = FirebaseDatabase.getInstance();

        btn_write_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMemo = txt_memo.getText().toString();
                MemoVO vo = new MemoVO(strMemo);
                DatabaseReference databaseReference = firebaseDatabase.getReference("my_memo");
                String pKey = databaseReference.push().getKey();

                vo.setMemoKey(pKey);
                vo.setMemoCat(strCat);
                databaseReference.child(pKey).setValue(vo);

                txt_memo.setText("");
                Toast.makeText(getContext(),cats.getSelectedItem()+" 저장완료",Toast.LENGTH_SHORT).show();
                cats.setSelection(0);
            }
        });
        cats = view.findViewById(R.id.memo_cat);
        cats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strCat = parent.getItemAtPosition(position).toString();
                if (strCat.equals("카테고리")) strCat = "일상메모";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;

    }
}
