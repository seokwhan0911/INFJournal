package com.um5th.hackerthon.infjournal.domain;

import com.um5th.hackerthon.infjournal.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Topic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String contents;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Essay> topicList = new ArrayList<>();
}
