package br.com.trainning.pdv.ui;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import br.com.trainning.pdv.R;
import br.com.trainning.pdv.domain.model.produto;
import se.emilsjolander.sprinkles.Query;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_novo) {
            Intent intent = new Intent(MainActivity.this,CadastroNovoActivity.class);
            startActivity(intent);
            Log.d("MainActivity","Selecionou novo produto");
            return true;

        }else if(id==R.id.action_edit){
            Intent telaEditarIntent = new Intent(MainActivity.this,EditarProdutoActivity.class);
            startActivity(telaEditarIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        List<produto> produtos = Query.all(produto.class).get().asList();
        if(produtos!=null) {
            for (produto p : produtos) {
                Log.d("produto", "id------------->" + p.getId());
                Log.d("produto", "descricao------>" + p.getDescricao());
                Log.d("produto", "unidade-------->" + p.getUnidade());
                Log.d("produto", "codigo barras-->" + p.getCodigoBarra());
                Log.d("produto", "preco---------->" + p.getPreco());
                Log.d("produto", "foto----------->" + p.getFoto());
                Log.d("produto", "-----------------------------------");

            }
        }
    }
}
