package com.example.rti;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface RtiRequestRepository extends JpaRepository<RtiRequest,Long>{Optional<RtiRequest> findByRequestCode(String code); List<RtiRequest> findByOwnerId(Long ownerId);}