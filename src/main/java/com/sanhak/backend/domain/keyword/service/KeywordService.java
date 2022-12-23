package com.sanhak.backend.domain.keyword.service;

import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.repository.KeywordRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    public List<KeywordResponse> getTop50Keywords() {

        List<KeywordResponse> result = keywordRepository.findTop50ByOrderByFrequencyDesc()
                .stream()
                .map(keyword -> new KeywordResponse(keyword.getWord(), keyword.getFrequency()))
                .collect(Collectors.toUnmodifiableList());

        return result;
    }
}
