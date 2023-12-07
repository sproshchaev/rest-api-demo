package com.prosoft.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "well")
public class Well {
    @Id
    @Column("uwi")
    private Long uwi;
    @Column("well_name")
    private String wellName;
}
