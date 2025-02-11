package com.penovatech.shopping.model;

import com.penovatech.common.model.AbstractPersistable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORY")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractPersistable<Long> {

    public Category(Long id) {
        super(id);
    }

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    private String iconUrl;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> childCategories = new ArrayList<>();
}
