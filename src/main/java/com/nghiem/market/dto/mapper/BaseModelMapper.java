package com.nghiem.market.dto.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseModelMapper {
    public UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;
}
