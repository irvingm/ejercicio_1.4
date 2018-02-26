package tdm2018.ittepic.edu.tdm2018_u1_reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();

    }

    private void llenarPersonajes() {
        listaPersonajes.add(new PersonajeVo("Irving Marin","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Lorena Lopez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Ximena Dominguez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Jose Beltran","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Noemi Gutierrez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Pedro Quiroz","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Martha Perez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Cesar Alvarez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
        listaPersonajes.add(new PersonajeVo("Guadalupe Mendez","No. Control"+"\n"+"Carrera",R.drawable.contacto));
    }

    public void onClick(View view) {

        switch (view.getId()){

        }
        construirRecycler();
    }

    private void construirRecycler() {
        listaPersonajes=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarPersonajes();

        AdaptadorPersonajes adapter=new AdaptadorPersonajes(listaPersonajes);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+listaPersonajes.get
                                (recyclerPersonajes.getChildAdapterPosition(view))
                                .getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerPersonajes.setAdapter(adapter);
    }
}
