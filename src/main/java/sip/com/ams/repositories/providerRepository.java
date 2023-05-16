package sip.com.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sip.com.ams.entites.provider;

@Repository
public interface providerRepository extends JpaRepository<provider, Long> {
}
