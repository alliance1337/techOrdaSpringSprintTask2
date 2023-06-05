package kz.bitlab.springboot.techboot.dbconnect;

import kz.bitlab.springboot.techboot.db.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class MusicManager {

    @Autowired
    private DBConnector dbConnector;

    public ArrayList<Music> getMusicList(){
        ArrayList<Music> musics = new ArrayList<>();
        try {

            PreparedStatement preparedStatement =
                    dbConnector.getConnection().prepareStatement("select * from techbootdb.musics t order by t.id asc");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Music music = new Music();
                music.setId(resultSet.getLong("id"));
                music.setAuthor(resultSet.getString("author"));
                music.setName(resultSet.getString("name"));
                music.setDuration(resultSet.getInt("duration"));
                musics.add(music);

            }
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return musics;
    }

    public void addMusic(Music music){
        try {

            PreparedStatement preparedStatement =
                    dbConnector.getConnection().prepareStatement("" +
                            "INSERT INTO techbootdb.musics (name, duration, author) VALUES (?, ?, ?)");

            preparedStatement.setString(1, music.getName());
            preparedStatement.setInt(2, music.getDuration());
            preparedStatement.setString(3, music.getAuthor());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
