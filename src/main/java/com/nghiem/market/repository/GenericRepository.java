package com.nghiem.market.repository;
import com.nghiem.market.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

}