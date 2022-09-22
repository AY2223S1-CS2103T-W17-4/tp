package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.AnyCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonContainsAnyTagsPredicate;

/**
 * Parses input arguments and create a new AnyCommand object
 */
public class AnyCommandParser implements Parser<AnyCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AnyCommand
     * and returns a AnyCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AnyCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AnyCommand.MESSAGE_USAGE));
        }

        String[] selectedTags = trimmedArgs.split("\\s+");

        return new AnyCommand(new PersonContainsAnyTagsPredicate(Arrays.asList(selectedTags)));
    }
}
