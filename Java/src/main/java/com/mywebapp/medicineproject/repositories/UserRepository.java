package com.mywebapp.medicineproject.repositories;

import com.mywebapp.medicineproject.dao.Dao;
import com.mywebapp.medicineproject.dao.QPredicate;
import com.mywebapp.medicineproject.entities.Document;
import com.mywebapp.medicineproject.entities.Job;
import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mywebapp.medicineproject.entities.QUser.user;

@Repository
@Slf4j
public class UserRepository {

    private final Dao dao;

    public UserRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public User getById(Long id) {
        return dao.findById(User.class, id).orElseThrow();
    }

    public User addUser(UserInput userInput) {
        var user = User.builder()
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .birthdate(userInput.getBirthdate())
                .currentFrom(userInput.getCurrentFrom())
                .build();
        if (userInput.getJob() != null) {
            var job = Job.builder()
                    .name(userInput.getJob().getName())
                    .salary(userInput.getJob().getSalary())
                    .since(userInput.getJob().getSince())
                    .build();
            user.setJob(job);
        }
        if (userInput.getDocuments() != null
                && userInput.getDocuments().size() > 0) {
            List<Document> documentList = new ArrayList<>();
            userInput.getDocuments()
                    .forEach(documentInput -> {
                        var document = Document.builder()
                                .name(documentInput.getName())
                                .createdAt(documentInput.getCreatedAt())
                                .data(documentInput.getData())
                                .build();
                        documentList.add(document);
                    });
            user.setDocument(documentList);
        }
        return dao.add(user);
    }

    public List<User> findAllUsers() {
        return dao.getAll(User.class);
    }

    public List<User> findByFilters(String firstName, String lastName, LocalDate birthday, String currentFrom) {
        @Cleanup var session = dao.getSession();
        var predicate = QPredicate.builder()
                .add(firstName, user.firstName::eq)
                .add(lastName, user.lastName::eq)
                .add(birthday, user.birthdate::eq)
                .add(currentFrom, user.currentFrom::eq)
                .buildAnd();
        return new JPAQuery<User>(session)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }

    public void deleteUser(Long id) {
        dao.delete(id);
    }

    public void updateUser(User user) {
        dao.update(user);
    }
}
