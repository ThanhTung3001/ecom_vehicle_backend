package com.nghiem.market.entities.attachments;

import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.entities.products.Vehicle;
import jakarta.persistence.*;

@Table(name = "file_upload")
@Entity
public class FileUpload extends BaseEntity {
    public String fileName ;

    public String path ;

    public String severPath;

    public FileType fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


}
