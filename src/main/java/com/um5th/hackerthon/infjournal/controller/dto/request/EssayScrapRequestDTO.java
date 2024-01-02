package com.um5th.hackerthon.infjournal.controller.dto.request;

import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


public class EssayScrapRequestDTO {
    @Getter
    @Setter
    public static class AddEssayScrapDto{
         Long essayId;
    }
}
