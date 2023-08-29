package com.grantburgess.application.endpoints.Projet.addProjet;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Projet.ProjetCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetCreatedViewModel;
import com.grantburgess.ports.usescases.Projet.addProjet.AddProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.addProjet.AddProjetRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/Projet")
public class AddProjetEndpoint implements BaseEndpoint {
    private final AddProjetInputBoundary useCase;
    private final ProjetCreatedOutputBoundary presenter;

    public AddProjetEndpoint(AddProjetInputBoundary useCase, ProjetCreatedOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @PostMapping
    @ApiOperation(value = "Add Projet", response = ProjetCreatedViewModel.class)
    public ResponseEntity execute(@RequestBody @Valid NewProjetRequest request) {
        useCase.execute(
                AddProjetRequest
                        .builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .startDate(request.getDuration().getStartDate())
                        .endDate(request.getDuration().getEndDate())
                        .build()
        );

        return ResponseEntity
                .created(
                        URI.create(
                                MessageFormat.format("/api/v1/Projets/{0}", presenter.getViewModel().getId())
                        )
                )
                .body(presenter.getViewModel());
    }
}
