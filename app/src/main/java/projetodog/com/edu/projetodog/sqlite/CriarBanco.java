package projetodog.com.edu.projetodog.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by edu-f on 06/07/2017.
 */

public class CriarBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Pet.db";
    public static final String TABELA = "dog";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String RACA = "raca";
    public static final String IDADE = "idade";
    private static final int VERSAO = 1;

    public CriarBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME+ " text,"
                + RACA + " text,"
                + IDADE + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

