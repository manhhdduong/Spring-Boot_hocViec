package com.dev.springbootKNDB.service;

import com.dev.springbootKNDB.dto.LapTopRequest;
import com.dev.springbootKNDB.dto.LapTopResponse;
import com.dev.springbootKNDB.entity.LapTop;
import com.dev.springbootKNDB.mapper.LapTopMapper;
import com.dev.springbootKNDB.repository.LapTopRepository;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class LapTopService {
    @Autowired
    private LapTopRepository lapTopRepository;

    @Autowired
    private LapTopMapper lapTopMapper;

    public LapTopResponse createLapTop(LapTopRequest request){

        LapTop lapTop = lapTopMapper.toLapTop(request);

        if(lapTopRepository.existsByImei(request.getImei()))
            throw new RuntimeException("Imei da ton tai");

        lapTopRepository.save(lapTop);

        return lapTopMapper.toLapTopResponse(lapTop);
    }

    public List<LapTop> getAll(){
        return lapTopRepository.findAll();
    }

    public LapTop getOne(String id){
        return lapTopRepository.findById(id).orElseThrow(() -> new RuntimeException("not found!"));
    }

    public void deleteLapTop(String id){
        lapTopRepository.deleteById(id);
    }

    public LapTop updateLapTop(String id, LapTopRequest request){
        LapTop lapTop = lapTopRepository.findById(id).orElseThrow(() -> new RuntimeException("not found!"));

        lapTop.setName(request.getName());
        lapTop.setImei(request.getImei());
        lapTop.setPrice(request.getPrice());
        lapTop.setSize(request.getSize());
        lapTop.setDescription(request.getDescription());

        return lapTopRepository.save(lapTop);
    }

    public Page<LapTop> getLapTops(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return lapTopRepository.findAll(pageable);
    }
}
