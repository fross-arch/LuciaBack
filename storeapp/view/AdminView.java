package storeapp.view;

import storeapp.domain.Admin;
import storeapp.services.AdminServiceImpl;

public class AdminView {

    private final AdminServiceImpl adminService;
    private final Admin admin;


    public AdminView(AdminServiceImpl adminService , Admin admin){
        this.adminService = adminService;
        this.admin = admin;
    }

    public void createAdmin(){
        adminService.createAdmin(admin);
    }


}
