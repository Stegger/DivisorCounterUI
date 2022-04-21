package sample.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import sample.logic.Result;

public class ResultChangeListener implements ChangeListener<Result> {

    private Result bestResultSoFar;
    private StringProperty textProperty;

    public ResultChangeListener() {
        textProperty = new SimpleStringProperty("");
        bestResultSoFar = new Result(-1, -1);
    }

    @Override
    public void changed(ObservableValue<? extends Result> observable, Result oldValue, Result newValue) {
        if (newValue.getDivisorCounter() > bestResultSoFar.getDivisorCounter()) {
            bestResultSoFar = newValue;
            String txtUpdate = "The number " + bestResultSoFar.getNumber() + " has " + bestResultSoFar.getDivisorCounter() + " divisors!";
            textProperty.setValue(txtUpdate);
        }
    }

    public ObservableValue<String> getTextProperty() {
        return textProperty;
    }

}
