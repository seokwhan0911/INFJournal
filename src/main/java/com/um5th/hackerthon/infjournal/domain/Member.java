package com.um5th.hackerthon.infjournal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.um5th.hackerthon.infjournal.domain.common.BaseEntity;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import com.um5th.hackerthon.infjournal.domain.mapping.Inbox;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
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

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private TodayTopic todayTopic;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EssayScrap> essayScrapList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EssayLike> essayLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inbox> inboxList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Essay> essayList = new ArrayList<>();


    @OneToMany(mappedBy = "member")
    @JsonIgnoreProperties  // member 필드는 JSON 직렬화에서 제외
    private List<Essay> essays;
}