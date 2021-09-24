package com.krishana.webdev;

public class putPdf {
    public String nameofpdf;
    public String url;

    public putPdf() {
    }

    public putPdf(String nameofpdf, String url) {
        this.nameofpdf = nameofpdf;
        this.url = url;
    }

    public String getNameofpdf() {
        return nameofpdf;
    }

    public void setNameofpdf(String nameofpdf) {
        this.nameofpdf = nameofpdf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
