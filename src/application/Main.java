
package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements EventHandler<WindowEvent>
{
	@Override
	public void start (Stage primaryStage)
	{
		try
		{
			
			//setUserAgentStylesheet(STYLESHEET_MODENA);			
			BorderPane root = (BorderPane) FXMLLoader.load (getClass ().getResource ("Principale.fxml"));
			Scene scene = new Scene (root);
			scene.getStylesheets ().add (getClass ().getResource ("application.css").toExternalForm ());
			primaryStage.setScene (scene);
			primaryStage.setResizable (false);
			primaryStage.setOnCloseRequest (this);
			primaryStage.setTitle("JMesureStep");
			primaryStage.setAlwaysOnTop (true);
//			File file = new File ("images/logo SIAJ2.png");
//			Image applicationIcon = new Image(file.toURI().toURL().toExternalForm());//(getClass().getResourceAsStream("images/logo siaj2.png"));
//	        primaryStage.getIcons().add(applicationIcon);
			primaryStage.show ();
			
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
	}

	public static void main (String [] args)
	{
		launch (args);
	}

	@Override
	public void handle (WindowEvent event)
	{
//		event.consume ();
//		int rep = JOptionPane.showConfirmDialog (null, "Etes- vous sur de vouloir quitter", "Confirmation" , JOptionPane.OK_OPTION);
//		
//		if (rep==0)
		System.exit (0);
		
	}
}
