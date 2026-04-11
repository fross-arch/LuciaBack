package storeapp.services;

import storeapp.domain.Admin;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl  implements AdminService {


    public AdminServiceImpl(Admin admin) {

    }

    @Override
    public Admin createAdmin(Admin admin) {
        return null;
    }

    @Override
    public Optional<Admin> getAdminById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> getAdminByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return List.of();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public void deleteAdmin(int id) {

    }
}
