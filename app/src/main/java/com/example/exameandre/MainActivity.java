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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView CãoRecy;
    private EditText nome;
    private EditText raca;
    private EditText genero;

    private List<Dog> listacao = new ArrayList<>();
    private FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.name);
        raca = findViewById(R.id.ra);
        genero = findViewById(R.id.gen);

        IniciarFirebase();

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

    private void IniciarFirebase()
    {
        db = FirebaseDatabase.getInstance();
        db.setPersistenceEnabled(true);
        FirebaseApp.initializeApp(this);
        reference = db.getReference();
    }

    public void enviar(View view)
    {
        Dog Cachorro = new Dog();
        Cachorro.setNome(nome.getText().toString());
        Cachorro.setGenero(genero.getText().toString());
        Cachorro.setRaca(raca.getText().toString());

        reference.child("Dog").child(Cachorro.getNome()).setValue(Cachorro);
        Toast.makeText(getApplicationContext(),"ENVIADO", Toast.LENGTH_SHORT).show();
    }


}