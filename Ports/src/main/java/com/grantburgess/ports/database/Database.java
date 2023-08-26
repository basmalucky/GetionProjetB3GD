package com.grantburgess.ports.database;

public interface Database {
    TaskGateway TaskGateway();
    ProjetGateway PROJET_GATEWAY();
    LotGateway LOT_GATEWAY();
    FonctionnaliteGateway FONCTIONNALITE_GATEWAY();
}
