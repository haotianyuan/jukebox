package controller_view;




/**
 * This program is a functional spike to determine the interactions are 
 * actually working. It is an event-driven program with a graphical user
 * interface to affirm the functionality all Iteration 1 tasks have been 
 * completed and are working correctly. This program will be used to 
 * test your code for the first 100 points of the JukeBox project.
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.User;

public class JukeboxStartGUI extends Application {
	private Label label1 = new Label("Account Name");
	private Label label2 = new Label("Password");
	private TextField textField1 = new TextField("");
	private TextField textField2 = new TextField("");
	private Button button1 = new Button("Login");
	private Label label3 = new Label("Login first");
	private Button button2 = new Button("Log out");
	private Button button3 = new Button("Select song 1");
	private Button button4 = new Button("Select song 2");
	//------------------------------------------------------ 
	//这一部分是作为管理者登录显示所有用户列表的界面的组成元素
	private ObservableList<User> userList = FXCollections.observableArrayList();
	private ObservableList<User> subList;
	private ListView<User> displayList = new ListView<User>();
	private Stage newStage = new Stage();
	private BorderPane all = new BorderPane();
    private TextField searchBar = new TextField();
    private Button removeButton = new Button("Remove Selected Account");
    private Button addAccountButtton = new Button("Add New Account");
    private HBox hbox = new HBox();
    //------------------------------------------------------------
    //这一部分是用户列表界面点击 Add New Account 显示界面的组成元素
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
	private String type;//提示所要添加的账户的类型
	//------------------------------------------------------
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		//-----------------------set up the userList-----------------------------
		User a = new User("Chris","1",false);
		User b = new User("Devon","22",false);
		User c = new User("River","333",false);
		User d = new User("Ryan","4444",false);
		User e = new User("Merlin","7777777",true);
		
		userList.add(a);
		userList.add(b);
		userList.add(c);
		userList.add(d);
		userList.add(e);
		//----------------------------------------------------------------------
		GridPane window = new GridPane();
		window.setPadding(new Insets(0, 5, 0, 5));
		GridPane.setHalignment(label2, HPos.RIGHT);
		// GridPane.setHalignment(label1, HPos.LEFT);
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
		window.add(button3, 0, 0);
		window.add(button4, 1, 0);
        //-----------------------------------this is I added----------------------------------
		button1.setOnAction(new buttonListener());//点击login 按钮直接显示所有用户列表， **需完善
		//---------------------------------------------------------------------------
		//这一部分是你原来写的
		Scene scene = new Scene(window, 250, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		//-------------------------------------------------
		//用户列表界面的布局
		all.setTop(searchBar);
	    displayList.setItems(userList);
	    all.setCenter(displayList);
	    hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setSpacing(30);
	    hbox.getChildren().addAll(removeButton, addAccountButtton);
	    all.setBottom(hbox);
	    Scene sc = new Scene(all, 450, 600);
	    newStage.setScene(sc);
	   //----------------------------------------------------
	    //添加新账户界面的布局
	    newStage2.setTitle("Add New Account");
	    Scene sc2 = new Scene(all2,350,200);
	    all2.setVgap(10);
		all2.setHgap(10);
		all2.add(label4, 1, 0);
		//GridPane.setHalignment(label4, HPos.RIGHT);
		all2.add(textField3, 2,0);
		textField3.setMaxWidth(100.0);
		all2.add(label5, 1, 1);
		all2.add(textField4, 2,1);
		textField4.setMaxWidth(100.0);
		all2.add(label6, 1, 2,3,1);
		all2.add(normal, 1, 3);
		all2.add(admin, 2, 3);
		all2.add(comfirmButton, 2, 4, 3, 3);
		normal.setToggleGroup(group);
		admin.setToggleGroup(group);
		newStage2.setScene(sc2);
		normal.setSelected(true);
		type = "Normal";//如不做修改， 默认添加的是非管理者账户
		//对于两个radio Buttons 的设置
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
				RadioButton text = (RadioButton) t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
				//System.out.println("Selected Radio Button - " + text.getText());//debug
				type = text.getText();
			}
		});
	    //-----------------------------------------------------

	}
	
	private class buttonListener implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent arg0) {
			boolean isAdmin = true;
			/** 
			* This is the part you need to put code to verify if the account 
			* successfully logged in is a admin account, if it is, then set
			* isAdmin to true, so the following can be executed
			*/
			//如果登陆的是管理员账户的话，要将 isAdmin 设置为 true， 这里我为了方便测试， 使其默认为 true
			if(isAdmin)
			{
				newStage.show();//展示用户列表界面
				registerListeners();//设置用户列表界面上的按钮与搜索条
		     }
			
		}

		private void registerListeners() {
			searchBar.textProperty().addListener(new SearchBarListener());
			removeButton.setOnAction(new RemoveButtonListener());
			addAccountButtton.setOnAction(new addAccountButtonListener());
		}
		
	}
	//这个 类 和老师提供例子中的基本一致
	private class SearchBarListener implements ChangeListener<String> 
	 {
		@Override
	    public void changed(ObservableValue<? extends String> obs, String old,
	        String newValue) {
			subList = FXCollections.observableArrayList();
	    	for(User user: userList)
	    	{
	    		if(user.getAccountName().indexOf(newValue) >= 0)
	    			subList.add(user);
	    	}
	    	displayList.setItems(subList);
	    }
	  }
	//同上，但是解决了老师给的例子中的bug
	private class RemoveButtonListener implements EventHandler<ActionEvent> {
	    @Override
	    public void handle(ActionEvent event) {
	    	User userToBeMoved = displayList.getSelectionModel().getSelectedItem();
	    	if(subList != null)
	    		subList.remove(userToBeMoved);
	    	
	    	userList.remove(userToBeMoved);
	    }
	  }
	
	private class addAccountButtonListener implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent arg0) {
			newStage2.show();//展示添加新账户的界面
			comfirmButton.setOnAction(new comfirmButtonListener());//设置添加新账户界面的按钮
		}
		
	}
	
	private class comfirmButtonListener implements  EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent arg0) {
			String newAcName = textField3.getText();
			String newPw = textField4.getText();
			//消除用户名与密码中头尾的空格
			newAcName = newAcName.trim();
			newPw = newAcName.trim();
			if(newAcName.equals("")||newPw.equals(""))
			{
				label6.setText("Invalid Account Name or Password");
				return;
			}
			for(User user: userList)//检查是否用户名已经存在
			{
				if(user.getAccountName().equals(newAcName))
				{
					label6.setText("Account Name already exists");
					return;
				}
			}
			boolean accountType = false;//提示所要新建的账户类型
			
			if(type.equals("Admin"))
				accountType = true;
			
			User newOne = new User(newAcName, newPw, accountType);
			userList.add(newOne);
			System.out.println("Newly added account is: " + type);//debug
			textField3.clear();//清除用户输入内容
			textField4.clear();
			label6.setText("*Note: Spaces will be ignored");//重置提示
			newStage2.close();//成功添加账户后则自动关闭添加界面
			
		}
		
	}

}