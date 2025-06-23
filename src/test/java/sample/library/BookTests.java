package sample.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BookTests {
    @Test
    void bookProperties() {
        Book book = new Book("Title", "Author", "Desc");
        assertThat(book.getTitle()).isEqualTo("Title");
        assertThat(book.getAuthor()).isEqualTo("Author");
        assertThat(book.getDescription()).isEqualTo("Desc");

        book.setTitle("t2");
        book.setAuthor("a2");
        book.setDescription("d2");

        assertThat(book.getTitle()).isEqualTo("t2");
        assertThat(book.getAuthor()).isEqualTo("a2");
        assertThat(book.getDescription()).isEqualTo("d2");
    }
}
