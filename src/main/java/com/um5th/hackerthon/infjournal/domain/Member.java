package com.um5th.hackerthon.infjournal.domain;

import com.um5th.hackerthon.infjournal.domain.common.BaseEntity;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import com.um5th.hackerthon.infjournal.domain.mapping.Inbox;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nickname;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EssayScrap> essayScrapList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EssayLike> essayLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inbox> inboxList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Essay> essayList = new ArrayList<>();
}