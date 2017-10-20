package model;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;

import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;


public class tableView extends TableView<Song>{
	
	@SuppressWarnings("unchecked")
	public tableView() {
		TableColumn<Song, Integer> chance = new TableColumn<>("Plays");
		TableColumn<Song, String> title = new TableColumn<>("Title");
		TableColumn<Song, String> artist = new TableColumn<>("Artist");
		TableColumn<Song, Double> time = new TableColumn<>("Time");
		chance.setCellValueFactory(new PropertyValueFactory<Song, Integer>("played"));
		title.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
		artist.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
		time.setCellValueFactory(new PropertyValueFactory<Song, Double>("time"));
		this.getColumns().addAll(chance,title,artist,time);
		chance.setPrefWidth(60);
		title.setPrefWidth(200);
		artist.setPrefWidth(100);
		time.setPrefWidth(60);
		this.setMaxWidth(450);
		setObserverListToViewCurrentSongCollection();
		
	}

	private void setObserverListToViewCurrentSongCollection()  {
		SongCollection songList = new SongCollection();
		ObservableList<Song> Songs = FXCollections.observableArrayList();
		 for (int i = 0; i < songList.size(); i++) {
		      Songs.add(songList.get(i));
		  }
		 this.setItems(Songs);
		 this.getSelectionModel().select(0);
	}

}
