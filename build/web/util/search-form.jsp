<%-- 
    Document   : search-form
    Created on : Apr 4, 2020, 3:24:59 PM
    Author     : Ebisu
--%>

<!DOCTYPE html>
<form class="form-inline" method="GET" action="SearchReportsController">
    <input
        class="form-control mr-sm-2"
        type="search"
        placeholder="Search for report"
        aria-label="Search"
        name="searchString"
        required
        />
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
        Search
    </button>
</form>