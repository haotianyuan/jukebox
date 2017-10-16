package controller_view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.MusicPlayList;
import model.Song;
import model.User;
import java.io.File;
import java.net.URI;



/*===============================================================
|Author:      Haotian Yuan Jiaming Hao
|
|Class name:  JukeBoxStartGUI
|
|Description: This program is a functional spike to determine 
|             the interactions are actually working. It is an 
|             event-driven program with a graphical user interface 
|             to affirm the functionality all Iteration 1 tasks have 
|             been completed and are working correctly.
*==============================================================*/

public class JukeboxStartGUI extends Application {
	private Label label1 = new Label("Account Name");
	private Label label2 = new Label("Password");
	private GridPane window = new GridPane();
	private TextField textField1 = new TextField("");
	private PasswordField textField2 = new PasswordField();
	private Button button1 = new Button("Log in");
	private Label label3 = new Label("Login first");
	private Label status = new Label();
	private Button button2 = new Button("Log out");
	private Button button3 = new Button("Select song 1");
	private Button button4 = new Button("Select song 2");
	private Button button5 = new Button("Manage");
	private HBox Hbox = new HBox();
	// ------------------------------------------------------
	// Following code composites the Accounts management interface
	private ObservableList<User> userList = FXCollections.observableArrayList();
	private ObservableList<User> subList;
	private ListView<User> displayList = new ListView<User>();
	private Stage newStage = new Stage();
	private BorderPane all = new BorderPane();
	private TextField searchBar = new TextField();
	private Button removeButton = new Button("Remove Selected Account");
	private Button addAccountButtton = new Button("Add New Account");
	private HBox hbox = new HBox();
	// ------------------------------------------------------------
	// Following code composites the Add Accounts interface
	private Stage newStage2 = new Stage();
	private GridPane all2 = new GridPane();
	private TextField textField3 = new TextField("");
	private TextField textField4 = new TextField("");
	private Label label4 = new Label("New Account Name: ");
	private Label label5 = new Label("Password: ");
	private Label label6 = new Label("*Note: Spaces will be ignored");
	private Button comfirmButton = new Button("Add");
	private RadioButton normal = new RadioButton("Normal");
	private RadioButton admin = new RadioButton("Admin");
	private ToggleGroup group = new ToggleGroup();
	private String type;// indicate what kind of account created
	// ------------------------------------------------------
	private MusicPlayList playlist = new MusicPlayList();
	private static MediaPlayer mediaPlayer;
	private boolean vertify = false;
	private User user;
	private boolean isplaying = false;
	//-----------------------------------set up two songs in advance---------------------------
	private Song song1 = new Song("songfiles/Capture.mp3");//for button3
	private Song song2 = new Song("songfiles/DanseMacabreViolinHook.mp3");//for button4

	public static void main(String[] args) {
		launch(args);
	}

