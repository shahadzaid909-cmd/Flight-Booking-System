package flight.booking.system;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40));

        Text welcomeMsg = new Text("Welcome To Our Flight Booking System ");
        welcomeMsg.setFont(Font.font("Tahoma", FontWeight.BOLD, 17));
        welcomeMsg.setFill(Color.ORANGE);

        grid.add(welcomeMsg, 0, 0, 2, 1);

        TextArea tArea = new TextArea();
        tArea.setEditable(false);

        grid.add(tArea, 0, 1, 2, 1);

        Button btn = new Button("Show List");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ArrayList<Flight> list = Main.flightList;
                String s = "";
                for (Flight f : list) {
                    s += f + "\n";
                    s+="--------------------------------\n";
                }
                tArea.setText(s);
            }

        });

        grid.add(btn, 0, 2);

        Scene scene = new Scene(grid, 400, 400, Color.YELLOW);

        stage.setScene(scene);
        stage.setTitle(" Flight Booking System");
        stage.show();
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
