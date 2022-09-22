package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.PersonContainsAnyTagsPredicate;

/**
 * Finds and lists all persons in address book that contains any of the argument tag names.
 * Tag name matching is case insensitive.
 */
public class AnyCommand extends Command {
    public static final String COMMAND_WORD = "any";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified tags (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: ANY [MORE_TAGS]...\n"
            + "Example: " + COMMAND_WORD + " friends colleagues";

    private final PersonContainsAnyTagsPredicate predicate;

    public AnyCommand(PersonContainsAnyTagsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AnyCommand // instanceof handles nulls
                && predicate.equals(((AnyCommand) other).predicate)); // state check
    }
}