	/*---------------------------------------------------------------------
	  |  Method: start
	  |
	  |  Purpose:    A method needs to be override from Application
	  |  
	  |  Parameters: Stage stage
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	@Override
	public void start(Stage primaryStage) {
		// -----------------------set up the userList-----------------------------
		User a = new User("Chris", "1", false);
		User b = new User("Devon", "22", false);
		User c = new User("River", "333", false);
		User d = new User("Ryan", "4444", false);
		User e = new User("Merlin", "7777777", true);

		userList.add(a);
		userList.add(b);
		userList.add(c);
		userList.add(d);
		userList.add(e);
		// ----------------------------------------------------------------------
		window.setPadding(new Insets(0, 8, 0, 5));
		GridPane.setHalignment(label2, HPos.RIGHT);
		window.add(Hbox, 0, 0, 2, 2);
		Hbox.setPadding(new Insets(0, 15, 0, 15));
		Hbox.setSpacing(15);
		Hbox.getChildren().addAll(button3, button4);
		
		window.setHgap(10);
		window.setVgap(10);
		window.add(label1, 0, 3);
		window.add(label2, 0, 4);
		textField1.setMaxWidth(130);
		window.add(textField1, 1, 3);
		textField2.setMaxWidth(130);
		window.add(textField2, 1, 4);
		window.add(button1, 1, 5);
		window.add(label3, 1, 6);
		window.add(button2, 1, 7);
		//---------------------------------------------------------------
		window.add(button5, 1, 5);
		button5.setVisible(false);
		window.add(status, 0, 3,2,3);
		status.setVisible(false);
		
		button1.setOnAction(new buttonListener());
		button2.setOnAction(new buttonListener());
		button5.setOnAction(new buttonListener());
		button3.setOnAction(new addsongbuttonListener());
		button4.setOnAction(new addsongbuttonListener());
		// ---------------------------------------------------------------------------
		
		Scene scene = new Scene(window, 290, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		// -------------------------------------------------
		// Following code is the layout of Accounts management interface
		all.setTop(searchBar);
		displayList.setItems(userList);
		all.setCenter(displayList);
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setSpacing(30);
		hbox.getChildren().addAll(removeButton, addAccountButtton);
		all.setBottom(hbox);
		Scene sc = new Scene(all, 430, 600);
		newStage.setScene(sc);
		// ----------------------------------------------------
		// Following code is the layout of Add Accounts interface
		newStage2.setTitle("Add New Account");
		Scene sc2 = new Scene(all2, 350, 200);
		all2.setVgap(15);
		all2.setHgap(15);
		all2.add(label4, 1, 0);
		all2.add(textField3, 2, 0);
		textField3.setMaxWidth(100.0);
		all2.add(label5, 1, 1);
		all2.add(textField4, 2, 1);
		textField4.setMaxWidth(100.0);
		all2.add(label6, 1, 2, 3, 1);
		all2.add(normal, 1, 3);
		all2.add(admin, 2, 3);
		all2.add(comfirmButton, 2, 4, 3, 3);
		normal.setToggleGroup(group);
		admin.setToggleGroup(group);
		newStage2.setScene(sc2);
		normal.setSelected(true);
		type = "Normal";// default is normal account
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
				RadioButton text = (RadioButton) t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
				// System.out.println("Selected Radio Button - " + text.getText());//debug
				type = text.getText();
			}
		});
		// -----------------------------------------------------

	}
	/*---------------------------------------------------------------------
	  |  Method: playsongs
	  |
	  |  Purpose:   A method used to play songs in a separate thread
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public void playsongs() {
		// System.out.println(playlist.getList().size());//debug
		while (isplaying == false && playlist.getList().size() != 0) {
			String path = playlist.getList().get(0).getPath();
			//System.out.println(playlist.getList().get(0).getPath());//debug
			File file = new File(path);
			URI uri = file.toURI();
			Media media = new Media(uri.toString());
			// Play the song
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.play();
			isplaying = true;
			mediaPlayer.setOnEndOfMedia(new EndOfSongHandler());
		}

	}
	/*===============================================================
	|Class name:  buttonListener
	|
	|Description:  Class includes method calling different methods 
	|              depending on which button has been pressed by user            
	*==============================================================*/
	private class buttonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			
			String ID = textField1.getText();
			String password = textField2.getText();
			boolean isAdmin = false;
			
			if (button1 == arg0.getSource()) {
				for (int i = 0; i < userList.size(); i++) {
					// check if the account and password are valid
					if (userList.get(i).getPassword().compareTo(password) == 0
							&& userList.get(i).getAccountName().compareTo(ID) == 0) {
						vertify = true;
						user = userList.get(i); 
						//---------------------following part change the GUI-------------
						textField1.setVisible(false);
						textField2.setVisible(false);
						label1.setVisible(false);
						label2.setVisible(false);
						button1.setVisible(false);
						label3.setVisible(false);
						status.setVisible(true);
						status.setText("		  	   Hello, " + user.getAccountName() + "\n");
							
						// ------------------------------This is what I added---------------
						isAdmin = userList.get(i).getAdmin();
						System.out.println("The current user is:" + user.getAccountName());// debug
						//label3.setText("Already logged in");
						// -------------------------------------------
						break;
					} else {
						label3.setText("Invalid account");
					}
				}
			}
			
