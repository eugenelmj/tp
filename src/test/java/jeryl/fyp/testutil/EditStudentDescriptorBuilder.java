package jeryl.fyp.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jeryl.fyp.logic.commands.EditCommand.EditStudentDescriptor;
import jeryl.fyp.model.student.Address;
import jeryl.fyp.model.student.Email;
import jeryl.fyp.model.student.Name;
import jeryl.fyp.model.student.Student;
import jeryl.fyp.model.student.StudentID;
import jeryl.fyp.model.tag.Tag;

/**
 * A utility class to help with building EditStudentDescriptor objects.
 */
public class EditStudentDescriptorBuilder {

    private EditStudentDescriptor descriptor;

    public EditStudentDescriptorBuilder() {
        descriptor = new EditStudentDescriptor();
    }

    public EditStudentDescriptorBuilder(EditStudentDescriptor descriptor) {
        this.descriptor = new EditStudentDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditStudentDescriptor} with fields containing {@code student}'s details
     */
    public EditStudentDescriptorBuilder(Student student) {
        descriptor = new EditStudentDescriptor();
        descriptor.setName(student.getName());
        descriptor.setStudentID(student.getStudentID());
        descriptor.setEmail(student.getEmail());
        descriptor.setAddress(student.getAddress());
        descriptor.setProjectName(student.getProjectName());
        descriptor.setTags(student.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code StudentID} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withStudentID(String id) {
        descriptor.setStudentID(new StudentID(id));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code Project} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withProjectName(String projectName) {
        descriptor.setProjectName(projectName);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditStudentDescriptor}
     * that we are building.
     */
    public EditStudentDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditStudentDescriptor build() {
        return descriptor;
    }
}
