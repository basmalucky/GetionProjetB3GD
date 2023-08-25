package com.grantburgess.database.jpa.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "Fonctionnalite")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FonctionnaliteData  {
    @Id
    private UUID id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}

