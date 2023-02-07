package com.solvd.bookingservice.services;
import com.solvd.bookingservice.daoclasses.OrganisationDao;
import com.solvd.bookingservice.bookingservices.Organisation;

public class OrganisationServices {
    private final OrganisationDao organisationDAO;

    public OrganisationServices() {
        this.organisationDAO = new OrganisationDao();
    }

    public Organisation getOrganizationById(long id) throws InterruptedException {
        return this.organisationDAO.getEntityById(id);
    }

    public void updateOrganization(Organisation organization) throws InterruptedException {
        this.organisationDAO.updateEntity(organization);
    }

    public Organisation createOrganization(Organisation organization) throws InterruptedException {
        return this.organisationDAO.createEntity(organization);
    }

    public void deleteOrganization(long id) throws InterruptedException {
        this.organisationDAO.removeEntity(id);
    }

}
