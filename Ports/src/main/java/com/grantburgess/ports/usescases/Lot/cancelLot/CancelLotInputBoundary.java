package com.grantburgess.ports.usescases.Lot.cancelLot;

import com.grantburgess.ports.usescases.Task.cancelTask.CancelTaskRequest;

public interface CancelLotInputBoundary {
    void execute(CancelLotRequest request);
}
