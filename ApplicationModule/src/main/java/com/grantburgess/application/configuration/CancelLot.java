package com.grantburgess.application.configuration;

import com.grantburgess.ports.database.LotGateway;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Lot.cancelLot.CancelLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.cancelLot.CancelLotRequest;

public class CancelLot implements CancelLotInputBoundary {
    public CancelLot(LotGateway lotGateway, Clock clock) {
    }

    @Override
    public void execute(CancelLotRequest request) {

    }
}