			if (isAdmin) 
			{
				button5.setVisible(true);
			} 
			if(button5 == arg0.getSource())
			{
				newStage.show();
				registerListeners();
			}
			// if the log out button is pressed, check whether there is a user logged in
			if (button2 == arg0.getSource() && vertify == true) 
			{
				System.out.println("User: " + user.getAccountName() + " logged out");//debug
				vertify = false;
				textField1.clear();
				textField2.clear();
				textField1.setVisible(true);
				textField2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				button1.setVisible(true);
				label3.setVisible(true);
				status.setVisible(false);
				button5.setVisible(false);
				label3.setText("Login first");
				newStage.close();
			}
		}
		/*---------------------------------------------------------------------
		  |  Method: registerListeners
		  |
		  |  Purpose:   Call methods to set the search bar and remove and add button
		  |  
		  |  Parameters: None
		  |
		  |  Returns:    None
		  *-------------------------------------------------------------------*/
		private void registerListeners() 
		{
			searchBar.textProperty().addListener(new SearchBarListener());
			removeButton.setOnAction(new RemoveButtonListener());
			addAccountButtton.setOnAction(new addAccountButtonListener());
		}

	}
	/*===============================================================
	|Class name:  addsongbuttonListener
	|
	|Description:  Class includes method handling the songs selected 
	|              by user through pressing addSong Button
	*==============================================================*/
	private class addsongbuttonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			
			if (vertify == true) 
			 {
				// if a user already logged in successfully
				boolean hint = false;
				if (button3 == arg0.getSource()) {
					// add song1
					if (user.selectSong()) {
						hint = playlist.add(song1);
						//System.out.println(hint);//debug
						if(!hint)
						{
							user.recovChance();
							status.setText("Song1 already selected 3 times today");
						}
						else
						{
							status.setText("   Song1 has been added to the list");
						}
					} else {
						System.out.println("User: " + user.getAccountName() + " already runs out of chances");// debug
						status.setText("   Sorry, You run out today's times");
					}
				}
				if (button4 == arg0.getSource()) {
					if (user.selectSong()) {
						hint = playlist.add(song2);
						System.out.println(hint);
						if (!hint) {
							user.recovChance();
							status.setText("Song2 already selected 3 times today");
						}
						else
						{
							status.setText("   Song2 has been added to the list");
						}
					} else {
						System.out.println("User: " + user.getAccountName() + " already runs out of chances");// debug
						status.setText("   Sorry, You run out today's times");
					}
				}
				playsongs();

			}
		}
	}

	/*===============================================================
	|Class name:  SearchBarListener
	|
	|Description:  Class includes method setting the searchBar
	*==============================================================*/
	private class SearchBarListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue<? extends String> obs, String old, String newValue) {
			subList = FXCollections.observableArrayList();
			for (User user : userList) {
				if (user.getAccountName().indexOf(newValue) >= 0)
					subList.add(user);
			}
			displayList.setItems(subList);
		}
	}

	/*===============================================================
	|Class name:  RemoveButtonListener
	|
	|Description:  Class includes method setting the Remove Button
	*==============================================================*/
	private class RemoveButtonListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			User userToBeMoved = displayList.getSelectionModel().getSelectedItem();
			removeButton.setText("Remove Selected Account");
			if(userToBeMoved.getAccountName().equals(user.getAccountName()))
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
			    alert.setHeaderText("An Account Can Not Remove Itself");
			    alert.showAndWait();
				return;
			}
			
			if (subList != null)
				subList.remove(userToBeMoved);

			userList.remove(userToBeMoved);
		}
	}
	/*===============================================================
	|Class name:  addAccountButtonListener
	|
	|Description:  Class includes method setting addAccountButton
	*==============================================================*/
	private class addAccountButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			newStage2.show();
			comfirmButton.setOnAction(new comfirmButtonListener());
		}

	}
	/*===============================================================
	|Class name:  comfirmButtonListener
	|
	|Description:  Class includes method setting confirmButton
	*==============================================================*/
	private class comfirmButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			String newAcName = textField3.getText();
			String newPw = textField4.getText();
			// erase the trailing and leading spaces 
			newAcName = newAcName.trim();
			newPw = newAcName.trim();
			if (newAcName.equals("") || newPw.equals("")) {
				label6.setText("Invalid Account Name or Password");
				return;
			}
			for (User user : userList)// check if the account name already exists
			{
				if (user.getAccountName().equals(newAcName)) {
					label6.setText("Account Name already exists");
					return;
				}
			}
			boolean accountType = false;

			if (type.equals("Admin"))
				accountType = true;

			User newOne = new User(newAcName, newPw, accountType);
			userList.add(newOne);
			System.out.println("Newly added account is: " + type);// debug
			textField3.clear();
			textField4.clear();
			label6.setText("*Note: Spaces will be ignored");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
		    alert.setHeaderText("New Account: " + newAcName + " has been created ");
		    alert.showAndWait();
			newStage2.close();

		}

	}
	/*===============================================================
	|Class name:  EndOfSongHandler
	|
	|Description:  Class used for play songs, it implements runnable, so
	|              can be run in a new separate thread
	*==============================================================*/
	private class EndOfSongHandler implements Runnable {
		@Override
		public void run() {
			isplaying = false;
			playlist.getList().remove(0);// delete the song 
			playsongs();
		}
	}

}
