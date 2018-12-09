import dao.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {    
    public static void main(final String[] args) throws Exception {
        launch(args);
    }
   
    public void start(Stage primaryStage) throws Exception {        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root, 1270, 710);
        scene.getStylesheets().add("/styles/Styles.css");
        primaryStage.setResizable(false);
        primaryStage.setTitle("Jogo dos Sons");        
        primaryStage.setScene(scene);        
        primaryStage.getIcons().add(new Image("/imagens/play.png"));       
        primaryStage.show();            
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateUtil.shutdown();
    }
}