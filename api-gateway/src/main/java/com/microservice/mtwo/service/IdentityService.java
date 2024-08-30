package com.microservice.mtwo.service;

import com.microservice.mtwo.dto.ApiResponse;
import com.microservice.mtwo.dto.reponse.IntrospectResponse;
import com.microservice.mtwo.dto.request.IntrospectRequest;
import com.microservice.mtwo.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {

    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){
        return identityClient.introspect(IntrospectRequest.builder()
                .token(token)
                .build());
    }
}
