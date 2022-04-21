package sample.ui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ProgressChangeListner implements ChangeListener<Number> {

    private SimpleDoubleProperty progressProperty;

    private double totalProgress;
    private double maxProgress;

    public ProgressChangeListner() {
        progressProperty = new SimpleDoubleProperty(0.0);
    }

    public ObservableValue<? extends Number> getProgressProperty() {
        return progressProperty;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        totalProgress += (newValue.doubleValue() - oldValue.doubleValue());
        progressProperty.set((totalProgress / maxProgress) / maxProgress);
    }

    public void setNumberOfTasks(int number) {
        maxProgress = number;
    }
}
