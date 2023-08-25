package com.grantburgess.usecases.Fonctionnalite.addFonctionnalite;

import com.grantburgess.entities.Fonctionnalite;
import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.AddFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.AddFonctionnaliteRequest;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.NewFonctionnaliteResponse;

import java.util.UUID;

public class AddFonctionnalite implements AddFonctionnaliteInputBoundary {
    private final FonctionnaliteCreatedOutputBoundary presenter;
    private final FonctionnaliteGateway fonctionnaliteGateway;
    private final Clock clock;

    public AddFonctionnalite(FonctionnaliteCreatedOutputBoundary presenter, FonctionnaliteGateway fonctionnaliteGateway, Clock clock) {
        this.presenter = presenter;
        this.fonctionnaliteGateway = fonctionnaliteGateway;
        this.clock = clock;
    }

    public void execute(AddFonctionnaliteRequest request) {
        validateFonctionnalite(request);
        UUID id = addFonctionnalite(request);

        NewFonctionnaliteResponse responseModel = new NewFonctionnaliteResponse(id);
        presenter.present(responseModel);
    }

    private void validateFonctionnalite(final AddFonctionnaliteRequest request) {
        if (request.getEndDate().isBefore(request.getStartDate()))
            throw new FonctionnaliteGateway.fonctionnaliteStartDateGreaterThanEndDateException();
        if (request.getEndDate().isBefore(clock.now()))
            throw new FonctionnaliteGateway.fonctionnaliteEndDateCannotBeBeforeCurrentSystemDateException();
        if (FonctionnaliteAlreadyExists(request))
            throw new FonctionnaliteGateway.fonctionnaliteNameAlreadyExistsException();
    }

    private boolean FonctionnaliteAlreadyExists(final AddFonctionnaliteRequest request) {
        return fonctionnaliteGateway.existsByName(request.getName());
    }

    private UUID addFonctionnalite(AddFonctionnaliteRequest request) {
        return fonctionnaliteGateway.add(
                new Fonctionnalite (
                        request.getName(),
                        request.getDescription(),
                        request.getStartDate(),
                        request.getEndDate()
                )
        );
    }
}
