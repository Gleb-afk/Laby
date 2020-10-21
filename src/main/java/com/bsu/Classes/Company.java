package com.bsu.Classes;

public class Company {
    private String name;
    private String shortName;
    private String dateOfActualization;
    private String address;
    private String dateOfFoundation;
    private String numberOfEmployees;
    private String auditor;
    private String phoneNumber;
    private String eMail;
    private String brunchOfWork;
    private String typeOfWork;
    private String webPage;

    public Company() {
        return;
    }

    public Company(String name, String shortName, String dateOfActualization, String address,
                   String dateOfFoundation, String numberOfEmployees, String auditor, String phoneNumber,
                   String eMail, String brunchOfWork, String typeOfWork, String webPage) {
        this.name = name;
        this.shortName = shortName;
        this.dateOfActualization = dateOfActualization;
        this.address = address;
        this.dateOfFoundation = dateOfFoundation;
        this.numberOfEmployees = numberOfEmployees;
        this.auditor = auditor;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.brunchOfWork = brunchOfWork;
        this.typeOfWork = typeOfWork;
        this.webPage = webPage;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getShortNameToLowerCase() {
        return shortName.toLowerCase();
    }
    public String getDateOfActualization() {
        return dateOfActualization;
    }

    public String getAddress() {
        return address;
    }

    public String getAuditor() {
        return auditor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEMail() {
        return eMail;
    }

    public String getWebPage() {
        return webPage;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public String getNumberOfEmployees()
    {
        return numberOfEmployees;
    }

    public String getBrunchOfWork() {
        return brunchOfWork;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    @Override
    public String toString() {
        return name + "," + shortName + "," + dateOfActualization + "," + address +
                "," + dateOfActualization + "," + numberOfEmployees + "," + auditor +
                "," + phoneNumber + "," + eMail + "," + brunchOfWork + "," +
                typeOfWork + "," +webPage + "\n";
    }

    public Company createCompany(String lineFromFile) {
        String[] field = lineFromFile.split(";");
        String name = field[0];
        String shortName = field[1];
        String dateOfActualization = field[2];
        String address = field[3];
        String dateOfFoundation = field[4];
        String numberOfEmployees = field[5];
        String auditor = field[6];
        String phoneNumber = field[7];
        String eMail = field[8];
        String brunchOfWork = field[9];
        String typeOfWork = field[10];
        String webPage = field[11];
        Company company = new Company(name, shortName, dateOfActualization, address,
                dateOfFoundation, numberOfEmployees, auditor, phoneNumber,
                eMail, brunchOfWork, typeOfWork, webPage);
        return company;
    }

    public String createToString() {
        String s;
        s = this.getName() + ';' + this.getShortName() + ';' + this.getDateOfActualization() + ';' +
                this.getAddress() + ';' + this.getDateOfFoundation() + ';' + this.getNumberOfEmployees() +
                ';' + this.getAuditor() + ';' + this.getPhoneNumber() + ';' + this.getEMail() + ';' +
                this.getBrunchOfWork() + ';' + this.getTypeOfWork() + ';' + this.getWebPage();

        return s;
    }

    public int getStringLengthOfCompany() {
        int ans = 0;
        ans = (getName() + getShortName() + getDateOfActualization() + getAddress() +
                getAuditor() + getPhoneNumber() + getEMail() + getWebPage() + getDateOfFoundation() +
                getNumberOfEmployees() + getBrunchOfWork() + getTypeOfWork()).length() + 12;

        return ans;
    }
}