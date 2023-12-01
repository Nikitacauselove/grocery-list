package com.sber.grocerylist.author;

import com.sber.grocerylist.author.model.Author;
import com.sber.grocerylist.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Long userId, Author updatedAuthor) {
        Author author = findById(userId);

        author.setName(updatedAuthor.getName());
        author.setSurname(updatedAuthor.getSurname());
        return author;
    }

    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с указанным идентификатором не найден"));
    }

    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
