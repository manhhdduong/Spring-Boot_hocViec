package com.dev.springbootKNDB.mapper;

import com.dev.springbootKNDB.dto.LapTopRequest;
import com.dev.springbootKNDB.dto.LapTopResponse;
import com.dev.springbootKNDB.entity.LapTop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LapTopMapper {
    LapTop toLapTop(LapTopRequest request);

    LapTopResponse toLapTopResponse(LapTop lapTop);
}
