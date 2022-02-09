/**THE DATA ACCESS LAYER(Connecting to the database and the business logic client service)*/

package com.example.Mission.To.Mars.Registration.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Repository(Interface for data access

public interface ClientRepository
        extends JpaRepository<Client, Long> { // The object we want to work with(Client & id)



// finding user by email
    @Query("SELECT s FROM Client s WHERE s.email = ?1")
    Optional<Client> findClientByEmail(String email);
}
