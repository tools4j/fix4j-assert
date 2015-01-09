package org.fix4j.pad;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.fix4j.spec.fix50sp2.FixSpec;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * User: ben
 * Date: 8/01/15
 * Time: 7:14 AM
 */
public class PadController implements Initializable {
    @FXML private TextArea textAreaFrom;
    @FXML private TextArea textAreaTo;
    private FixSpecification fixSpecification;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        fixSpecification = FixSpec.INSTANCE;

        textAreaFrom.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textAreaTo.setText(convertInput(newValue));
            }
        });
    }

    public String convertInput(final String textFrom) {
        if(textFrom == null || textFrom.trim().length() == 0){
            return "";
        }
        try {
            final StringBuilder sb = new StringBuilder();
            final String[] lines = textFrom.split("\n\r?");
            for(int i=0; i<lines.length; i++){
                final String line = lines[i];
                try {
                    final FixMessage message = fixSpecification.parse(line);
                    sb.append(message.toPrettyString());
                } catch (Exception e) {
                    throw new RuntimeException("Error on line: " + (i+1), e);
                }
            }
            return sb.toString();

        } catch(Throwable e){
            String errorMessage = e.getMessage();
            while(e.getCause() != null && e.getCause() != e){
                e = e.getCause();
                errorMessage = errorMessage + "\n" + e.getMessage();
            }
            return errorMessage;
        }
    }
}
