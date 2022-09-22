package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Category;


/**
 * Parses input arguments and creates a new ListCommand object
 */
public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.length() == 0) {
            return new ListCommand(Category.NAME, false);
        }
        String[] keywords = trimmedArgs.split("\\s+");

        if (keywords.length == 1) {
            if (keywords[0].equals("true") || keywords[0].equals("false")) {
                boolean reverse = keywords[0].equals("true");
                return new ListCommand(Category.NAME, reverse);
            } else {
                try {
                    Category category = CategoryParser.parse(keywords[0]);
                    return new ListCommand(category, false);
                } catch (ClassNotFoundException cnf) {
                    throw new ParseException(
                            String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
                }
            }
        } else if (keywords.length == 2) {
            try {
                Category category = CategoryParser.parse(keywords[0]);
                boolean reverse = keywords[1].equals("true");
                return new ListCommand(category, reverse);
            } catch (ClassNotFoundException cnf) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
            }
        }

        throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));

    }
}
