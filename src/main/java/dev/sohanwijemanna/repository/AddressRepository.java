package dev.sohanwijemanna.repository;

import dev.sohanwijemanna.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
