package sample.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import sample.logic.DivisorCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField txtMinimum;

    @FXML
    private TextField txtMaximum;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    @FXML
    public void initialize() {
        progressBar.setProgress(0);
        progressLabel.setText("");
        resultLabel.setText("");

        startButton.setDisable(false);
        stopButton.setDisable(true);

        txtMinimum.setText("1");
        txtMaximum.setText("100000");
    }

    @FXML
    public void start()
    {
        Integer minimum = Integer.parseInt(txtMinimum.getText());
        Integer maximum = Integer.parseInt(txtMaximum.getText());

        startButton.setDisable(true);
        stopButton.setDisable(false);
        resultLabel.setText("");

        DivisorCounter counter = new DivisorCounter(minimum, maximum / 2);
        DivisorCounter counter2 = new DivisorCounter(maximum / 2, maximum);

        ProgressChangeListner progressChangeListner = new ProgressChangeListner();
        progressBar.progressProperty().bind(progressChangeListner.getProgressProperty());



        ResultChangeListener resultChangeListner = new ResultChangeListener();
        resultLabel.textProperty().bind(resultChangeListner.getTextProperty());

        counter.valueProperty().addListener(resultChangeListner);
        counter2.valueProperty().addListener(resultChangeListner);

        counter.progressProperty().addListener(progressChangeListner);
        counter2.progressProperty().addListener(progressChangeListner);
        progressChangeListner.setNumberOfTasks(2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(counter);
        executorService.execute(counter2);

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }
}

