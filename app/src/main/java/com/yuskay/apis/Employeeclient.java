package com.yuskay.apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Employeeclient {

    @GET("employees")
    Call<List<Employee>> getEmployee();
}
