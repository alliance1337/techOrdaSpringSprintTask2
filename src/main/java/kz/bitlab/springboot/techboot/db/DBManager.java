package kz.bitlab.springboot.techboot.db;
import kz.bitlab.springboot.techboot.db.Music;

import java.util.ArrayList;


public class DBManager {
    private static final ArrayList<Music>musics = new ArrayList<>();
    private static Long id = 6L;

    static{
        musics.add(new Music(1L, "Music1", "Singer 1", 188));
        musics.add(new Music(2L, "Music2", "Singer 2", 189));
        musics.add(new Music(3L, "Music3", "Singer 3", 166));
        musics.add(new Music(4L, "Music4", "Singer 4", 168));
        musics.add(new Music(5L, "Music5", "Singer 5", 198));
        musics.add(new Music(5L, "Music6", "Singer 6", 250));
        musics.add(new Music(5L, "Music7", "Singer 7", 188));
        musics.add(new Music(5L, "Music8", "Singer 8", 220));
    }

    public static ArrayList<Music> getMusics(){
        return musics;
    }

    public static void addMusic(Music music){
        music.setId(id);
        id++;
        musics.add(music);
    }

    public static Music getMusic(int id){
        return musics.stream().filter(music -> music.getId()==id).findFirst().orElse(null);
    }

}
