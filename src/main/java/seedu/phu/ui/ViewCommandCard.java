package seedu.phu.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.phu.model.internship.Internship;

/**
 * A UI component that displays additional information of a specific {@code Internship}.
 */
public class ViewCommandCard extends UiPart<Region> {

    private static final String FXML = "ViewCommandCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/internshipbook-level4/issues/336">The issue on InternshipBook level 4</a>
     */

    public final Internship internship;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label remark;
    @FXML
    private Label email;
    @FXML
    private Label position;
    @FXML
    private Label applicationProcess;
    @FXML
    private Label date;
    @FXML
    private Label website;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code InternshipCode} with the given {@code Internship} and index to display.
     */
    public ViewCommandCard(Internship internship, int displayedIndex) {
        super(FXML);
        this.internship = internship;
        name.setText(internship.getName().fullName);
        phone.setText(internship.getPhone().value);
        remark.setText(internship.getRemark().value);
        email.setText(internship.getEmail().value);
        position.setText(internship.getPosition().positionName);

        String stateStyleClass = "application_process-" + internship.getApplicationProcess().toString();
        applicationProcess.getStyleClass().add(stateStyleClass);
        applicationProcess.setText(internship.getApplicationProcess().toString());
        date.setText(internship.getDate().toDisplayFormat());
        website.setText(internship.getWebsite().value);
        internship.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof InternshipCard)) {
            return false;
        }

        // state check
        ViewCommandCard card = (ViewCommandCard) other;
        return id.getText().equals(card.id.getText())
                && internship.equals(card.internship);
    }
}
