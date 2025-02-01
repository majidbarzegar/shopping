package com.penovatech.shopping.model;

import com.penovatech.common.model.AbstractPersistable;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_BANNER")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "BANNER_SEQ")
@NoArgsConstructor
public class Banner extends AbstractPersistable<Long> {

    public Banner(Long id, String imageUrl) {
        super(id);
        this.imageUrl = imageUrl;
    }

    public Banner(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String imageUrl;
}
