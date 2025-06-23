package sample.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void listBooks() throws Exception {
        Book book = new Book("Title", "Author", "Desc");
        given(repository.findAll()).willReturn(Collections.singletonList(book));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Title"));
    }

    @Test
    void createBook() throws Exception {
        Book book = new Book("Title", "Author", "Desc");
        given(repository.save(any(Book.class))).willReturn(book);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.author").value("Author"));
    }

    @Test
    void getBook() throws Exception {
        Book book = new Book("Title", "Author", "Desc");
        given(repository.findById("1")).willReturn(Optional.of(book));

        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Desc"));
    }

    @Test
    void updateBook() throws Exception {
        Book existing = new Book("Title", "Author", "Desc");
        given(repository.findById("1")).willReturn(Optional.of(existing));
        given(repository.save(any(Book.class))).willReturn(existing);

        Book update = new Book("New", "NewAuth", "NewDesc");
        mockMvc.perform(put("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New"));
    }

    @Test
    void deleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
