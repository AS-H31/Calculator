package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application {

	TextField tf = new TextField(" ");
	
	@Override
	public void start(Stage pStage) {
		
		
		Text ergebnis = new Text("Text");
		ergebnis.setFont(new Font("Arial", 18));
		ergebnis.setTextAlignment(TextAlignment.RIGHT);

		
		tf.setPrefSize(270, 15);
		tf.setAlignment(Pos.CENTER_RIGHT);
		
		// ____________________Buttons________________________
		// Numbers
		Button n1 = new Button("1");
		n1.setPrefSize(50, 50);
		Button n2 = new Button("2");
		n2.setPrefSize(50, 50);
		Button n3 = new Button("3");
		n3.setPrefSize(50, 50);
		Button n4 = new Button("4");
		n4.setPrefSize(50, 50);
		Button n5 = new Button("5");
		n5.setPrefSize(50, 50);
		Button n6 = new Button("6");
		n6.setPrefSize(50, 50);
		Button n7 = new Button("7");
		n7.setPrefSize(50, 50);
		Button n8 = new Button("8");
		n8.setPrefSize(50, 50);
		Button n9 = new Button("9");
		n9.setPrefSize(50, 50);
		Button n0 = new Button("0");
		n0.setPrefSize(105, 50);
		
		// Operatoren
		Button plus = new Button("+");
		plus.setPrefSize(50, 50);
		Button minus = new Button("-");
		minus.setPrefSize(50, 50);
		Button mal = new Button("*");
		mal.setPrefSize(50, 50);
		Button durch = new Button("/");
		durch.setPrefSize(50, 50);
		Button gleich = new Button("=");
		gleich.setPrefSize(50, 105);
		
		// Andere
		Button komma = new Button(",");
		komma.setPrefSize(50, 50);
		Button clear = new Button("C");
		clear.setPrefSize(50, 50);
		Button back = new Button("<-");
		back.setPrefSize(50, 50);
		
		
		
		
		// __________________________Layout______________________________
		GridPane root = new GridPane();
		root.setPadding(new Insets(10));
		root.setVgap(5);
		root.setHgap(5);
		//root.setGridLinesVisible(true);
		
		// Komponente zum Grid hinzufügen
		root.add(ergebnis, 1, 0);
		root.add(tf, 0, 1, 13, 1);
		
		// Zahlen und kommabuttons
		root.add(n7, 0, 2, 3,3);
		root.add(n8, 3, 2, 3,3);
		root.add(n9, 6, 2, 3,3);
		
		root.add(n4, 0, 5, 3,3);
		root.add(n5, 3, 5, 3,3);
		root.add(n6, 6, 5, 3,3);
		
		root.add(n1, 0, 8, 3,3);
		root.add(n2, 3, 8, 3,3);
		root.add(n3, 6, 8,3,3);
		
		root.add(n0, 0, 11, 6,3);
		root.add(komma, 6, 11,3,3);
		
		// Operationen
		root.add(plus, 9, 2, 3, 3);
		root.add(minus, 9, 5, 3, 3);
		root.add(mal, 9, 8, 3, 3);
		root.add(durch, 9, 11, 3, 3);
		
		// Andere
		root.add(clear, 12, 2, 3, 3);
		root.add(back, 12, 5, 3, 3);
		root.add(gleich, 12, 8, 3, 6);
		
		
		// ___________________Funktionalität__________________________
		// Buttons 
		// Wenn auf einer der Buttons gedruckt wird dann erscheint dieser
		// Zahl in der Textfield
		
		n1.setOnAction((ActionEvent e)-> {
			setNum("1");
		});
		n2.setOnAction((ActionEvent e)-> {
			setNum("2");
		});
		n3.setOnAction((ActionEvent e)-> {
			setNum("3");
		});
		n4.setOnAction((ActionEvent e)-> {
			setNum("4");
		});
		n5.setOnAction((ActionEvent e)-> {
			setNum("5");
		});
		n6.setOnAction((ActionEvent e)-> {
			setNum("6");
		});
		n7.setOnAction((ActionEvent e)-> {
			setNum("7");
		});
		
		n8.setOnAction((ActionEvent e)-> {
			setNum("8");
		});
		n9.setOnAction((ActionEvent e)-> {
			setNum("9");
		});
		n0.setOnAction((ActionEvent e)-> {
			setNum("0");
		});
		
		komma.setOnAction((ActionEvent e)-> {
			setNum(",");
		});
		plus.setOnAction((ActionEvent e)-> {
			setOperator(" + ");
		});
		minus.setOnAction((ActionEvent e)-> {
			setOperator(" - ");
		});
		mal.setOnAction((ActionEvent e)-> {
			setOperator(" * ");
		});
		durch.setOnAction((ActionEvent e)-> {
			setOperator(" : ");
		});
		//Andere
		clear.setOnAction((ActionEvent e)-> {
			tf.clear();
			tf.setText(" ");
		});
		back.setOnAction((ActionEvent e)->{
			char[] array = tf.getText().trim().toCharArray();
			char[] help = new char[array.length-1];
			for (int i = 0; i < array.length-1; i++) {
				help[i] = array[i];
			}
			tf.setText(String.valueOf(help).trim());
		});
		
		gleich.setOnAction((ActionEvent e)-> {
			
		});
		
		// ______________________Show_______________________________
		Scene sc = new Scene(root, 300, 300);
		pStage.setScene(sc);
		pStage.setMaxWidth(sc.getWidth());
		pStage.setMaxHeight(sc.getHeight());
		pStage.setX(1000);
		pStage.setTitle("Calculator");
		pStage.show();
		
		
		
		
	}
	
	public void setNum(String num) {
		if (tf.getText().equals("")) {
			tf.setText(num);
		}else {
			tf.setText(tf.getText() + num);
		}
	}
	
	public void setOperator(String num) {
		char[] array = tf.getText().toCharArray();
	
		if (array[array.length-1]== '+') {
			return;
		}else if (array[array.length-1]== '-') {
			return;
		}else if (array[array.length-1]== 'x') {
			return;
		}else if (array[array.length-1]== '/') {
			return;
		}else if (array[array.length-1]== ' ') {
			return;
		}else {
			setNum(num);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
