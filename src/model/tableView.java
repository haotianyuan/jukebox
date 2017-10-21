package model;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class tableView extends TableView<Song>{
	
	private SongCollection songCollection;
	
	@SuppressWarnings("unchecked")
	public tableView() {
		TableColumn<Song, Integer> chance = new TableColumn<>("Plays");
		TableColumn<Song, String> title = new TableColumn<>("Title");
		TableColumn<Song, String> artist = new TableColumn<>("Artist");
		TableColumn<Song, String> time = new TableColumn<>("Time");
		chance.setCellValueFactory(new PropertyValueFactory<Song, Integer>("played"));
		title.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
		artist.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
		time.setCellValueFactory(new PropertyValueFactory<Song, String>("time"));
		this.getColumns().addAll(chance,title,artist,time);
		chance.setPrefWidth(60);
		title.setPrefWidth(180);
		artist.setPrefWidth(120);
		time.setPrefWidth(60);
		this.setMaxWidth(450);
		setObserverListToViewCurrentSongCollection();
		
	}
	
	@SuppressWarnings("unchecked")
	public tableView(SongCollection songList)
	{
		TableColumn<Song, Integer> chance = new TableColumn<>("Plays");
		TableColumn<Song, String> title = new TableColumn<>("Title");
		TableColumn<Song, String> artist = new TableColumn<>("Artist");
		TableColumn<Song, String> time = new TableColumn<>("Time");
		chance.setCellValueFactory(new PropertyValueFactory<Song, Integer>("played"));
		title.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
		artist.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
		time.setCellValueFactory(new PropertyValueFactory<Song, String>("time"));
		this.getColumns().addAll(chance,title,artist,time);
		chance.setPrefWidth(60);
		title.setPrefWidth(180);
		artist.setPrefWidth(120);
		time.setPrefWidth(60);
		this.setMaxWidth(450);
		this.songCollection = songList;
		ObservableList<Song> Songs = FXCollections.observableArrayList();
		for (int i = 0; i < songList.size(); i++) {
		      Songs.add(songList.get(i));
		  }
		 this.setItems(Songs);
		 this.getSelectionModel().select(0);
	
	}

	private void setObserverListToViewCurrentSongCollection()  {
		 songCollection = new SongCollection();
		ObservableList<Song> Songs = FXCollections.observableArrayList();
		 for (int i = 0; i < songCollection.size(); i++) {
		      Songs.add(songCollection.get(i));
		  }
		 this.setItems(Songs);
		 this.getSelectionModel().select(0);
	}

	public SongCollection getSongCollection()
	{
		return this.songCollection;
	}
}
