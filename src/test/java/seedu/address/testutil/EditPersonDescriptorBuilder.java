package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.ApplicationProcess;
import seedu.address.model.person.Date;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Position;
import seedu.address.model.person.Remark;
import seedu.address.model.person.Website;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setRemark(person.getRemark());
        descriptor.setPosition(person.getPosition());
        descriptor.setApplicationProcess(person.getApplicationProcess());
        descriptor.setDate(person.getDate());
        descriptor.setWebsite(person.getWebsite());
        descriptor.setTags(person.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setRemark(new Remark(address));
        return this;
    }

    /**
     * Sets the {@code Position} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPosition(String position) {
        descriptor.setPosition(new Position(position));
        return this;
    }

    /**
     * Sets the {@code ApplicationProcess} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withApplicationProcess(String applicationProcess) {
        descriptor.setApplicationProcess(new ApplicationProcess(applicationProcess));
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withDate(String date) {
        descriptor.setDate(new Date(date));
        return this;
    }

    /**
     * Sets the {@code Website} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withWebsite(String website) {
        descriptor.setWebsite(new Website(website));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
