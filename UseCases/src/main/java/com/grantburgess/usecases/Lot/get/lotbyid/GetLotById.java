package com.grantburgess.usecases.Lot.get.lotbyid;


import com.grantburgess.entities.Lot;
import com.grantburgess.ports.database.LotGateway;
import com.grantburgess.ports.presenters.Lot.LotOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Lot.get.Lotbyid.GetLotByIdInputBoundary;
import com.grantburgess.ports.usescases.Lot.get.Lotbyid.GetLotRequest;
import com.grantburgess.usecases.Lot.get.GetLotBase;

public class GetLotById extends GetLotBase implements GetLotByIdInputBoundary {
    private final LotOutputBoundary presenter;
    private final LotGateway offerGateway;
    private final Clock clock;

    public GetLotById(LotOutputBoundary presenter, LotGateway offerGateway, Clock clock) {
        this.presenter = presenter;
        this.offerGateway = offerGateway;
        this.clock = clock;
    }

    public void execute(GetLotRequest request) {
        Lot offer = offerGateway.getById(request.getId());

        if (offer == null)
            throw new LotGateway.LotNotFoundException();

        presenter.present(makeOfferResponse(offer, clock));
    }
}
