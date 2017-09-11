package projetodog.com.edu.projetodog.Other;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by edu-f on 17/08/2017.
 */
//AddCães

public class AddCaes {

    Dog d1 = new Dog("https://i.pinimg.com/236x/a2/a4/77/a2a477dab1d678d17d21c296538e584f--zumba-rottweiler-pictures.jpg","Thor","5","Rottweiler","Teresina","PI","50 kg","79,35 cm","67 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio"," 10","10 ","scb/08/00505","Poseidon Latino brasileiro","Rapunzel da Silva mexicana",0,1,0,1);

    Dog d2 = new Dog("https://i.pinimg.com/564x/82/35/f0/8235f0179fb3999947b1e8708ed57343.jpg","Lessy","3","Rottweiler","Teresina","PI","42 kg","72,35 cm","63 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio","5","01/10/2017","scb/07/00905","Zeuz da Silva Sauro","Pedrita beltrano",1,0,1,1);

    Dog d3 = new Dog("https://i.pinimg.com/originals/5b/01/f9/5b01f97840a50845c93cb704585aaf74.jpg","Pedrita","10","Rottweiler","Teresina","PI","41 kg","71,35 cm","62 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio","4","01/12/2017","scb/08/10505","Bob Marley Jamaicano","Cindel fulana",1,0,1,1);

    Dog d4 = new Dog("http://www.okaz.com.sa/new/issues/20141224/Images/m21.jpg","Beth","4","Rottweiler","Teresina","PI","40 kg","70,35 cm","61 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio","5","13/09/2017","scb/08/30505","Marley ingles","Preta pretinha do Brasil",1,0,1,1);

    Dog d5 = new Dog("https://i.pinimg.com/564x/c4/0d/a9/c40da96f6ce084d707b252113eb3e516.jpg","Margo","5","Rrottweiler","Teresina","PI","39 kg","69,35 cm","60 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio","3","13/09/2017","","","",1,0,0,0);
    Dog d6 = new Dog("https://i.pinimg.com/236x/a2/a4/77/a2a477dab1d678d17d21c296538e584f--zumba-rottweiler-pictures.jpg","Thor","5","Rottweiler","Teresina","PI","50 kg","79,35 cm","67 cm","preta",
            "castanho avermelhado","amigavel","pacifico","corajoso","medio"," 10","10 ","scb/08/00505","Poseidon Latino brasileiro","Rapunzel da Silva mexicana",0,1,0,1);



    List<Dog> lista;
    List<Dog> lista1;

    public List<Dog> returnDogs(){
        lista = new ArrayList<Dog>();
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);


        return lista;

        }

        public List<Dog> returnMyDogList(){
            lista1 = new ArrayList<>();
            lista1.add(d6);
            return lista1;
        }

    public List<Dog> returnMyDogs(){
        List<Dog> my = new ArrayList<>();
        for (int i = 0; i<returnMyDogList().size(); i++){
                my.add(returnMyDogList().get(0));
        }
        return my;
    }

    public List<Dog> returnFavorites(){
        List<Dog> favorites = new ArrayList<>();
        for (int i = 1; i<returnDogs().size(); i++){
            if(returnDogs().get(i).getFavorito()==1){
                favorites.add(returnDogs().get(i));

            }
        }
        return favorites;
    }
    public List<Dog> returnTodos(){
        List<Dog> todos = new ArrayList<>();
        for (int i = 1; i<returnDogs().size(); i++){
            if(returnDogs().get(i).getMeu() == 1){
                todos.add(returnDogs().get(i));

            }
        }
        return todos;
    }
}
