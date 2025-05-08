package com.example.demo.dto;

public class InvoiceRequestDTO {

    private String matchBy;
    private Integer rowsPerPage;
    private Integer currentPage;
    private String search;
    private String searchMode;
    private String sortBy;
    private String sortDirection;

    public InvoiceRequestDTO() {
    }

    public String getMatchBy() {
        return matchBy;
    }

    public void setMatchBy(String matchBy) {
        this.matchBy = matchBy;
    }

    public Integer getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(Integer rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
