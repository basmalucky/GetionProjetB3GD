package com.grantburgess.application.endpoints.Fonctionnalite.getFonctionnalites;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.GetFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.GetFonctionnaliteRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Fonctionnalites")
public class GetFonctionnalitesEndpoint implements BaseEndpoint {
    private final GetFonctionnaliteInputBoundary useCase;
    private final FonctionnalitesOutputBoundary presenter;

    public GetFonctionnalitesEndpoint(GetFonctionnaliteInputBoundary useCase, FonctionnalitesOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @GetMapping
    @ApiOperation(value = "Get fonctionnalites", response = FonctionnalitesViewModel.class)
    public ResponseEntity execute() {
        useCase.execute(new GetFonctionnaliteRequest());

        return ResponseEntity.ok(presenter.getViewModel());
    }
}
