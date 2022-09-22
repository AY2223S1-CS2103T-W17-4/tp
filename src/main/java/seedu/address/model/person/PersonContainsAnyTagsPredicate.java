package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a Person has any of the given tag names.
 */
public class PersonContainsAnyTagsPredicate implements Predicate<Person> {
    private List<String> selectedTagNames;

    public PersonContainsAnyTagsPredicate(List<String> selectedTagNames) {
        this.selectedTagNames = selectedTagNames;
    }

    @Override
    public boolean test(Person person) {
        return selectedTagNames.stream()
                .anyMatch(tagName -> person.getTags().stream()
                        .anyMatch(tag -> tag.tagName.equalsIgnoreCase(tagName)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonContainsAnyTagsPredicate // instanceof handles nulls
                && selectedTagNames.equals(((PersonContainsAnyTagsPredicate) other).selectedTagNames)); // state check
    }
}
