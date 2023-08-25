package com.grantburgess.usecases.Lot.deleteLot;

import com.grantburgess.ports.database.LotGateway;
import com.grantburgess.ports.usescases.Lot.delete.DeleteLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.delete.DeleteLotRequest;


public class DeleteLot implements DeleteLotInputBoundary {
    private final LotGateway lotGateway;

    public DeleteLot(LotGateway lotGateway) {
        this.lotGateway = lotGateway;
    }

   /* public void execute(DeleteTaskRequest request) {
        lotGateway.delete(request.getId());
    }*/

    @Override
    public void execute(DeleteLotRequest request) {
        lotGateway.delete(request.getId());
    }
}
