package com.solvd.bookingservice.services;

import com.solvd.bookingservice.bookingservices.Cancellation;
import com.solvd.bookingservice.daoclasses.CancellationDAO;

public class CancellationServices {
    private final CancellationDAO cancellationDAO;

    public CancellationServices() {
        this.cancellationDAO = new CancellationDAO();
    }

    public Cancellation getCancellationById(long id) throws InterruptedException {
        return this.cancellationDAO.getEntityById(id);
    }

    public void updateCancellation(Cancellation cancellation) throws InterruptedException {
        this.cancellationDAO.updateEntity(cancellation);
    }

    public Cancellation createCancellation(Cancellation cancellation) throws InterruptedException {
        return this.cancellationDAO.createEntity(cancellation);
    }

    public void deleteCancellation(long id) throws InterruptedException {
        this.cancellationDAO.removeEntity(id);
    }

}
