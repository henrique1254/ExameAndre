package com.example.exameandre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView CãoRecy;
    private EditText ednome;
    private EditText edraca;
    private EditText edgenero;

    private List<Dog> listacao = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CãoRecy = findViewById(R.id.listagem);
        criar();

        Adapter adaptador = new Adapter(this.listacao);


        //configurar layout

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        CãoRecy.setLayoutManager(layoutManager);
        CãoRecy.setHasFixedSize(true);
        CãoRecy.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        CãoRecy.setAdapter(adaptador);
    }

    public void criar() {
        Dog Caozinho = new Dog("Cachorro1", "labrador", "masculino");
        this.listacao.add(Caozinho);

        Caozinho = new Dog("Cachorro2", "labrador", "masculino");
        this.listacao.add(Caozinho);

        Caozinho = new Dog("Cachorro3", "labrador", "masculino");
        this.listacao.add(Caozinho);

        Caozinho = new Dog("Cachorro4", "labrador", "masculino");
        this.listacao.add(Caozinho);
    }


}