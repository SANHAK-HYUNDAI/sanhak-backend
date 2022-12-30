package com.sanhak.backend.domain.RO.service;

import com.sanhak.backend.domain.RO.dto.request.ROPageRequest;
import com.sanhak.backend.domain.RO.dto.response.ROPageResponse;
import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ROService {

    private final RORepository roRepository;

    public ROPageResponse getROs(ROPageRequest roPageRequest) {
        Page<ROResponse> result = roRepository.findAll(roPageRequest.getPageRequest())
                .map(repairOrder -> new ROResponse(repairOrder));
        return new ROPageResponse(result);
    }
}
